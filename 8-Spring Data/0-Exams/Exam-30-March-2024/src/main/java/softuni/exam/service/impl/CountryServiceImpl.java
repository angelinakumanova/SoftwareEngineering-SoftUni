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

@Service
public class CountryServiceImpl implements CountryService {
    private final static String COUNTRIES_PATH = "src/main/resources/files/json/countries.json";
    private final CountryRepository countryRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(COUNTRIES_PATH)));
    }

    @Override
    public String importCountries() throws IOException {
        CountryImportDto[] countriesDtos = gson.fromJson(readCountriesFromFile(), CountryImportDto[].class);
        StringBuilder sb = new StringBuilder();

        Arrays.stream(countriesDtos)
                .filter(cd -> isValidCountry(cd, sb))
                .map(cd -> modelMapper.map(cd, Country.class))
                .forEach(cd -> saveCountry(cd, sb));

        countryRepository.flush();
        return sb.toString();
    }

    private void saveCountry(Country cd, StringBuilder sb) {
        String formattedCountry = String.format("Successfully imported country %s - %s",
                cd.getName(), cd.getCapital());
        sb.append(formattedCountry).append(System.lineSeparator());

        countryRepository.save(cd);
    }

    private boolean isValidCountry(CountryImportDto cd, StringBuilder sb) {
        if (!validationUtil.isValid(cd) || countryRepository.findByName(cd.getName()).isPresent()) {
            sb.append("Invalid country").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}
