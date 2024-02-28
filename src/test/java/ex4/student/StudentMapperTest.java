package ex4.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {//System.out.println();
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("john", "doe", "john@doe.com", 1);
        Student student = mapper.toStudent(dto);
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        Student student = new Student("john", "doe", "john@doe.com", 22);
        StudentResponseDto dto = mapper.toStudentResponseDto(student);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
    }

    @Test
    public void should_throw_exception() {
        NullPointerException exc1 = assertThrows(NullPointerException.class, () ->{
            mapper.toStudent(null);
        });
        assertEquals(exc1.getMessage(), "Specified StudentDto object is null");
        NullPointerException exc2 = assertThrows(NullPointerException.class, () ->{
            mapper.toStudentResponseDto(null);
        });
        assertEquals(exc2.getMessage(), "Specified Student object is null");
    }














}



