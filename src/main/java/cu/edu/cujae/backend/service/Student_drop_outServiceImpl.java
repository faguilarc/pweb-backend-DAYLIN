package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.Student_drop_outDto;
import cu.edu.cujae.backend.core.service.Drop_out_causeService;
import cu.edu.cujae.backend.core.service.StudentService;
import cu.edu.cujae.backend.core.service.Student_drop_outService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class Student_drop_outServiceImpl implements Student_drop_outService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private Drop_out_causeService drop_out_causeService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createStudent_drop_out(Student_drop_outDto student_drop_out) throws SQLException {
        try {
            Connection conn = jdbcTemplate.getDataSource().getConnection();
            CallableStatement CS = conn.prepareCall("{call student_drop_out_insert(?, ?, ?)}");
            CS.setString(1, student_drop_out.getId_student());
            CS.setString(2, student_drop_out.getId_drop_out_cause());
            CS.setString(3,student_drop_out.getId_student_drop_out());

            CS.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateStudent_drop_out(Student_drop_outDto student_drop_out) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){

            PreparedStatement pstmt = conn.prepareStatement("update student_drop_out set id_student = ?, id_drop_out_cause = ? where id_student_drop_out = ?");

            pstmt.setString(1, student_drop_out.getId_student());
            pstmt.setString(2, student_drop_out.getId_drop_out_cause());
            pstmt.setString(3, student_drop_out.getId_student_drop_out());

            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Student_drop_outDto> listStudent_drop_out() throws SQLException {
        List<Student_drop_outDto> student_drop_outList = new ArrayList<Student_drop_outDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT * FROM student_drop_out");

            while (rs.next()) {
                student_drop_outList.add(new Student_drop_outDto(rs.getString("id_student")
                        , rs.getString("id_drop_out_cause")
                        , rs.getString("id_student_drop_out")
                        , studentService.getStudentById(rs.getString("id_student"))
                        , drop_out_causeService.getDrop_out_causeById(rs.getString("id_drop_out_cause"))));
            }
        }
        return student_drop_outList;
    }

    @Override
    public Student_drop_outDto getStudent_drop_outDtoById(String id) throws SQLException {
        Student_drop_outDto student_drop_out = null;

        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM student_drop_out where id_student_drop_out = ?");
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                student_drop_out = new Student_drop_outDto(rs.getString("id_student")
                        , rs.getString("id_drop_out_cause")
                        , rs.getString("id_student_drop_out")
                        , studentService.getStudentById(rs.getString("id_student"))
                        , drop_out_causeService.getDrop_out_causeById(rs.getString("id_drop_out_cause")));
            }
        }
        return student_drop_out;
    }

    @Override
    public void deleteStudent_drop_outDto(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall(
                    "{call student_drop_out_delete(?)}");
            CS.setString(1, id);
            CS.executeUpdate();
        }
        }

}
