package cu.edu.cujae.backend.core.dto;

public class Subject_student_repeatingDto {

    protected String id_subject;
    protected String id_student_repeating;


    protected Student_repeatingDto student_repeatingDto;
    protected SubjectDto subjectDto;


    public Subject_student_repeatingDto() {
        super();

    }

    public Subject_student_repeatingDto(String id_subject, String id_student_repeating, Student_repeatingDto student_repeatingDto, SubjectDto subjectDto) {
        this.id_subject = id_subject;
        this.id_student_repeating = id_student_repeating;

        this.student_repeatingDto = student_repeatingDto;
        this.subjectDto = subjectDto;
    }

    public Subject_student_repeatingDto(Subject_student_repeatingDto subject_student_repeatingDto) {
        super();
        this.id_subject = subject_student_repeatingDto.getId_subject();
        this.id_student_repeating = subject_student_repeatingDto.getId_student_repeating();
    }

    public String getId_subject() {
        return id_subject;
    }

    public void setId_subject(String id_subject) {
        this.id_subject = id_subject;
    }

    public String getId_student_repeating() {
        return id_student_repeating;
    }

    public void setId_student_repeating(String id_student_repeating) {
        this.id_student_repeating = id_student_repeating;
    }

    public Student_repeatingDto getStudent_repeatingDto() {
        return student_repeatingDto;
    }

    public void setStudent_repeatingDto(Student_repeatingDto student_repeatingDto) {
        this.student_repeatingDto = student_repeatingDto;
    }

    public SubjectDto getSubjectDto() {
        return subjectDto;
    }

    public void setSubjectDto(SubjectDto subjectDto) {
        this.subjectDto = subjectDto;
    }
}
