package bg.softuni.mobilelele.web.controllers;

import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.web.model.UserLoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userLogin")
    public UserLoginModel userLoginModel() {
        return new UserLoginModel();
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute("userLogin") UserLoginModel userLoginModel,
                            RedirectAttributes redirectAttributes) {

        if (!userService.exists(userLoginModel)) {
            redirectAttributes.addFlashAttribute("loginError", true);

            return "redirect:/users/login";
        }

        userService.login(userLoginModel);
        return "redirect:/";
    }
}
