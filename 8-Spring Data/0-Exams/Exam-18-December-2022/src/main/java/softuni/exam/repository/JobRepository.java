package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.entity.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {


    List<Job> findBySalaryGreaterThanEqualAndHoursAWeekLessThanEqualOrderBySalaryDesc(Double salary, Double hoursAWeek);
}
