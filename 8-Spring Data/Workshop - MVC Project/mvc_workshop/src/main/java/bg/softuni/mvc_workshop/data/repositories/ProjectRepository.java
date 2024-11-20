package bg.softuni.mvc_workshop.data.repositories;

import bg.softuni.mvc_workshop.data.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
