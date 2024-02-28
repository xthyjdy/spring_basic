package ex4.school;

import ex4.school.SchoolDto;
import ex4.school.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolService service;
    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAllSchools() {
        return service.findAllSchools();
    }

    @PostMapping("/create_school")//{ "name":"school_1" }
    public SchoolDto createSchool(
            @RequestBody SchoolDto dto
    ) {
        return service.createSchool(dto);
    }
}
