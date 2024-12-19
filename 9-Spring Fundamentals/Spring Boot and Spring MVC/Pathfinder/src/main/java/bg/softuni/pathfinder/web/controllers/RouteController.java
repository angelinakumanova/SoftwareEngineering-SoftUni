package bg.softuni.pathfinder.web.controllers;

import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.dtos.RouteDetailsDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String routes(Model model) {
        model.addAttribute("routes", routeService.getAllRoutes());

        return "routes";
    }

    @GetMapping("/details/{id}")
    public String routeDetails(Model model, @PathVariable Long id) {
        RouteDetailsDto route = routeService.getRouteDetailsById(id);
        model.addAttribute("route", route);

        return "route-details";
    }
}
