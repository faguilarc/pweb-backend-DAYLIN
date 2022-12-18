package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.Drop_out_causeDto;
import cu.edu.cujae.backend.core.service.Drop_out_causeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class Drop_out_causeServiceImpl implements Drop_out_causeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createDrop_out_cause(Drop_out_causeDto drop_out_cause) throws SQLException {
        try {
            CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call drop_out_cause_insert(?,?)}");
            CS.setString(1,drop_out_cause.getId_drop_out_cause());
            CS.setString(2,drop_out_cause.getDrop_out_cause());

            CS.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateDrop_out_cause(Drop_out_causeDto drop_out_cause) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call drop_out_cause_update(?, ?)}");
            CS.setString(1, drop_out_cause.getId_drop_out_cause());
            CS.setString(2,drop_out_cause.getDrop_out_cause());

            CS.executeUpdate();

            System.out.println("PAsamooooos por AQUIIIIIIIIIIIIIII");
        }
    }


    @Override
    public List<Drop_out_causeDto> listDrop_out_cause() throws SQLException {
        List<Drop_out_causeDto> drop_out_causeList = new ArrayList<Drop_out_causeDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT * FROM drop_out_cause");

            while(rs.next()){
                drop_out_causeList.add(new Drop_out_causeDto(rs.getString("id_drop_out_cause")
                        ,rs.getString("drop_out_cause")));
            }
        }
        return drop_out_causeList;
    }

    @Override
    public Drop_out_causeDto getDrop_out_causeById(String id) throws SQLException {
        Drop_out_causeDto drop_out_cause = null;
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM drop_out_cause where id_drop_out_cause = ?");
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                drop_out_cause = new Drop_out_causeDto(rs.getString("id_drop_out_cause")
                        ,rs.getString("drop_out_cause"));
            }

        }

        return drop_out_cause;
    }

    @Override
    public void deleteDrop_out_cause(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall("delete  from drop_out_cause where id_drop_out_cause = ?");

            CS.setString(1, id);
            CS.executeUpdate();
            System.out.println("PAsamooooos por AQUIIIIIIIIIIIIIII");
        }
    }


}
