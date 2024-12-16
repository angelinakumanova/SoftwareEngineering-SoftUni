package bg.softuni.pathfinder.web.controllers;

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

    @GetMapping("/register")
    public String register(Model model) {

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
                    "org.springframework.validation.BindingResult.UserRegisterModel", bindingResult);


            return "redirect:/users/register";
        }


        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost() {

        return "login";
    }
}
