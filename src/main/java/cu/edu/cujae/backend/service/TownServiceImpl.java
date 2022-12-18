package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.TownDto;
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
public class TownServiceImpl implements TownService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createTown(TownDto town) throws SQLException {
        try {
            CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call town_insert(?, ?)}");
            CS.setString(1, town.getId_town());
            CS.setString(2,town.getTown());

            CS.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateTown(TownDto town) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("update town set town = ? where id_town = ?");

            pstmt.setString(1,town.getTown());
            pstmt.setString(2, town.getId_town());

            pstmt.executeUpdate();
        }
    }

    @Override
    public List<TownDto> listTown() throws SQLException {
        List<TownDto> townList = new ArrayList<TownDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT * FROM town");
            while(rs.next()){
                townList.add(new TownDto(rs.getString("id_town")
                        ,rs.getString("town")));
            }
        }
        return townList;
    }

    @Override
    public TownDto getTownById(String id) throws SQLException {
        TownDto town = null;
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM town where id_town = ?");
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                town = new TownDto(rs.getString("id_town")
                        ,rs.getString("town"));
            }
        }

        return town;
    }

    @Override
    public void deleteTown(String id) throws SQLException {
        try(Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall(
                    "{call town_delete(?)}");
            CS.setString(1, id);
            CS.executeUpdate();
        }

    }
}
