package cu.edu.cujae.backend.core.dto;


public class Student_drop_outDto {

	protected String id_student;
	protected String id_drop_out_cause;
	protected String id_student_drop_out;

	protected StudentDto studentDto;
	protected  Drop_out_causeDto drop_out_causeDto;

	public Student_drop_outDto() {
		super();

	}


	public Student_drop_outDto(String id_student, String id_drop_out_cause, String id_student_drop_out, StudentDto studentDto, Drop_out_causeDto drop_out_causeDto) {

		super();
		this.id_student = id_student;
		this.id_drop_out_cause = id_drop_out_cause;
		this.id_student_drop_out = id_student_drop_out;
		this.studentDto = studentDto;
		this.drop_out_causeDto = drop_out_causeDto;
	}


	public Student_drop_outDto(Student_drop_outDto student_drop_outDto) {
		super();
		this.id_student = student_drop_outDto.getId_student();
		this.id_drop_out_cause = student_drop_outDto.getId_drop_out_cause();
		this.id_student_drop_out = student_drop_outDto.getId_student_drop_out();
	}


	public String getId_student() {
		return id_student;
	}


	public String getId_drop_out_cause() {
		return id_drop_out_cause;
	}


	public String getId_student_drop_out() {
		return id_student_drop_out;
	}


	public void setId_student(String id_student) {
		this.id_student = id_student;
	}


	public void setId_drop_out_cause(String id_drop_out_cause) {
		this.id_drop_out_cause = id_drop_out_cause;
	}


	public void setId_student_drop_out(String id_student_drop_out) {
		this.id_student_drop_out = id_student_drop_out;
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

	public Drop_out_causeDto getDrop_out_causeDto() {
		return drop_out_causeDto;
	}

	public void setDrop_out_causeDto(Drop_out_causeDto drop_out_causeDto) {
		this.drop_out_causeDto = drop_out_causeDto;
	}
}
