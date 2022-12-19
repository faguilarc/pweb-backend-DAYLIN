package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.StudentDto;
import cu.edu.cujae.backend.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<StudentDto>> getStudent() throws SQLException {
        List<StudentDto> studentList = studentService.listStudent();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String id) throws SQLException {
        StudentDto student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody StudentDto student) throws SQLException {
        studentService.createStudent(student);
        return ResponseEntity.ok("Student Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody StudentDto student) throws SQLException {
        studentService.updateStudent(student);
        return ResponseEntity.ok("Student Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted");
    }
}
