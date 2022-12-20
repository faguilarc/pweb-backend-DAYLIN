package cu.edu.cujae.backend.core.dto;

public class SemesterDto {

	protected String id_semester;
	protected String semester;
	protected String id_year;
	protected String id_course;

	protected YearDto yearDto;
	protected CourseDto courseDto;


	public SemesterDto() {
		super();

	}

	public SemesterDto(String id_semester, String semester, String id_year, String id_course, YearDto yearDto, CourseDto courseDto) {
		this.id_semester = id_semester;
		this.semester = semester;
		this.id_year = id_year;
		this.id_course = id_course;
		this.yearDto = yearDto;
		this.courseDto = courseDto;
	}

	public SemesterDto(SemesterDto semesterDto){
		super();
		this.id_semester= semesterDto.getId_semester();
		this.semester= semesterDto.getSemester();
		this.id_year= semesterDto.getId_year();
		this.id_course= semesterDto.getId_course();
		this.yearDto= semesterDto.getYearDto();
		this.courseDto= semesterDto.getCourseDto();
	}

	public String getId_semester() {
		return id_semester;
	}

	public void setId_semester(String id_semester) {
		this.id_semester = id_semester;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getId_year() {
		return id_year;
	}

	public void setId_year(String id_year) {
		this.id_year = id_year;
	}

	public String getId_course() {
		return id_course;
	}

	public void setId_course(String id_course) {
		this.id_course = id_course;
	}

	public YearDto getYearDto() {
		return yearDto;
	}

	public void setYearDto(YearDto yearDto) {
		this.yearDto = yearDto;
	}

	public CourseDto getCourseDto() {
		return courseDto;
	}

	public void setCourseDto(CourseDto courseDto) {
		this.courseDto = courseDto;
	}
}
