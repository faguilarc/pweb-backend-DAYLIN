package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.SemesterDto;

import java.sql.SQLException;
import java.util.List;

public interface SemesterService {

    void createSemester(SemesterDto semester) throws SQLException;

    void updateSemester(SemesterDto semester) throws SQLException;

    List<SemesterDto> listSemester() throws SQLException;

    SemesterDto getSemesterById(String id) throws SQLException;

    void deleteSemester(String id) throws SQLException;
}
