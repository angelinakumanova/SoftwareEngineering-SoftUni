package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CompanyImportDto;
import softuni.exam.models.dto.CompanyListImportDto;
import softuni.exam.models.entity.Company;
import softuni.exam.repository.CompanyRepository;
import softuni.exam.service.CompanyService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final static String COMPANIES_PATH = "src/main/resources/files/xml/companies.xml";

    private final CompanyRepository companyRepository;
    private final CountryService countryService;

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CompanyServiceImpl(CompanyRepository companyRepository, CountryService countryService, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.companyRepository = companyRepository;
        this.countryService = countryService;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.companyRepository.count() > 0;
    }

    @Override
    public String readCompaniesFromFile() throws IOException {
        return Files.readString(Path.of(COMPANIES_PATH));
    }

    @Override
    public String importCompanies() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(COMPANIES_PATH, CompanyListImportDto.class).getCompanies()
                .stream()
                .filter(c -> isValidCompany(c, sb))
                .map(this::mapToCompany)
                .forEach(country -> {
                    String formatted = String.format("Successfully imported company %s - %d",
                            country.getName(), country.getCountry().getId());
                    sb.append(formatted).append(System.lineSeparator());

                    companyRepository.save(country);
                });

        companyRepository.flush();
        return sb.toString();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    private Company mapToCompany(CompanyImportDto c) {
        Company mapped = modelMapper.map(c, Company.class);
        mapped.setCountry(countryService.findById(c.getCountryId()).get());

        return mapped;
    }

    private boolean isValidCompany(CompanyImportDto c, StringBuilder sb) {
        if (!validationUtil.isValid(c) || companyRepository.findByName(c.getName()).isPresent()) {
            sb.append("Invalid company").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}
