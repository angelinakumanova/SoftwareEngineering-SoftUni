package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportDto;
import softuni.exam.models.dto.AstronomersListImportDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class AstronomerServiceImpl implements AstronomerService {
    private final static String ASTRONOMERS_PATH = "src/main/resources/files/xml/astronomers.xml";

    private final AstronomerRepository astronomerRepository;
    private final StarService starService;

    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarService starService, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.astronomerRepository = astronomerRepository;
        this.starService = starService;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        List<AstronomerImportDto> astronomers = xmlParser.fromFile(ASTRONOMERS_PATH, AstronomersListImportDto.class).getAstronomers();
        StringBuilder sb = new StringBuilder();

        astronomers.stream()
                .filter(a -> isValidAstronomer(a, sb))
                .map(this::mapToAstronomer)
                .forEach(a -> saveAstronomerToDb(a, sb));

        astronomerRepository.flush();
        return sb.toString();
    }

    private void saveAstronomerToDb(Astronomer a, StringBuilder sb) {
        String formatted = String.format("Successfully imported astronomer %s %s - %.2f",
                a.getFirstName(), a.getLastName(), a.getAverageObservationHours());

        sb.append(formatted).append(System.lineSeparator());

        astronomerRepository.save(a);
    }

    private Astronomer mapToAstronomer(AstronomerImportDto a) {
        Astronomer map = modelMapper.map(a, Astronomer.class);
        map.setStar(starService.findById(a.getObservingStarId()).get());

        return map;
    }

    private boolean isValidAstronomer(AstronomerImportDto a, StringBuilder sb) {
        if (astronomerRepository.findByFirstNameAndLastName(a.getFirstName(), a.getLastName()).isPresent() ||
            !validationUtil.isValid(a) ||  starService.findById(a.getObservingStarId()).isEmpty()) {
            sb.append("Invalid astronomer").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}
