package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.SemesterDto;
import cu.edu.cujae.backend.core.service.CourseService;
import cu.edu.cujae.backend.core.service.SemesterService;
import cu.edu.cujae.backend.core.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    private YearService yearService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createSemester(SemesterDto semester) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall("{call semester_insert(?, ?, ?, ?)}");

            CS.setString(1,semester.getId_semester());
            CS.setString(2,semester.getSemester());
            CS.setString(3,semester.getId_year());
            CS.setString(4,semester.getId_course());

            CS.executeUpdate();
            CS.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateSemester(SemesterDto semester) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("update semester set semester=?, id_year=?, id_course=? where id_semester = ?");
            pstmt.setString(1,semester.getSemester());
            pstmt.setString(2,semester.getId_year());
            pstmt.setString(3,semester.getId_course());
            pstmt.setString(4,semester.getId_semester());

            pstmt.executeUpdate();
            pstmt.close();
        }

    }

    @Override
    public List<SemesterDto> listSemester() throws SQLException {
        List<SemesterDto> semesterList = new ArrayList<SemesterDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){

            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT * FROM semester");

            while(rs.next()){
                semesterList.add(new SemesterDto(rs.getString("id_semester")
                        ,rs.getString("semester")
                        ,rs.getString("id_year")
                        ,rs.getString("id_course")
                        ,yearService.getYearById(rs.getString("id_year"))
                        ,courseService.getCourseById(rs.getString("id_course"))));
            }
            rs.close();
        }
        return semesterList;
    }

    @Override
    public SemesterDto getSemesterById(String id) throws SQLException {
        SemesterDto semester = null;

        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM semester where id_semester = ?");

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                semester = new SemesterDto(rs.getString("id_semester")
                        ,rs.getString("semester")
                        ,rs.getString("id_year")
                        ,rs.getString("id_course")
                        ,yearService.getYearById(rs.getString("id_year"))
                        ,courseService.getCourseById(rs.getString("id_course")));
            }
            rs.close();
            pstmt.close();
        }
        return semester;
    }

    @Override
    public void deleteSemester(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall(
                    "{call semester_delete(?)}");
            CS.setString(1, id);
            CS.executeUpdate();
        }
    }
}
