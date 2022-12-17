package cu.edu.cujae.backend.api.controller;


import cu.edu.cujae.backend.core.dto.YearDto;
import cu.edu.cujae.backend.core.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/year")
public class YearController {
    @Autowired
    private YearService yearService;

    @GetMapping("")
    public ResponseEntity<List<YearDto>> getYears() throws SQLException {
        List<YearDto> yearList = yearService.listYear();
        return ResponseEntity.ok(yearList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<YearDto> getYearById(@PathVariable String id) throws SQLException {
        YearDto year = yearService.getYearById(id);
        return ResponseEntity.ok(year);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody YearDto year) throws SQLException {
        yearService.createYear(year);
        return ResponseEntity.ok("Year Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody YearDto year) throws SQLException {
        yearService.updateYear(year);
        return ResponseEntity.ok("Year Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        yearService.deleteYear(id);
        return ResponseEntity.ok("Year deleted");
    }
}
