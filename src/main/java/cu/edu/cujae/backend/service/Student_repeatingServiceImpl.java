package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.Student_repeatingDto;
import cu.edu.cujae.backend.core.service.StudentService;
import cu.edu.cujae.backend.core.service.Student_repeatingService;
import cu.edu.cujae.backend.core.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class Student_repeatingServiceImpl implements Student_repeatingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentService studentService;
    @Override
    public void createStudent_repeating(Student_repeatingDto student_repeating) throws SQLException {
        try {
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            CallableStatement CS = conn.prepareCall("{call student_repeating_insert(?, ?)}");
            CS.setString(1,student_repeating.getId_student_repeating());
            CS.setString(2,student_repeating.getId_student());

            CS.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent_repeating(Student_repeatingDto student_repeating) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(
                    "update student_repeating set id_student = ? where id_student_repeating = ?");
            pstmt.setString(2,student_repeating.getId_student_repeating());
            pstmt.setString(1,student_repeating.getId_student());
            pstmt.executeUpdate();
        }

    }

    @Override
    public List<Student_repeatingDto> listStudent_repeatingDto() throws SQLException {
        List<Student_repeatingDto> student_repeatingList = new ArrayList<Student_repeatingDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT * FROM student_repeating");
            while(rs.next()){
                student_repeatingList.add(new Student_repeatingDto(rs.getString("id_student_repeating")
                        ,rs.getString("id_student")
                        ,studentService.getStudentById(rs.getString("id_student"))));
            }
        }
        return student_repeatingList;
    }

    @Override
    public Student_repeatingDto getStudent_repeatingById(String id) throws SQLException {
        Student_repeatingDto student_repeating = null;
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM student_repeating where id_student_repeating = ?");
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                student_repeating = new Student_repeatingDto(rs.getString("id_student_repeating")
                        ,rs.getString("id_student")
                        ,studentService.getStudentById(rs.getString("id_student")));
            }
        }
        return student_repeating;
    }

    @Override
    public void deleteStudent_repeating(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall(
                    "{call student_repeating_delete(?)}");
            CS.setString(1, id);
            CS.executeUpdate();
        }
    }
}
