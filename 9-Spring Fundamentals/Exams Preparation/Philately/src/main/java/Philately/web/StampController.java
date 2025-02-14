package Philately.web;

import Philately.stamp.model.Stamp;
import Philately.stamp.service.StampService;
import Philately.user.model.User;
import Philately.user.service.UserService;
import Philately.web.dto.CreateNewStamp;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/stamps")
public class StampController {

    private final UserService userService;
    private final StampService stampService;

    public StampController(UserService userService, StampService stampService) {
        this.userService = userService;
        this.stampService = stampService;
    }

    @GetMapping("/new")
    public ModelAndView getNewStampPage(HttpSession session) {
        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getById(userId);

        ModelAndView modelAndView = new ModelAndView("add-stamp");
        modelAndView.addObject("user", user);
        modelAndView.addObject("createNewStamp", new CreateNewStamp());

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView addNewStamp(@Valid CreateNewStamp createNewStamp, BindingResult bindingResult, HttpSession session) {

        User user = userService.getById((UUID) session.getAttribute("user_id"));


        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("add-stamp");
            modelAndView.addObject("user", user);

            return modelAndView;
        }

        stampService.createNewStamp(createNewStamp, user);


        return new ModelAndView("redirect:/home");
    }
}
