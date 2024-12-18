package bg.softuni.pathfinder.web.controllers;

import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.web.model.UserLoginModel;
import bg.softuni.pathfinder.web.model.UserRegisterModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (userService.isLoggedIn()) {
            return "redirect:/";
        }

        if (!model.containsAttribute("userModel")) {
            model.addAttribute("userModel", new UserRegisterModel());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid UserRegisterModel userModel,
                               BindingResult bindingResult,
                               RedirectAttributes rAtt) {


        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userModel", userModel);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userModel", bindingResult);

            if (userService.findByUsername(userModel.getUsername()).isPresent()) {
                bindingResult.rejectValue("username", "error.userModel", "Username is already occupied");
            }

            return "redirect:/users/register";
        }


        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (userService.isLoggedIn()) {
            return "redirect:/";
        }

        if (!model.containsAttribute("userModel")) {
            model.addAttribute("userModel", new UserLoginModel());
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginPost(UserLoginModel userModel, RedirectAttributes rAtt) {

        if (userService.findByUsernameAndPassword(userModel.getUsername(), userModel.getPassword()).isEmpty()) {
            rAtt.addFlashAttribute("userModel", userModel);
            rAtt.addFlashAttribute("loginError", "Invalid username or password!");

            return "redirect:/users/login";
        }

        userService.loginUser(userModel);
        return "redirect:/";
    }
}
