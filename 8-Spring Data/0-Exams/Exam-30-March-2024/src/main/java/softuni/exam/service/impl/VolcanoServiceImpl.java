package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.VolcanoService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class VolcanoServiceImpl implements VolcanoService {
    private static final String VOLCANOES_PATH = "src/main/resources/files/json/volcanoes.json";

    private final VolcanoRepository volcanoRepository;

    public VolcanoServiceImpl(VolcanoRepository volcanoRepository) {
        this.volcanoRepository = volcanoRepository;
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
        return "";
    }

    @Override
    public String exportVolcanoes() {
        return "";
    }
}