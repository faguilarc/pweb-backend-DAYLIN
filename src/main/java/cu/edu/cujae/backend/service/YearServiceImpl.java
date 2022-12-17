package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.YearDto;
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
public class YearServiceImpl implements YearService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createYear(YearDto year) throws SQLException {
        try {
            CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call year_insert(?, ?)}");
            CS.setString(1, year.getId_year());
            CS.setString(2,year.getYear());

            CS.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateYear(YearDto year) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("{call year_update(?,?)}");
            pstmt.setString(1, year.getId_year());
            pstmt.setString(2,year.getYear());
            pstmt.executeUpdate();
        }
        //CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall();

    }

    @Override
    public List<YearDto> listYear() throws SQLException {
        List<YearDto> yearList = new ArrayList<YearDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT * FROM year");
            while(rs.next()){
                yearList.add(new YearDto(rs.getString("id_year")
                        ,rs.getString("year")));
            }
        }

        return yearList;
    }

    @Override
    public YearDto getYearById(String id) throws SQLException {
        YearDto year = null;
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM year where id_year = ?");

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                year = new YearDto(rs.getString("id_year")
                        ,rs.getString("year"));
            }
        }

        return year;
    }

    @Override
    public void deleteYear(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall(
                    "{call year_delete(?)}");

            CS.setString(1, id);
            CS.executeUpdate();
        }

    }
}
