package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanoImportDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.function.Predicate;

@Service
public class VolcanoServiceImpl implements VolcanoService {
    private static final String VOLCANOES_PATH = "src/main/resources/files/json/volcanoes.json";

    private final VolcanoRepository volcanoRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public VolcanoServiceImpl(VolcanoRepository volcanoRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.volcanoRepository = volcanoRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.volcanoRepository.count() > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return new String(Files.readAllBytes(Path.of(VOLCANOES_PATH)));
    }

    @Override
    public String importVolcanoes() throws IOException {
        VolcanoImportDto[] volcanoesDtos = gson.fromJson(readVolcanoesFileContent(), VolcanoImportDto[].class);
        StringBuilder sb = new StringBuilder();

        Arrays.stream(volcanoesDtos)
                .filter(isValidVolcano(sb)).map(vd -> modelMapper.map(vd, Volcano.class))
                .forEach(volcano -> saveVolcano(volcano, sb));

        volcanoRepository.flush();
        return sb.toString();
    }

    private void saveVolcano(Volcano volcano, StringBuilder sb) {
        String formattedVolcano = String.format("Successfully imported volcano %s of type %s",
                volcano.getName(), volcano.getVolcanoType().name());
        sb.append(formattedVolcano).append(System.lineSeparator());

        volcanoRepository.save(volcano);
    }

    private Predicate<VolcanoImportDto> isValidVolcano(StringBuilder sb) {
        return vd -> {
            if (!validationUtil.isValid(vd) || volcanoRepository.findByName(vd.getName()).isPresent()) {
                sb.append("Invalid volcano").append(System.lineSeparator());
                return false;
            }

            return true;
        };
    }

    @Override
    public String exportVolcanoes() {
        return "";
    }
}