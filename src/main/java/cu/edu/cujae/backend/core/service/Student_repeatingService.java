package cu.edu.cujae.backend.core.service;

import cu.edu.cujae.backend.core.dto.Student_repeatingDto;

import java.sql.SQLException;
import java.util.List;

public interface Student_repeatingService {
    void createStudent_repeating(Student_repeatingDto student_repeating) throws SQLException;

    void updateStudent_repeating(Student_repeatingDto student_repeating) throws SQLException;

    List<Student_repeatingDto> listStudent_repeatingDto() throws SQLException;

    Student_repeatingDto getStudent_repeatingById(String id) throws SQLException;

    void deleteStudent_repeating(String id) throws SQLException;
}
