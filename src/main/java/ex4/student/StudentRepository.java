package ex4.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByFirstNameContaining(String firstName);

//    void updateStudentById(Integer id, Student newStudentData);
}
