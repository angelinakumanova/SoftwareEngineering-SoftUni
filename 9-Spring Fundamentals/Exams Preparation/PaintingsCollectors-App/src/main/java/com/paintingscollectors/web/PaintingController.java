package com.paintingscollectors.web;


import com.paintingscollectors.painting.service.PaintingService;
import com.paintingscollectors.user.model.User;
import com.paintingscollectors.user.service.UserService;
import com.paintingscollectors.web.dto.CreatePaintingRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/paintings")
public class PaintingController {

    private final UserService userService;
    private final PaintingService paintingService;

    public PaintingController(UserService userService, PaintingService paintingService) {
        this.userService = userService;
        this.paintingService = paintingService;
    }

    @GetMapping("/new")
    public ModelAndView getNewPaintingPage(HttpSession session) {

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getById(userId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-painting");
        modelAndView.addObject("user", user);
        modelAndView.addObject("createPaintingRequest", new CreatePaintingRequest());

        return modelAndView;
    }

    @PostMapping("/new")
    public String addNewPainting(HttpSession session, @Valid CreatePaintingRequest createPaintingRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new-painting";
        }


        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getById(userId);

        paintingService.createNewPainting(createPaintingRequest, user);

        return "redirect:/home";
    }

    @DeleteMapping("/{id}")
    public String deletePainting(@PathVariable UUID id) {

        paintingService.deletePaintingById(id);

        return "redirect:/home";
    }
}
