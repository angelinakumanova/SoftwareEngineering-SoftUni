package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.repository.PersonRepository;
import softuni.exam.service.PersonService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class PersonServiceImpl implements PersonService {
    private static final String PEOPLE_PATH = "src/main/resources/files/json/people.json";

    private final PersonRepository personRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PersonServiceImpl(PersonRepository personRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.personRepository = personRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.;
    }

    @Override
    public String readPeopleFromFile() throws IOException {
        return "";
    }

    @Override
    public String importPeople() throws IOException, JAXBException {
        return "";
    }
}
