package ex4.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record StudentDto(
        @NotEmpty(message = "f_name is empty")
        @Size(min = 3, max = 15)
        String firstName,
        @NotEmpty
        String lastName,
        @NotEmpty(message = "please specify email")
        @Email(message = "e is incorrect")
        String email,

        Integer schoolId
) {
}
