package ex4.school;

import ex4.school.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
