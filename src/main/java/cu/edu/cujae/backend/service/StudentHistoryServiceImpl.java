package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.StudentHistoryDto;
import cu.edu.cujae.backend.core.service.CourseService;
import cu.edu.cujae.backend.core.service.GroupsService;
import cu.edu.cujae.backend.core.service.StudentHistoryService;
import cu.edu.cujae.backend.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentHistoryServiceImpl<historyDto> implements StudentHistoryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CourseService courseService;

    @Autowired
    private GroupsService groupsService;

    @Autowired
    private StudentService studentService;

    @Override
    public void createStudentHistory(StudentHistoryDto studentHistoryDto) throws SQLException {

        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement cs = conn.prepareCall("{call student_history_insert(?,?,?,?,?)}");
            cs.setString(1,studentHistoryDto.getIdStudentHistory());
            cs.setString(2,studentHistoryDto.getIdGroup());
            cs.setInt(3,studentHistoryDto.getNumList());
            cs.setString(4,studentHistoryDto.getIdCourse());
            cs.setString(5,studentHistoryDto.getIdStudent());

            cs.executeUpdate();

        }
    }

    @Override
    public void updateStudentHistory(StudentHistoryDto studentHistoryDto) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement cs = conn.prepareCall("{call student_history_update(?,?,?,?,?)}");
            cs.setString(1,studentHistoryDto.getIdStudentHistory());
            cs.setString(2,studentHistoryDto.getIdGroup());
            cs.setInt(3,studentHistoryDto.getNumList());
            cs.setString(4,studentHistoryDto.getIdCourse());
            cs.setString(5,studentHistoryDto.getIdStudent());

            cs.executeUpdate();

        }
    }

    @Override
    public List<StudentHistoryDto> listStudentHistory() throws SQLException {
        List<StudentHistoryDto> historyDtoList = new ArrayList<>();
        try(Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement("Select * from student_history");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){

                StudentHistoryDto st = new StudentHistoryDto(
                                            resultSet.getString("id_student_history"),
                                            resultSet.getString("id_group"),
                                            resultSet.getInt("num_list"),
                                            resultSet.getString("id_course"),
                                            resultSet.getString("id_student"),
                        courseService.getCourseById(resultSet.getString("id_course")),
                        groupsService.getGroupsById(resultSet.getString("id_group")),
                        studentService.getStudentById(resultSet.getString("id_student")));

                historyDtoList.add(st);
            }


        }

        return historyDtoList;
    }

    @Override
    public StudentHistoryDto getStudentHistoryById(String id) throws SQLException {
        StudentHistoryDto historyDto = new StudentHistoryDto();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement("Select * from student_history where id_student_history = ?");
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                historyDto = new StudentHistoryDto(
                        resultSet.getString("id_student_history"),
                        resultSet.getString("id_group"),
                        resultSet.getInt("num_list"),
                        resultSet.getString("id_course"),
                        resultSet.getString("id_student"),
                        courseService.getCourseById(resultSet.getString("id_course")),
                        groupsService.getGroupsById(resultSet.getString("id_group")),
                        studentService.getStudentById(resultSet.getString("id_student")));
            }
    }

        return historyDto;
}

    @Override
    public void deleteStudentHistory(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement cs = conn.prepareCall("{call student_history_delete(?)}");
            cs.setString(1,id);

            cs.executeUpdate();

        }
    }

    @Override
    public List<StudentHistoryDto> AssignNumberList() throws SQLException {
        return null;
    }
}
