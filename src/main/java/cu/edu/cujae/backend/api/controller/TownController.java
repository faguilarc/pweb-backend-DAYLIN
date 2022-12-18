package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.TownDto;
import cu.edu.cujae.backend.core.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/town")
public class TownController {
    @Autowired
    private TownService townService;

    @GetMapping("")
    public ResponseEntity<List<TownDto>> getTown() throws SQLException {
        List<TownDto> townList = townService.listTown();
        return ResponseEntity.ok(townList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TownDto> getTownById(@PathVariable String id) throws SQLException {
        TownDto town = townService.getTownById(id);
        return ResponseEntity.ok(town);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody TownDto town) throws SQLException {
        townService.createTown(town);
        return ResponseEntity.ok("Town Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody TownDto town) throws SQLException {
        townService.updateTown(town);
        return ResponseEntity.ok("Town Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        townService.deleteTown(id);
        return ResponseEntity.ok("Town deleted");
    }
}
