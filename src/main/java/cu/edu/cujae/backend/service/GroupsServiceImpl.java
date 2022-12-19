package cu.edu.cujae.backend.service;

import cu.edu.cujae.backend.core.dto.GroupsDto;
import cu.edu.cujae.backend.core.service.GroupsService;
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
public class GroupsServiceImpl implements GroupsService {
    @Autowired
    private YearService yearService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createGroups(GroupsDto groups) throws SQLException {
        try {
            CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call groups_insert(?, ?, ?)}");
            CS.setString(1,groups.getId_group());
            CS.setString(2, groups.getGroup_name());
            CS.setString(3, groups.getId_year());

            CS.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateGroups(GroupsDto groups) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("update groups set group_name = ?, id_year = ? where id_groups = ?");

            pstmt.setString(1, groups.getGroup_name());
            pstmt.setString(2, groups.getId_year());
            pstmt.setString(3, groups.getId_group());

            pstmt.executeUpdate();
        }

    }

    @Override
    public List<GroupsDto> listGroups() throws SQLException {
        List<GroupsDto> groupsList = new ArrayList<GroupsDto>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM groups");

            while(rs.next()){
                System.out.println("Entreee a rellenar la lista");
                groupsList.add(new GroupsDto(rs.getString("id_groups")
                        ,rs.getString("group_name")
                        ,rs.getString("id_year")
                        ,yearService.getYearById(rs.getString("id_year"))));
            }
        }
        return groupsList;
    }

    @Override
    public GroupsDto getGroupsById(String id) throws SQLException {
        GroupsDto groups = null;

        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM groups where id_groups = ?");

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                groups = new GroupsDto(rs.getString("id_groups")
                        ,rs.getString("group_name")
                        ,rs.getString("id_year")
                        ,yearService.getYearById(rs.getString("id_year")));
            }
        }

        return groups;
    }

    @Override
    public void deleteGroups(String id) throws SQLException {
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()){
            CallableStatement CS = conn.prepareCall(
                    "{call groups_delete(?)}");

            CS.setString(1, id);
            CS.executeUpdate();
        }
    }
}
