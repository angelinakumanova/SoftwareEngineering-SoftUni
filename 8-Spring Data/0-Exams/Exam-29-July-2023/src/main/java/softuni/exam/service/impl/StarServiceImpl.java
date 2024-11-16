package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class StarServiceImpl implements StarService {
    private final static String STARS_PATH = "src/main/resources/files/json/stars.json";

    private final StarRepository starRepository;
    private final ConstellationService constellationService;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public StarServiceImpl(StarRepository starRepository, ConstellationService constellationService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.starRepository = starRepository;
        this.constellationService = constellationService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StarImportDto[] starsImport = gson.fromJson(readStarsFileContent(), StarImportDto[].class);
        StringBuilder sb = new StringBuilder();

        Arrays.stream(starsImport)
                .filter(s -> isValidStar(s, sb))
                .map(this::mapToStar)
                .forEach(s -> saveStar(s, sb));

        starRepository.flush();

        return sb.toString();
    }

    private void saveStar(Star s, StringBuilder sb) {
        String formatted = String.format("Successfully imported star %s - %.2f light years",
                s.getName(), s.getLightYears());
        sb.append(formatted).append(System.lineSeparator());

        starRepository.save(s);
    }

    private Star mapToStar(StarImportDto s) {
        Star map = modelMapper.map(s, Star.class);
        map.setConstellation(constellationService.findById(s.getConstellation()).get());

        return map;
    }

    private boolean isValidStar(StarImportDto s, StringBuilder sb) {
        if (!validationUtil.isValid(s) || starRepository.findByName(s.getName()).isPresent()) {
            sb.append("Invalid star").append(System.lineSeparator());
            return false;
        }

        return true;
    }

    @Override
    public String exportStars() {
        return "";
    }

    @Override
    public Optional<Star> findById(Long id) {
        return starRepository.findById(id);
    }
}
