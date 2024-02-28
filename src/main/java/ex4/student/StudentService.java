package ex4.student;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentMapper studentMapper;
    private final StudentRepository repository;

    public StudentService(StudentMapper studentMapper, StudentRepository repository) {
        this.studentMapper = studentMapper;
        this.repository = repository;
    }

    public StudentResponseDto saveStudent(StudentDto dto) {
        Student student =  studentMapper.toStudent(dto);
        Student saveStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(saveStudent);
    }

    public List<StudentResponseDto> findAllByFirstName(String partOfFirstName) {
        return repository.findAllByFirstNameContaining(partOfFirstName)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDto> findAllStudents() {
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(Integer studentId) {
        return repository.findById(studentId)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public void removeStudent(Integer studentId) {
        repository.deleteById(studentId);
    }
}
