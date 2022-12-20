package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.Student_repeatingDto;
import cu.edu.cujae.backend.core.service.Student_repeatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student_repeating")
public class Student_repeatingController {

    @Autowired
    private Student_repeatingService student_repeatingService;

    @GetMapping("")
    public ResponseEntity<List<Student_repeatingDto>> getStudent_repeating() throws SQLException {
        List<Student_repeatingDto> student_repeatingList = student_repeatingService.listStudent_repeatingDto();
        return ResponseEntity.ok(student_repeatingList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student_repeatingDto> getStudent_repeatingById(@PathVariable String id) throws SQLException {
        Student_repeatingDto student_repeating = student_repeatingService.getStudent_repeatingById(id);
        return ResponseEntity.ok(student_repeating);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Student_repeatingDto student_repeating) throws SQLException {
        student_repeatingService.createStudent_repeating(student_repeating);
        return ResponseEntity.ok("Student_repeating Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody Student_repeatingDto student_repeating) throws SQLException {
        student_repeatingService.updateStudent_repeating(student_repeating);
        return ResponseEntity.ok("Student_repeating Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        student_repeatingService.deleteStudent_repeating(id);
        return ResponseEntity.ok("Student_repeating deleted");
    }
}
