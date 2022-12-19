package cu.edu.cujae.backend.core.dto;

import java.sql.Date;


public class CourseDto {
    private String idCourse;
    private String course;
    private Date beginDate;
    private Date endDate;

    public CourseDto(String idCourse, String course, Date beginDate, Date endDate) {
        this.idCourse = idCourse;
        this.course = course;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
