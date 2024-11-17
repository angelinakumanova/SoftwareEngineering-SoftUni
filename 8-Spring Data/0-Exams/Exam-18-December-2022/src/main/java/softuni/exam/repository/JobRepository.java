package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {


}
