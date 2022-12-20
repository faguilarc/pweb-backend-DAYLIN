package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.CourseDto;
import cu.edu.cujae.backend.core.dto.EvaluationDto;

import java.sql.SQLException;
import java.util.List;

public interface EvaluationService {

    void createEvaluation(EvaluationDto evaluationDto) throws SQLException;

    void updateEvaluation(EvaluationDto evaluationDto) throws SQLException;

    List<EvaluationDto> listEvaluation() throws SQLException;

    EvaluationDto getEvaluationById(String id) throws SQLException;

    void deleteEvaluation(String  id) throws SQLException;
}
