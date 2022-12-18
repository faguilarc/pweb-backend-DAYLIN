package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.Drop_out_causeDto;

import java.sql.SQLException;
import java.util.List;


public interface Drop_out_causeService {
    void createDrop_out_cause(Drop_out_causeDto drop_out_cause) throws SQLException;

    void updateDrop_out_cause(Drop_out_causeDto drop_out_cause) throws SQLException;

    List<Drop_out_causeDto> listDrop_out_cause() throws SQLException;

    Drop_out_causeDto getDrop_out_causeById(String Id) throws SQLException;

    void deleteDrop_out_cause(String id) throws SQLException;
}
