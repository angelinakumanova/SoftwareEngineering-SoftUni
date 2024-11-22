package bg.softuni.mvc_workshop.service.impl;

import bg.softuni.mvc_workshop.data.entities.Employee;
import bg.softuni.mvc_workshop.data.entities.Project;
import bg.softuni.mvc_workshop.data.repositories.EmployeeRepository;
import bg.softuni.mvc_workshop.service.EmployeeService;
import bg.softuni.mvc_workshop.service.ProjectService;
import bg.softuni.mvc_workshop.service.model.exports.EmployeeAboveExportModel;
import bg.softuni.mvc_workshop.service.model.imports.EmployeeImportModel;
import bg.softuni.mvc_workshop.service.model.imports.EmployeeRootImportModel;
import bg.softuni.mvc_workshop.service.model.imports.ProjectRootImportModel;
import bg.softuni.mvc_workshop.util.XmlParser;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final static String FILE_PATH = "src/main/resources/files/xmls/employees.xml";

    private final EmployeeRepository employeeRepository;
    private final ProjectService projectService;

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectService projectService, ModelMapper modelMapper, XmlParser xmlParser) {
        this.employeeRepository = employeeRepository;
        this.projectService = projectService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean isImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public void seedData() throws JAXBException {
        xmlParser.fromFile(FILE_PATH, EmployeeRootImportModel.class).getEmployees()
                .stream()
                .map(e -> {
                    Employee mappedEmployee = modelMapper.map(e, Employee.class);
                    mappedEmployee.setProject(projectService.findByName(e.getProject().getName()).get());

                    return mappedEmployee;
                })
                .forEach(employeeRepository::save);

        employeeRepository.flush();
    }

    @Override
    public String findEmployeesAboveAge(Integer age) {
        StringBuilder sb = new StringBuilder();

        employeeRepository.findByAgeGreaterThan(age)
                .stream()
                .map(this::mapToExportModel)
                .forEach(employee -> {
                    String formatted = String.format("Name: %s%n" +
                            "  Age: %d%n" +
                            "  Project name: %s", employee.getFullName(), employee.getAge(), employee.getProjectName());
                    sb.append(formatted).append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    private EmployeeAboveExportModel mapToExportModel(Employee e) {
        Converter<Employee, String> fullNameConverter = ctx ->
                ctx.getSource().getFirstName() + " " + ctx.getSource().getLastName();

        return modelMapper.typeMap(Employee.class, EmployeeAboveExportModel.class)
                .addMappings(mapper ->
                        mapper.using(fullNameConverter).map(src -> src, EmployeeAboveExportModel::setFullName))
                .map(e);
    }
}
