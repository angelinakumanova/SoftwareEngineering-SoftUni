package bg.softuni.mvc_workshop.service;

import bg.softuni.mvc_workshop.data.entities.Project;

import java.util.Optional;

public interface ProjectService extends BaseService {
    Optional<Project> findByName(String name);
}
