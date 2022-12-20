package cu.edu.cujae.backend.core.dto;

import java.sql.Date;

public class EvaluationDto {
    private String idEvaluation;
    private Integer evaluation;
    private String idSubject;
    private String idStudentHistory;
    private java.sql.Date date;

    StudentHistoryDto studentHistoryDto;
    SubjectDto subjectDto;

    public EvaluationDto() {
    }

    public EvaluationDto(String idEvaluation, int evaluation, String idSubject, String idStudentHistory, Date date) {
        this.idEvaluation = idEvaluation;
        this.evaluation = evaluation;
        this.idSubject = idSubject;
        this.idStudentHistory = idStudentHistory;
        this.date = date;
    }

    public EvaluationDto(String idEvaluation, int evaluation, String idSubject, String idStudentHistory, Date date, StudentHistoryDto studentHistoryDto, SubjectDto subjectDto) {
        this.idEvaluation = idEvaluation;
        this.evaluation = evaluation;
        this.idSubject = idSubject;
        this.idStudentHistory = idStudentHistory;
        this.date = date;
        this.studentHistoryDto = studentHistoryDto;
        this.subjectDto = subjectDto;
    }

    public StudentHistoryDto getStudentHistoryDto() {
        return studentHistoryDto;
    }

    public void setStudentHistoryDto(StudentHistoryDto studentHistoryDto) {
        this.studentHistoryDto = studentHistoryDto;
    }

    public SubjectDto getSubjectDto() {
        return subjectDto;
    }

    public void setSubjectDto(SubjectDto subjectDto) {
        this.subjectDto = subjectDto;
    }

    public String getIdEvaluation() {
        return this.idEvaluation;
    }

    public void setIdEvaluation(String idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public int getEvaluation() {
        return this.evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }

    public String getIdSubject() {
        return this.idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getIdStudentHistory() {
        return this.idStudentHistory;
    }

    public void setIdStudentHistory(String idStudentHistory) {
        this.idStudentHistory = idStudentHistory;
    }

    public java.sql.Date getDate() {
        return this.date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }
}
