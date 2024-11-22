package bg.softuni.mvc_workshop.web.controllers;

import bg.softuni.mvc_workshop.service.EmployeeService;
import bg.softuni.mvc_workshop.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/export")
public class ExportController {

    private final EmployeeService employeeService;
    private final ProjectService projectService;

    public ExportController(EmployeeService employeeService, ProjectService projectService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping("/project-if-finished")
    public ModelAndView projectIfFinished() {
        ModelAndView modelAndView = new ModelAndView("/export/export-project-if-finished");
        modelAndView.addObject("projectsIfFinished", projectService.getFinishedProjects());

        return modelAndView;
    }

    @GetMapping("/employees-above")
    public ModelAndView employeesAbove() {
        ModelAndView modelAndView = new ModelAndView("/export/export-employees-with-age");
        modelAndView.addObject("employeesAbove", employeeService.findEmployeesAboveAge(25));
        return modelAndView;
    }
}
