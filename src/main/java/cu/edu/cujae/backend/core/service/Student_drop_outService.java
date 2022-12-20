package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.Student_drop_outDto;

import java.sql.SQLException;
import java.util.List;

public interface Student_drop_outService {

    void createStudent_drop_out(Student_drop_outDto student_drop_out) throws SQLException;

    void updateStudent_drop_out(Student_drop_outDto student_drop_out) throws SQLException;

    List<Student_drop_outDto> listStudent_drop_out() throws SQLException;

    Student_drop_outDto getStudent_drop_outDtoById(String id) throws SQLException;

    void deleteStudent_drop_outDto(String id) throws SQLException;
}
