package bg.softuni.mvc_workshop.service;

import bg.softuni.mvc_workshop.data.entities.Company;

import java.util.Optional;

public interface CompanyService extends BaseService {
    Optional<Company> findByName(String name);
}
