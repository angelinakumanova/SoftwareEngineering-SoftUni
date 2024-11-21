package bg.softuni.mvc_workshop.service.impl;

import bg.softuni.mvc_workshop.data.repositories.CompanyRepository;
import bg.softuni.mvc_workshop.service.CompanyService;
import bg.softuni.mvc_workshop.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final static String FILE_PATH = "";

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


}
