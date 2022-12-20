package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.Student_drop_outDto;
import cu.edu.cujae.backend.core.service.Student_drop_outService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student_drop_out")
public class Student_drop_outController {
    @Autowired
    private Student_drop_outService student_drop_outService;

    @GetMapping("")
    public ResponseEntity<List<Student_drop_outDto>> getStudent_drop_out() throws SQLException {
        List<Student_drop_outDto> student_drop_outList = student_drop_outService.listStudent_drop_out();
        return ResponseEntity.ok(student_drop_outList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student_drop_outDto> getStudent_drop_outById(@PathVariable String id) throws SQLException {
        Student_drop_outDto student_drop_out = student_drop_outService.getStudent_drop_outDtoById(id);
        return ResponseEntity.ok(student_drop_out);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Student_drop_outDto student_drop_out) throws SQLException {
        student_drop_outService.createStudent_drop_out(student_drop_out);
        return ResponseEntity.ok("Student_drop_out Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody Student_drop_outDto student_drop_out) throws SQLException {
        student_drop_outService.updateStudent_drop_out(student_drop_out);
        return ResponseEntity.ok("Student_drop_out Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        student_drop_outService.deleteStudent_drop_outDto(id);
        return ResponseEntity.ok("Student_drop_out deleted");
    }
}
