package cu.edu.cujae.backend.core.dto;

public class StudentHistoryDto {
    private String idStudentHistory;
    private String idGroup;
    private int numList;
    private String idCourse;
    private String idStudent;

    protected CourseDto courseDto;
    protected GroupsDto groupsDto;
    protected StudentDto studentDto;

    public StudentHistoryDto(String idStudentHistory, String idGroup, int numList, String idCourse, String idStudent) {
        this.idStudentHistory = idStudentHistory;
        this.idGroup = idGroup;
        this.numList = numList;
        this.idCourse = idCourse;
        this.idStudent = idStudent;
    }

    public StudentHistoryDto(String idStudentHistory, String idGroup, int numList, String idCourse, String idStudent, CourseDto courseDto, GroupsDto groupsDto, StudentDto studentDto) {
        this.idStudentHistory = idStudentHistory;
        this.idGroup = idGroup;
        this.numList = numList;
        this.idCourse = idCourse;
        this.idStudent = idStudent;
        this.courseDto = courseDto;
        this.groupsDto = groupsDto;
        this.studentDto = studentDto;
    }

    public StudentHistoryDto() {

    }

    public CourseDto getCourseDto() {
        return courseDto;
    }

    public void setCourseDto(CourseDto courseDto) {
        this.courseDto = courseDto;
    }

    public GroupsDto getGroupsDto() {
        return groupsDto;
    }

    public void setGroupsDto(GroupsDto groupsDto) {
        this.groupsDto = groupsDto;
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    public String getIdStudentHistory() {
        return this.idStudentHistory;
    }

    public void setIdStudentHistory(String idStudentHistory) {
        this.idStudentHistory = idStudentHistory;
    }

    public String getIdGroup() {
        return this.idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public int getNumList() {
        return this.numList;
    }

    public void setNumList(int numList) {
        this.numList = numList;
    }

    public String getIdCourse() {
        return this.idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getIdStudent() {
        return this.idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }
}
