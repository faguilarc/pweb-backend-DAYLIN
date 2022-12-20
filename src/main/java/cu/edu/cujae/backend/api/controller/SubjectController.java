package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.SubjectDto;
import cu.edu.cujae.backend.core.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("")
    public ResponseEntity<List<SubjectDto>> getSubject() throws SQLException {
        List<SubjectDto> subjectList = subjectService.listSubject();
        return ResponseEntity.ok(subjectList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> getUserById(@PathVariable String id) throws SQLException {
        SubjectDto subject = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody SubjectDto subject) throws SQLException {
        subjectService.createSubject(subject);
        return ResponseEntity.ok("Subject Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody SubjectDto subject) throws SQLException {
        subjectService.updateSubject(subject);
        return ResponseEntity.ok("Subject Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        subjectService.deleteSubject(id);
        return ResponseEntity.ok("Subject deleted");
    }
}
