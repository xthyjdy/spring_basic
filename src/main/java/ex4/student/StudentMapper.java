package ex4.student;

import ex4.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto) {
        if (null == dto) {
            throw new NullPointerException("Specified StudentDto object is null");
        }
        Student student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        School school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        if (null == student) {
            throw new NullPointerException("Specified Student object is null");
        }
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
