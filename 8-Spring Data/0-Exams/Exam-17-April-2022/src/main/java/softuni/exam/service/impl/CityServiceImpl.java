package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CityServiceImpl implements CityService {
    private final static String CITIES_PATH = "src/main/resources/files/json/cities.json";

    private final CityRepository cityRepository;
    private final CountryService countryService;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CityServiceImpl(CityRepository cityRepository, CountryService countryService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCitiesFileContent(), CityImportDto[].class))
                .filter(c -> isValidCountry(c, sb))
                .map(this::mapToCity)
                .forEach(city -> saveCity(city, sb));

        cityRepository.flush();
        return sb.toString();
    }

    private void saveCity(City city, StringBuilder sb) {
        String formatted = String.format("Successfully imported city %s - %d",
                city.getName(), city.getPopulation());
        sb.append(formatted).append(System.lineSeparator());

        cityRepository.save(city);
    }

    private City mapToCity(CityImportDto c) {
        City map = modelMapper.map(c, City.class);
        map.setCountry(countryService.findById(c.getCountry()).get());

        return map;
    }

    private boolean isValidCountry(CityImportDto c, StringBuilder sb) {
        if (!validationUtil.isValid(c) || cityRepository.findByName(c.getName()).isPresent()) {
            sb.append("Invalid city").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}
