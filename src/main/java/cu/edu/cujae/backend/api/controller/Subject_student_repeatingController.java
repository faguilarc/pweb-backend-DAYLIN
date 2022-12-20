package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.Subject_student_repeatingDto;
import cu.edu.cujae.backend.core.service.Subject_student_repeatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/subject_student_repeating")
public class Subject_student_repeatingController {
    @Autowired
    private Subject_student_repeatingService subject_student_repeatingService;

    @GetMapping("")
    public ResponseEntity<List<Subject_student_repeatingDto>> getSubject_student_repeating() throws SQLException {
        List<Subject_student_repeatingDto> subject_student_repeatingList = subject_student_repeatingService.listSubject_student_repeating();
        return ResponseEntity.ok(subject_student_repeatingList);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Subject_student_repeatingDto subject_student_repeating) throws SQLException {
        subject_student_repeatingService.createSubject_student_repeating(subject_student_repeating);
        return ResponseEntity.ok("Subject_student_repeating Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        subject_student_repeatingService.deleteSubject_student_repeating(id);
        return ResponseEntity.ok("Subject_student_repeating deleted");
    }
}
