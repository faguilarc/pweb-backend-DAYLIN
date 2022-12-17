package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.YearDto;

import java.sql.SQLException;
import java.util.List;

public interface YearService {
    void createYear(YearDto year) throws SQLException;

    void updateYear(YearDto year) throws SQLException;

    List<YearDto> listYear() throws SQLException;

    YearDto getYearById(String id) throws SQLException;

    void deleteYear(String id) throws SQLException;
}
