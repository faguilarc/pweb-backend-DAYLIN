package cu.edu.cujae.backend.core.dto;


public class StudentDto {

	protected String student_ci;
	protected String student_name;
	protected String first_surname;
	protected String second_surname;
	protected String sex;
	protected String id_town;
	protected String id_student;

	protected TownDto townDto;


	public StudentDto() {
		super();

	}

	public StudentDto(String student_ci, String student_name, String first_surname, String second_surname, String sex, String id_town, String id_student, TownDto townDto) {
		this.student_ci = student_ci;
		this.student_name = student_name;
		this.first_surname = first_surname;
		this.second_surname = second_surname;
		this.sex = sex;
		this.id_town = id_town;
		this.id_student = id_student;
		this.townDto = townDto;
	}

	public StudentDto(StudentDto studentDto) {
		super();
		this.student_ci = studentDto.getStudent_ci();
		this.student_name = studentDto.getStudent_name();
		this.first_surname = studentDto.getFirst_surname();
		this.second_surname = studentDto.getSecond_surname();
		this.sex = studentDto.getSex();
		this.id_town = studentDto.getId_town();
		this.id_student = studentDto.getId_student();

	}


	public String getStudent_ci() {
		return student_ci;
	}

	public void setStudent_ci(String student_ci) {
		this.student_ci = student_ci;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getFirst_surname() {
		return first_surname;
	}

	public void setFirst_surname(String first_surname) {
		this.first_surname = first_surname;
	}

	public String getSecond_surname() {
		return second_surname;
	}

	public void setSecond_surname(String second_surname) {
		this.second_surname = second_surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getId_town() {
		return id_town;
	}

	public void setId_town(String id_town) {
		this.id_town = id_town;
	}

	public String getId_student() {
		return id_student;
	}

	public void setId_student(String id_student) {
		this.id_student = id_student;
	}

	public TownDto getTownDto() {
		return townDto;
	}

	public void setTownDto(TownDto townDto) {
		this.townDto = townDto;
	}
}
