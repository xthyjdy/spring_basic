package ex4.school;

import ex4.school.School;
import ex4.school.SchoolDto;
import ex4.school.SchoolMapper;
import ex4.school.SchoolRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository repository;
    private final SchoolMapper mapper;

    public SchoolService(SchoolRepository repository, SchoolMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<SchoolDto> findAllSchools() {
        return repository.findAll()
                .stream().map(mapper::toSchoolDto)
                .collect(Collectors.toList());
    }

    public SchoolDto createSchool(SchoolDto dto) {
        School savedSchool = repository.save( mapper.toSchool(dto) );
        return new SchoolDto(savedSchool.getName());
    }
}
