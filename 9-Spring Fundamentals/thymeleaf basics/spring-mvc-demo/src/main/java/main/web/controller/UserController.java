package main.web.controller;

import main.model.User;
import main.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("users", userService.getAllUsers());
        modelAndView.setViewName("users");

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getUserDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);

        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-details");

        return modelAndView;
    }
}
