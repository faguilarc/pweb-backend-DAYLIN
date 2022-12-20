package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.EvaluationDto;
import cu.edu.cujae.backend.core.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("")
    public ResponseEntity<List<EvaluationDto>> getEvaluation() throws SQLException {
        List<EvaluationDto> evaluationList = evaluationService.listEvaluation();
        return ResponseEntity.ok(evaluationList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDto> getEvaluationById(@PathVariable String id) throws SQLException {
        EvaluationDto evaluation = evaluationService.getEvaluationById(id);
        return ResponseEntity.ok(evaluation);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody EvaluationDto evaluation) throws SQLException {
        evaluationService.createEvaluation(evaluation);
        return ResponseEntity.ok("Evaluation Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody EvaluationDto evaluation) throws SQLException {
        evaluationService.updateEvaluation(evaluation);
        return ResponseEntity.ok("Evaluation Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        evaluationService.deleteEvaluation(id);
        return ResponseEntity.ok("Evaluation deleted");
    }
}
