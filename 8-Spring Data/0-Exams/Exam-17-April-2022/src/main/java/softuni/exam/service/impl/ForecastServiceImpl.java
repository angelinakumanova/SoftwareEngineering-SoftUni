package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportDto;
import softuni.exam.models.dto.ForecastListImportDto;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {
    private final static String FORECASTS_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final CityService cityService;

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ForecastServiceImpl(ForecastRepository forecastRepository, CityService cityService, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.forecastRepository = forecastRepository;
        this.cityService = cityService;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(FORECASTS_PATH, ForecastListImportDto.class).getForecasts()
                .stream()
                .filter(f -> isValidForecast(f, sb))
                .map(f -> mapToForecast(f))
                .forEach(forecast -> saveForecast(forecast, sb));

        forecastRepository.flush();

        return sb.toString();
    }

    private void saveForecast(Forecast forecast, StringBuilder sb) {
        String formatted = String.format("Successfully import forecast %s - %.2f",
                forecast.getDayOfWeek().name(), forecast.getMaxTemperature());
        sb.append(formatted).append(System.lineSeparator());

        forecastRepository.save(forecast);
    }

    private Forecast mapToForecast(ForecastImportDto f) {
        Forecast map = modelMapper.map(f, Forecast.class);
        map.setDayOfWeek(f.getWeekday());
        map.setCity(cityService.findById(f.getCity()).get());

        return map;
    }

    private boolean isValidForecast(ForecastImportDto f, StringBuilder sb) {
        if (!validationUtil.isValid(f) || forecastRepository.findByCityIdAndDayOfWeek(f.getCity(), f.getWeekday()).isPresent()) {
            sb.append("Invalid forecast").append(System.lineSeparator());
            return false;
        }

        return true;
    }

    @Override
    public String exportForecasts() {
        return "";
    }
}
