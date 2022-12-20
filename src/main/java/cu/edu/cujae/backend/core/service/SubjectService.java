package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.SubjectDto;

import java.sql.SQLException;
import java.util.List;

public interface SubjectService {

    void createSubject(SubjectDto subject) throws SQLException;

    void updateSubject(SubjectDto subject) throws SQLException;

    List<SubjectDto> listSubject() throws SQLException;

    SubjectDto getSubjectById(String id) throws SQLException;

    void deleteSubject(String id) throws SQLException;
}
