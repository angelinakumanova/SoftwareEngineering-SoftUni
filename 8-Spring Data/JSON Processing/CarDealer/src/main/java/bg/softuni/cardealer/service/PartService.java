package bg.softuni.cardealer.service;

import bg.softuni.cardealer.data.entities.Part;

import java.util.Set;

public interface PartService {
    void seedParts();

    boolean isImported();

    Set<Part> getRandomParts();
}
