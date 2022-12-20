package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.StudentHistoryDto;
import cu.edu.cujae.backend.core.service.StudentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/studenthistory")
public class StudentHistoryController {

    @Autowired
    private StudentHistoryService student_historyService;

    @GetMapping("")
    public ResponseEntity<List<StudentHistoryDto>> getStudent_history() throws SQLException {
        List<StudentHistoryDto> student_historyList =student_historyService.listStudentHistory();
        return ResponseEntity.ok(student_historyList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentHistoryDto> getStudent_historyById(@PathVariable String id) throws SQLException {
        StudentHistoryDto student_history = student_historyService.getStudentHistoryById(id);
        return ResponseEntity.ok(student_history);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody StudentHistoryDto student_history) throws SQLException {
        student_historyService.createStudentHistory(student_history);
        return ResponseEntity.ok("Student_history Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody StudentHistoryDto student_history) throws SQLException {
        student_historyService.updateStudentHistory(student_history);
        return ResponseEntity.ok("Student_history Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        student_historyService.deleteStudentHistory(id);
        return ResponseEntity.ok("Student_history deleted");
    }
}
