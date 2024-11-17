package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final static String COUNTRIES_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFileContent() throws IOException {
        return Files.readString(Path.of(COUNTRIES_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCountriesFileContent(), CountryImportDto[].class))
                .filter(c -> isValidCountry(c, sb))
                .map(c -> modelMapper.map(c, Country.class))
                .forEach(c -> saveCountry(c, sb));


        countryRepository.flush();
        return sb.toString();
    }

    private void saveCountry(Country c, StringBuilder sb) {
        String formatted = String.format("Successfully imported country %s - %s",
                c.getName(), c.getCode());
        sb.append(formatted).append(System.lineSeparator());

        countryRepository.save(c);
    }

    private boolean isValidCountry(CountryImportDto c, StringBuilder sb) {
        if (!validationUtil.isValid(c)) {
            sb.append("Invalid country").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}
