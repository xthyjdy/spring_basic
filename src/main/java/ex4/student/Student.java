package ex4.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ex4.school.School;
import ex4.student_profile.StudentProfile;
import jakarta.persistence.*;

/*
{"firstName":"n1","lastName":"l1","email":"e1@E1.com","age":22 }
 */
@Entity(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "f_name", length = 20)
    private String firstName;
    @Column(name = "l_name", length = 20)
    private String lastName;
    @Column(unique = false)
    private String email;
    private Integer age;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

    public Student() {}

    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
