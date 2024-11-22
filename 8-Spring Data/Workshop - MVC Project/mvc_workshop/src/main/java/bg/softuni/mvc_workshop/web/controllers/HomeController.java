package bg.softuni.mvc_workshop.web.controllers;

import bg.softuni.mvc_workshop.service.CompanyService;
import bg.softuni.mvc_workshop.service.EmployeeService;
import bg.softuni.mvc_workshop.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final ProjectService projectService;

    public HomeController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");

        boolean areImported = this.companyService.isImported() && this.employeeService.isImported() &&
                this.projectService.isImported();
        modelAndView.addObject("areImported", areImported);

        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
