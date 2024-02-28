package ex4.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ex4.student.Student;
import jakarta.persistence.*;
import java.util.List;

//{ "name":"school_1" }

@Entity(name = "school")
public class School {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 20)
    private String name;

    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
