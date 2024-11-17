package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PersonImportDto;
import softuni.exam.models.entity.Person;
import softuni.exam.repository.PersonRepository;
import softuni.exam.service.CountryService;
import softuni.exam.service.PersonService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PersonServiceImpl implements PersonService {
    private static final String PEOPLE_PATH = "src/main/resources/files/json/people.json";

    private final PersonRepository personRepository;
    private final CountryService countryService;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PersonServiceImpl(PersonRepository personRepository, CountryService countryService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.personRepository = personRepository;
        this.countryService = countryService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.personRepository.count() > 0;
    }

    @Override
    public String readPeopleFromFile() throws IOException {
        return Files.readString(Path.of(PEOPLE_PATH));
    }

    @Override
    public String importPeople() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPeopleFromFile(), PersonImportDto[].class))
                .filter(p -> isValidPerson(p, sb))
                .map(this::mapToPerson)
                .forEach(person -> savePerson(person, sb));

        personRepository.flush();
        return sb.toString();
    }

    private Person mapToPerson(PersonImportDto p) {
        Person map = modelMapper.map(p, Person.class);
        map.setCountry(countryService.findById(p.getCountry()).get());

        return map;
    }

    private void savePerson(Person person, StringBuilder sb) {
        String formatted = String.format("Successfully imported person %s %s",
                person.getFirstName(), person.getLastName());
        sb.append(formatted).append(System.lineSeparator());

        personRepository.save(person);
    }

    private boolean isValidPerson(PersonImportDto p, StringBuilder sb) {
        if (!validationUtil.isValid(p) ||
                personRepository.findByFirstNameOrEmailOrPhone(p.getFirstName(), p.getEmail(), p.getPhone()).isPresent()) {
            sb.append("Invalid person").append(System.lineSeparator());
            return false;
        }

        return true;
    }
}
