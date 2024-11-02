package bg.softuni.usersystem.service;

import java.io.IOException;

public interface TownService {
    void seedTowns() throws IOException;

    boolean isImported();
}
