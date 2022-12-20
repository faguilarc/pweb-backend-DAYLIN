package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.EvaluationDto;
import cu.edu.cujae.backend.core.dto.StudentHistoryDto;
import cu.edu.cujae.backend.core.service.EvaluationService;
import cu.edu.cujae.backend.core.service.StudentHistoryService;
import cu.edu.cujae.backend.core.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentHistoryService studentHistoryService;

    @Autowired
    private SubjectService subjectService ;

    @Override
    public void createEvaluation(EvaluationDto evaluationDto) throws SQLException {

        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){

            CallableStatement cs = conn.prepareCall("{call evaluation_insert(?,?,?,?,?)}");
            cs.setString(1,evaluationDto.getIdEvaluation());
            cs.setInt(2,evaluationDto.getEvaluation());
            cs.setString(3,evaluationDto.getIdSubject());
            cs.setString(4,evaluationDto.getIdStudentHistory());
            cs.setDate(5,evaluationDto.getDate());


            cs.executeUpdate();

        }
    }

    @Override
    public void updateEvaluation(EvaluationDto evaluationDto) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){

            PreparedStatement cs = conn.prepareStatement("update evaluation set evaluation = ?," +
                    "                                            id_subject = ?, id_student_history = ?," +
                    "                                         date = ? where id_evaluation = ?");
            cs.setString(5,evaluationDto.getIdEvaluation());
            cs.setInt(1,evaluationDto.getEvaluation());
            cs.setString(2,evaluationDto.getIdSubject());
            cs.setString(3,evaluationDto.getIdStudentHistory());
            cs.setDate(4,evaluationDto.getDate());


            cs.executeUpdate();

        }
    }

    @Override
    public List<EvaluationDto> listEvaluation() throws SQLException {
        List<EvaluationDto> evaluationDtoList = new ArrayList<>();
        try(Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement("Select * from evaluation");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){

                EvaluationDto st = new EvaluationDto(
                        resultSet.getString("id_evaluation"),
                        resultSet.getInt("evaluation"),
                        resultSet.getString("id_subject"),
                        resultSet.getString("id_student_history"),
                        resultSet.getDate("date"),
                        studentHistoryService.getStudentHistoryById(resultSet.getString("id_student_history")),
                        subjectService.getSubjectById(resultSet.getString("id_subject")));

                evaluationDtoList.add(st);
            }


        }

        return evaluationDtoList;
    }

    @Override
    public EvaluationDto getEvaluationById(String id) throws SQLException {
        EvaluationDto evaluationDto = new EvaluationDto();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement("Select * from evaluation where id_evaluation = ?");
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                evaluationDto = new EvaluationDto(
                        resultSet.getString("id_evaluation"),
                        resultSet.getInt("evaluation"),
                        resultSet.getString("id_subject"),
                        resultSet.getString("id_student_history"),
                        resultSet.getDate("date"),
                        studentHistoryService.getStudentHistoryById(resultSet.getString("id_student_history")),
                        subjectService.getSubjectById(resultSet.getString("id_subject")));
            }
        }

        return evaluationDto;
    }

    @Override
    public void deleteEvaluation(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){

            CallableStatement cs = conn.prepareCall("{call evaluation_delete(?)}");
            cs.setString(1,id);
            cs.executeUpdate();

        }
    }
}
