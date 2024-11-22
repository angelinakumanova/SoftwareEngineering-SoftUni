package bg.softuni.mvc_workshop.service.impl;

import bg.softuni.mvc_workshop.data.entities.Company;
import bg.softuni.mvc_workshop.data.repositories.CompanyRepository;
import bg.softuni.mvc_workshop.service.CompanyService;
import bg.softuni.mvc_workshop.service.model.imports.CompanyImportModel;
import bg.softuni.mvc_workshop.service.model.imports.CompanyRootImportModel;
import bg.softuni.mvc_workshop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final static String FILE_PATH = "src/main/resources/files/xmls/companies.xml";

    private final CompanyRepository companyRepository;

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean isImported() {
        return this.companyRepository.count() > 0;
    }

    @Override
    public String readFile() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public void seedData() throws JAXBException {
        xmlParser.fromFile(FILE_PATH, CompanyRootImportModel.class).getCompanies()
                .stream()
                .map(c -> modelMapper.map(c, Company.class))
                .forEach(companyRepository::save);

        companyRepository.flush();
    }


    @Override
    public Optional<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }
}
