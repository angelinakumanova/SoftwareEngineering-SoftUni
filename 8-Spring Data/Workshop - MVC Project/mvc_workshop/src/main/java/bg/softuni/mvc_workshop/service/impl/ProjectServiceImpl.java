package bg.softuni.mvc_workshop.service.impl;

import bg.softuni.mvc_workshop.data.entities.Company;
import bg.softuni.mvc_workshop.data.entities.Project;
import bg.softuni.mvc_workshop.data.repositories.ProjectRepository;
import bg.softuni.mvc_workshop.service.CompanyService;
import bg.softuni.mvc_workshop.service.ProjectService;
import bg.softuni.mvc_workshop.service.model.imports.CompanyRootImportModel;
import bg.softuni.mvc_workshop.service.model.imports.ProjectRootImportModel;
import bg.softuni.mvc_workshop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    private static final String FILE_PATH = "src/main/resources/files/xmls/projects.xml";

    private final ProjectRepository projectRepository;
    private final CompanyService companyService;

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public ProjectServiceImpl(ProjectRepository projectRepository, CompanyService companyService, ModelMapper modelMapper, XmlParser xmlParser) {
        this.projectRepository = projectRepository;
        this.companyService = companyService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean isImported() {
        return this.projectRepository.count() > 0;
    }

    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public void seedData() throws JAXBException {
        xmlParser.fromFile(FILE_PATH, ProjectRootImportModel.class).getProjects()
                .stream()
                .map(p -> {
                    Project mappedProject = modelMapper.map(p, Project.class);
                    mappedProject.setCompany(companyService.findByName(p.getCompany().getName()).get());

                    return mappedProject;
                })
                .forEach(projectRepository::save);

        projectRepository.flush();
    }

    @Override
    public Optional<Project> findByName(String name) {
        return projectRepository.findByName(name);

    }
}
