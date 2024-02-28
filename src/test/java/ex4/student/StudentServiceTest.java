package ex4.student;

import org.hibernate.mapping.Any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    //service which we test
    @InjectMocks
    private StudentService service;
    //dependencies
    @Mock
    private StudentMapper mapper;
    @Mock
    private  StudentRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_save_student() {
        //given
        StudentDto dto = new StudentDto("john", "doe", "john@doe.com", 1);
        Student student = new Student("john", "doe", "john@doe.com", 11);
        Student saveStudent = new Student("john", "doe", "john@doe.com", 11);

        //mock calls
        when(mapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(saveStudent);
        when(mapper.toStudentResponseDto(saveStudent)).thenReturn(new StudentResponseDto(
                "john", "doe", "john@doe.com"
        ));
        //when
        StudentResponseDto responseDto = service.saveStudent(dto);
        //then
        assertEquals(dto.firstName(), responseDto.firstName());
        assertEquals(dto.lastName(), responseDto.lastName());
        assertEquals(dto.email(), responseDto.email());

        verify(mapper, times(1)).toStudent(dto);
        verify(repository, times(1)).save(student);
        verify(mapper, times(1)).toStudentResponseDto(saveStudent);
    }

    @Test
    public void shouldReturnAllStudents() {
        List<Student> studentList = List.of(
                new Student("john1", "doe", "john@doe.com", 1),
                new Student("john2", "doe", "john@doe.com", 2)
        );
        when(repository.findAll())
                .thenReturn(studentList);
        when(mapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto("dto_name", "doe", "john@doe.com"));

        List<StudentResponseDto> responseDtos = service.findAllStudents();

        assertEquals(studentList.size(), responseDtos.size());

        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toStudentResponseDto(studentList.get(0));
    }

    @Test
    public void shouldFindStudentById() {
        //given
        Integer studentId = 1;
        Student student = new Student("john1", "doe", "john@doe.com", 1);
        when(repository.findById(studentId)).thenReturn(
                Optional.of(student)
        );
        when(mapper.toStudentResponseDto(any(Student.class))).thenReturn(
                new StudentResponseDto("john1", "doe", "john@doe.com")
        );
        //when
        StudentResponseDto responseDto = service.findStudentById(studentId);
        //then
        assertEquals(student.getFirstName(), responseDto.firstName());
        assertEquals(student.getLastName(), responseDto.lastName());
        assertEquals(student.getEmail(), responseDto.email());

        verify(repository, times(1)).findById(studentId);
        verify(mapper, times(1)).toStudentResponseDto(student);
    }

    @Test
    public void shouldFindStudentByName() {
        //given
        String partOfFirstName = "";
        List<Student> students = List.of(
                new Student("john1", "doe", "john@doe.com", 1),
                new Student("john1", "doe", "john@doe.com", 1)
        );
        StudentResponseDto responseDto = new StudentResponseDto("john1", "doe", "john@doe.com");
        //mocking
        when(repository.findAllByFirstNameContaining(partOfFirstName))
                .thenReturn(students);
        when(mapper.toStudentResponseDto(any(Student.class))).thenReturn(responseDto);
        //when
        List<StudentResponseDto> responseDtos = service.findAllByFirstName(partOfFirstName);
        //then
        assertEquals(students.size(), responseDtos.size());
        verify(repository, times(1)).findAllByFirstNameContaining(partOfFirstName);
        verify(mapper, times(1)).toStudentResponseDto(students.get(0));
    }

    @Test
    public void shouldRemoveStudent() {
//        repository.deleteById(studentId);
        Integer studentId = 1;
        service.removeStudent(studentId);
        verify(repository, times(1)).deleteById(studentId);
    }
}