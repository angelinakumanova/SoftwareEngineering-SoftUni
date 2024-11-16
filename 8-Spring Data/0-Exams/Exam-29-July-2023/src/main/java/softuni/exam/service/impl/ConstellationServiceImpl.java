package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private final static String CONSTELLATIONS_PATH = "src/main/resources/files/json/constellations.json";

    private final ConstellationRepository constellationRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        ConstellationImportDto[] constellationsImport = gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class);
        StringBuilder sb = new StringBuilder();

        Arrays.stream(constellationsImport)
                .filter(c -> isValidConstellation(c, sb))
                .map(c -> modelMapper.map(c, Constellation.class))
                .forEach(c -> saveConstellation(c, sb));

        constellationRepository.flush();
        return sb.toString();
    }

    @Override
    public Optional<Constellation> findById(Long id) {
        return constellationRepository.findById(id);
    }

    private void saveConstellation(Constellation c, StringBuilder sb) {
        String formatted = String.format("Successfully imported constellation %s - %s",
                c.getName(), c.getDescription());

        sb.append(formatted).append(System.lineSeparator());
        constellationRepository.save(c);
    }

    private boolean isValidConstellation(ConstellationImportDto c, StringBuilder sb) {
        if (!validationUtil.isValid(c) || constellationRepository.findByName(c.getName()).isPresent()) {
            sb.append("Invalid constellation").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}
