package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.StudentDto;
import cu.edu.cujae.backend.core.service.StudentService;
import cu.edu.cujae.backend.core.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TownService townService;

    @Override
    public void createStudent(StudentDto student) throws SQLException {
        try {
            CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call student_insert(?, ?, ?, ?, ?, ?, ?)}");
            CS.setString(1, student.getStudent_ci());
            CS.setString(2, student.getFirst_surname());
            CS.setString(3, student.getSecond_surname());
            CS.setString(4, student.getSex());
            CS.setString(5, student.getId_town());
            CS.setString(6, student.getId_student());
            CS.setString(7, student.getStudent_name());

            CS.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateStudent(StudentDto student) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("update student set student_ci = ?, first_surname = ?, second_surname = ?, sex = ?, id_town = ?, student_name = ?  where id_student = ?");

            pstmt.setString(1, student.getStudent_ci());
            pstmt.setString(2, student.getFirst_surname());
            pstmt.setString(3, student.getSecond_surname());
            pstmt.setString(4, student.getSex());
            pstmt.setString(5, student.getId_town());
            pstmt.setString(6, student.getStudent_name());
            pstmt.setString(7, student.getId_student());

            pstmt.executeUpdate();
        }

    }

    @Override
    public List<StudentDto> listStudent() throws SQLException {
        List<StudentDto> studentList = new ArrayList<StudentDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM student");

            while (rs.next()) {
                studentList.add(new StudentDto(rs.getString("student_ci")
                        , rs.getString("student_name")
                        , rs.getString("first_surname")
                        , rs.getString("second_surname")
                        , rs.getString("sex")
                        , rs.getString("id_town")
                        , rs.getString("id_student")
                        , townService.getTownById(rs.getString("id_town"))));
            }
        }

        return studentList;
    }


    @Override
    public StudentDto getStudentById(String id) throws SQLException {
        StudentDto student = null;

        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM student where id_student = ?");

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                student = new StudentDto(rs.getString("student_ci")
                        , rs.getString("student_name")
                        , rs.getString("first_surname")
                        , rs.getString("second_surname")
                        , rs.getString("sex")
                        , rs.getString("id_town")
                        , rs.getString("id_student")
                        , townService.getTownById(rs.getString("id_town")));
            }
        }
        return student;
    }


    @Override
    public void deleteStudent(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall(
                    "{call student_delete(?)}");

            CS.setString(1, id);
            CS.executeUpdate();
        }
    }
}