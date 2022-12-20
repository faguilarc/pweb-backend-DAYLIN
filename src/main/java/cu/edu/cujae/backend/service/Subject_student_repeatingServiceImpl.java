package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.Subject_student_repeatingDto;
import cu.edu.cujae.backend.core.service.Student_repeatingService;
import cu.edu.cujae.backend.core.service.SubjectService;
import cu.edu.cujae.backend.core.service.Subject_student_repeatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class Subject_student_repeatingServiceImpl implements Subject_student_repeatingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private Student_repeatingService student_repeatingService;

    @Override
    public void createSubject_student_repeating(Subject_student_repeatingDto objects) throws SQLException {
        try {
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            CallableStatement CS = conn.prepareCall("{call subject_student_repeating_insert(?, ?)}");
            CS.setString(1,objects.getId_subject());
            CS.setString(2,objects.getId_student_repeating());

            CS.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Subject_student_repeatingDto> listSubject_student_repeating() throws SQLException {
        List<Subject_student_repeatingDto> subject_student_repeatingList = new ArrayList<Subject_student_repeatingDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT * FROM subject_student_repeating");

            while (rs.next()) {
                subject_student_repeatingList.add(new Subject_student_repeatingDto(rs.getString("id_subject")
                        ,rs.getString("id_student_repeating")
                        ,student_repeatingService.getStudent_repeatingById(rs.getString("id_student_repeating"))
                        ,subjectService.getSubjectById(rs.getString("id_subject"))));
            }
        }
        return subject_student_repeatingList;
    }

    @Override
    public void deleteSubject_student_repeating(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall(
                    "{call subject_student_repeating_delete(?)}");

            CS.setString(1, id);
            CS.executeUpdate();
        }

    }
}
