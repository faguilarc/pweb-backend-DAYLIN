package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.SubjectDto;
import cu.edu.cujae.backend.core.service.SemesterService;
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
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SemesterService semesterService;

    @Override
    public void createSubject(SubjectDto subject) throws SQLException {
        try {
            CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call subject_insert(?, ?, ?, ?)}");
            CS.setString(1,subject.getId_subject());
            CS.setString(2, subject.getSubject());
            CS.setString(3,subject.getId_semester());
            CS.setInt(4, subject.getHour());

            CS.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateSubject(SubjectDto subject) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("update subject set  subject = ?, id_semester=?, hour=? where  id_subject=?");

            pstmt.setString(1, subject.getSubject());
            pstmt.setString(2,subject.getId_semester());
            pstmt.setInt(3, subject.getHour());
            pstmt.setString(4,subject.getId_subject());

            pstmt.executeUpdate();
        }
    }


    @Override
    public List<SubjectDto> listSubject() throws SQLException {
        List<SubjectDto> subjectList = new ArrayList<SubjectDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){

            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT * FROM subject");

            while(rs.next()){
                subjectList.add(new SubjectDto(rs.getString("id_subject")
                        ,rs.getString("subject")
                        ,rs.getString("id_semester")
                        ,rs.getInt("hour")
                        ,semesterService.getSemesterById(rs.getString("id_semester"))));
            }
        }
        return subjectList;
    }

    @Override
    public SubjectDto getSubjectById(String id) throws SQLException {
        SubjectDto subject = null;

        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM subject where id_subject = ?");

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                subject = new SubjectDto(rs.getString("id_subject")
                        ,rs.getString("subject")
                        ,rs.getString("id_semester")
                        ,rs.getInt("hour")
                        ,semesterService.getSemesterById(rs.getString("id_semester")));
            }
        }
        return subject;
    }

    @Override
    public void deleteSubject(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall(
                    "{call subject_delete(?)}");

            CS.setString(1, id);
            CS.executeUpdate();
        }
    }
}
