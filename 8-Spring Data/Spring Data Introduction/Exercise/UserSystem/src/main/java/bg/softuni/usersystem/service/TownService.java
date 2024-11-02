package bg.softuni.usersystem.service;

import bg.softuni.usersystem.data.entities.Town;

import java.io.IOException;

public interface TownService {
    void seedTowns() throws IOException;

    boolean isImported();

    Town getTownByName(String name);
}
