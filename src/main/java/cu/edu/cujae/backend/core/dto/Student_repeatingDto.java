package cu.edu.cujae.backend.core.dto;


public class Student_repeatingDto {

	protected String id_student_repeating;
	protected String id_student;

	protected StudentDto studentDto;


	public Student_repeatingDto() {
		super();

	}


	public Student_repeatingDto(String id_student_repeating, String id_student, StudentDto studentDto) {
		this.id_student_repeating = id_student_repeating;
		this.id_student = id_student;
		this.studentDto = studentDto;
	}

	public Student_repeatingDto(Student_repeatingDto student_repeatingDto) {
		super();
		this.id_student_repeating = student_repeatingDto.getId_student_repeating();
		this.id_student = student_repeatingDto.getId_student();
	}


	public String getId_student_repeating() {
		return id_student_repeating;
	}

	public void setId_student_repeating(String id_student_repeating) {
		this.id_student_repeating = id_student_repeating;
	}

	public String getId_student() {
		return id_student;
	}

	public void setId_student(String id_student) {
		this.id_student = id_student;
	}


	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}
}
