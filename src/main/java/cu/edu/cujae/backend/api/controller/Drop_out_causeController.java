package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.Drop_out_causeDto;
import cu.edu.cujae.backend.core.service.Drop_out_causeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/drop_out_cause")
public class Drop_out_causeController {

    @Autowired
    private Drop_out_causeService drop_out_causeService;

    @GetMapping("")
    public ResponseEntity<List<Drop_out_causeDto>> getDrop_out_causeList() throws SQLException {
        List<Drop_out_causeDto> drop_out_causeList = drop_out_causeService.listDrop_out_cause();
        return ResponseEntity.ok(drop_out_causeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drop_out_causeDto> getDrop_out_causeListById(@PathVariable String id) throws SQLException {
        Drop_out_causeDto drop_out_cause = drop_out_causeService.getDrop_out_causeById(id);
        return ResponseEntity.ok(drop_out_cause);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Drop_out_causeDto drop_out_cause) throws SQLException {
        drop_out_causeService.createDrop_out_cause(drop_out_cause);
        return ResponseEntity.ok("Drop_out_cause Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody Drop_out_causeDto drop_out_cause) throws SQLException{
        drop_out_causeService.updateDrop_out_cause(drop_out_cause);
        return ResponseEntity.ok("Drop_out_cause Updated");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id)throws SQLException{
        drop_out_causeService.deleteDrop_out_cause(id);
        return ResponseEntity.ok("Drop_out_cause deleted");
    }
}
