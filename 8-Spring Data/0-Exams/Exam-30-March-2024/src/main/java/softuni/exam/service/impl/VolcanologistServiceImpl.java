package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanologistImportDto;
import softuni.exam.models.dto.VolcanologistListImportDto;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {
    private final static String VOLCANOLOGISTS_PATH = "src/main/resources/files/xml/volcanologists.xml";

    private final VolcanologistRepository volcanologistRepository;
    private final VolcanoService volcanoService;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, VolcanoService volcanoService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.volcanologistRepository = volcanologistRepository;
        this.volcanoService = volcanoService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
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
    public String importVolcanologists() {
        try {
            StringBuilder sb = new StringBuilder();
            xmlParser.fromFile(VOLCANOLOGISTS_PATH, VolcanologistListImportDto.class).getVolcanologists()
                    .stream()
                    .filter(vd -> isValidVolcanologist(vd, sb))
                    .map(vd -> modelMapper.map(vd, Volcanologist.class))
                    .forEach(volcanologist -> {
                        String formattedVolcanologist = String.format("Successfully imported volcanologist %s %s",
                                volcanologist.getFirstName(), volcanologist.getLastName());
                        sb.append(formattedVolcanologist).append(System.lineSeparator());

                        volcanologistRepository.save(volcanologist);
                    });

            return sb.toString();

        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }


        return "";
    }

    private boolean isValidVolcanologist(VolcanologistImportDto vd, StringBuilder sb) {
        if (volcanologistRepository.findByFirstNameAndLastName(vd.getFirstName(), vd.getLastName()).isPresent()
        || !validationUtil.isValid(vd) || volcanoService.getById(vd.getVolcano()).isEmpty()) {
            sb.append("Invalid volcanologist").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}