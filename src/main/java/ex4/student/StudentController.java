package ex4.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) { this.service = service; }

    //{"firstName":"n2","lastName":"l1","email":"e1@E1.com","age": 22, "schoolId": 1 }
    @PostMapping("/create_student")
    public StudentResponseDto createStudent(@Valid @RequestBody StudentDto dto) {
        return service.saveStudent(dto);
    }

    @GetMapping("/students/search/{first_name}")
    public List<StudentResponseDto> findAllByFirstName(@PathVariable(name = "first_name") String firstName) {
        return service.findAllByFirstName(firstName);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() { return service.findAllStudents(); }

    @GetMapping("/students/{student_id}")
    public StudentResponseDto findStudentById(@PathVariable(name = "student_id") Integer studentId) { return service.findStudentById(studentId); }

    @DeleteMapping("/students/{student_id}")
    public void removeStudent(@PathVariable(name = "student_id") Integer studentId) {
        service.removeStudent(studentId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ) {
        HashMap<String, String> errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

//    @PutMapping("/students/{student_id}")
//    public void updateStudent(
//            @PathVariable(name = "student_id") Integer studentId,
//            @RequestBody Student newStudentData
//    ) {
//        repository.updateStudentById(studentId, newStudentData);
//    }
//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }

//    @GetMapping("/hello")
//    public String pathVar(
//            @RequestParam("fname") String userName,
//            @RequestParam("lname") String lastName
//    ) {
//        return userName + " " + lastName;
//    }
//
//
//    @GetMapping("/hello/{user-name}")
//    public String pathVar(@PathVariable("user-name") String userName) {
//        return userName;
//    }
//
//    @PostMapping("/post-orders")
//    public String postOrders(@RequestBody ArrayList<Order> orders) {
//        return bg + "post-orders: " + orders.toString();
//    }
//
//    @PostMapping("/post-order-record")
//    public String postRecord(@RequestBody OrderRecord order) {
//        return "post-order-record: " + order.toString();
//    }
//
//    @PostMapping("/post-order")
//    public String post(@RequestBody Order order) {
//        return bg + "post: " + order.toString();
//    }
//
//    @PostMapping("/post")
//    public String post(@RequestBody String message) {
//        return bg + "post: " + message;
//    }
}
