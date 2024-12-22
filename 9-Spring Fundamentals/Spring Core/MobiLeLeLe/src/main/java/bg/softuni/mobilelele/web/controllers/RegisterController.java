package bg.softuni.mobilelele.web.controllers;

import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.web.model.UserRegisterModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegister")
    public UserRegisterModel registerUserModel() {
        return new UserRegisterModel();
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("userRegister") UserRegisterModel userModel,
                               BindingResult bindingResult,
                               RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userRegister", userModel);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userRegister", bindingResult);

            return "redirect:/users/register";
        }

        userService.registerUser(userModel);

        return "redirect:/";
    }
}
