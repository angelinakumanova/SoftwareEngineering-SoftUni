package bg.softuni.usersystem.service.impls;

import bg.softuni.usersystem.data.entities.Town;
import bg.softuni.usersystem.data.repositories.TownRepository;
import bg.softuni.usersystem.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {
    private final static String TOWN_PATH = "src/main/resources/towns.txt";

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }


    @Override
    public void seedTowns() throws IOException {
        Files.readAllLines(Path.of(TOWN_PATH))
                .stream()
                .filter(line -> !line.isBlank())
                .forEach(line -> {
                    String[] split = line.split(",\\s+");
                    String name = split[0];
                    String country = split[1];


                    if (townRepository.findByName(name) == null) {
                        townRepository.saveAndFlush(new Town(name, country));
                    }
                });

        System.out.printf("Successfully seeded %d towns.%n", townRepository.count());
    }

    @Override
    public boolean isImported() {
        return townRepository.count() > 0;
    }
}
