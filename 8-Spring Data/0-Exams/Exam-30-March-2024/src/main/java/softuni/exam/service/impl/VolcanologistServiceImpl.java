package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanologistService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {
    private final static String VOLCANOLOGISTS_PATH = "src/main/resources/files/xml/volcanologists.xml";

    private final VolcanologistRepository volcanologistRepository;



    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository) {
        this.volcanologistRepository = volcanologistRepository;
    }

    @Override
    public boolean areImported() {
        return this.volcanologistRepository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(VOLCANOLOGISTS_PATH)));
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {
        return "";
    }
}