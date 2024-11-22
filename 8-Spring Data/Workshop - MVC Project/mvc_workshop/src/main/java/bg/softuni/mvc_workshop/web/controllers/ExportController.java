package bg.softuni.mvc_workshop.web.controllers;

import bg.softuni.mvc_workshop.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/export")
public class ExportController {

    private final EmployeeService employeeService;

    public ExportController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees-above")
    public ModelAndView employeesAbove() {
        ModelAndView modelAndView = new ModelAndView("/export/export-employees-with-age");
        modelAndView.addObject("employeesAbove", employeeService.findEmployeesAboveAge(25));
        return modelAndView;
    }
}
