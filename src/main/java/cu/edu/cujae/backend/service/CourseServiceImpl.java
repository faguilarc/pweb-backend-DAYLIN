package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.CourseDto;
import cu.edu.cujae.backend.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CourseServiceImpl implements CourseService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createCourse(CourseDto courseDto) throws SQLException {

        try ( Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall("{call course_insert(?, ?, ?,?)}");
            CS.setString(1, courseDto.getIdCourse());
            CS.setString(2, courseDto.getCourse());
            CS.setDate(3, courseDto.getBeginDate());
            CS.setDate(4, courseDto.getEndDate());
            CS.executeUpdate();

        }
    }

    @Override
    public void updateCourse(CourseDto courseDto) throws SQLException {

        try ( Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall("{call course_update(?,?,?,?)}");
        CS.setString(1,courseDto.getIdCourse());
        CS.setString(2, courseDto.getCourse());
        CS.setDate(3, courseDto.getBeginDate());
        CS.setDate(4, courseDto.getEndDate());
        CS.execute();
        CS.close();
    }
    }

    @Override
    public List<CourseDto> listCourse() throws SQLException{
        List<CourseDto> courseList = new ArrayList<CourseDto>();
        try  (Connection conn = jdbcTemplate.getDataSource().getConnection())
        {
            ResultSet rs = conn.createStatement().executeQuery(
                "SELECT * FROM course");

        while (rs.next()) {
            courseList.add(new CourseDto(rs.getString("id_course")
                    , rs.getString("course")
                    , rs.getDate("begin_date")
                    , rs.getDate("end_date")));
        }
        }
        return courseList;
    }

    @Override
    public CourseDto getCourseById(String id) throws SQLException {
        CourseDto course = null;
        try(PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(
                "SELECT * FROM course where id_course = ?")) {


            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                course = new CourseDto(rs.getString("id_course")
                        , rs.getString("course")
                        , rs.getDate("begin_date")
                        , rs.getDate("end_date"));
            }
        }
        return course;
    }

    @Override
    public void deleteCourse(String id) throws SQLException {
        try (CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall(
                "{call course_delete(?)}")){


        CS.setString(1, id);
        CS.executeUpdate();
    }
    }
}