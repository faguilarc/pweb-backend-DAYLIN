package cu.edu.cujae.backend.core.dto;

public class SubjectDto {

    protected String id_subject;
    protected String subject;
    protected String id_semester;
    protected Integer hour;

    protected SemesterDto semesterDto;


    public SubjectDto() {
        super();

    }

    public SubjectDto(String id_subject, String subject, String id_semester, Integer hour, SemesterDto semesterDto) {
        this.id_subject = id_subject;
        this.subject = subject;
        this.id_semester = id_semester;
        this.hour = hour;
        this.semesterDto = semesterDto;
    }

    public SubjectDto(SubjectDto subjectDto) {
        super();
        this.id_subject = subjectDto.getId_subject();
        this.subject = subjectDto.getSubject();
        this.id_semester = subjectDto.getId_semester();
        this.hour = subjectDto.getHour();
        this.semesterDto = subjectDto.getSemesterDto();
    }


    public String getId_subject() {
        return id_subject;
    }

    public void setId_subject(String id_subject) {
        this.id_subject = id_subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getId_semester() {
        return id_semester;
    }

    public void setId_semester(String id_semester) {
        this.id_semester = id_semester;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public SemesterDto getSemesterDto() {
        return semesterDto;
    }

    public void setSemesterDto(SemesterDto semesterDto) {
        this.semesterDto = semesterDto;
    }
}
