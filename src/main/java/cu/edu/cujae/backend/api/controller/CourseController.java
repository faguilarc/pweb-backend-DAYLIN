package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.CourseDto;
import cu.edu.cujae.backend.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseEntity<List<CourseDto>> getCourses() throws SQLException {
        List<CourseDto> courseList = courseService.listCourse();
        return ResponseEntity.ok(courseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String id) throws SQLException {
        CourseDto courseDto = courseService.getCourseById(id);
        return ResponseEntity.ok(courseDto);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody CourseDto course) throws SQLException {
        courseService.createCourse(course);
        return ResponseEntity.ok("Course Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody CourseDto course) throws SQLException {
        courseService.updateCourse(course);
        return ResponseEntity.ok("Course Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted");
    }
}
