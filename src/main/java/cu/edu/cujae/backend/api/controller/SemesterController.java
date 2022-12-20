package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.SemesterDto;
import cu.edu.cujae.backend.core.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/semester")
public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @GetMapping("")
    public ResponseEntity<List<SemesterDto>> getSemester() throws SQLException {
        List<SemesterDto> semesterList = semesterService.listSemester();
        return ResponseEntity.ok(semesterList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemesterDto> getSemesterById(@PathVariable String id) throws SQLException {
        SemesterDto semester = semesterService.getSemesterById(id);
        return ResponseEntity.ok(semester);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody SemesterDto semester) throws SQLException {
        semesterService.createSemester(semester);
        return ResponseEntity.ok("Semester Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody SemesterDto semester) throws SQLException {
        semesterService.updateSemester(semester);
        return ResponseEntity.ok("Semester Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        semesterService.deleteSemester(id);
        return ResponseEntity.ok("Semester deleted");
    }
}
