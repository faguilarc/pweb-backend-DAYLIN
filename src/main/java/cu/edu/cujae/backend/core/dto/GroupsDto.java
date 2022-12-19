package cu.edu.cujae.backend.core.dto;


public class GroupsDto {

	protected String id_group;
	protected String group_name;
	protected String id_year;

	protected  YearDto yearDto;

	public GroupsDto() {
		super();

	}


	public GroupsDto(String id_group, String group_name, String id_year, YearDto yearDto) {

		super();
		this.id_group = id_group;
		this.group_name = group_name;
		this.id_year = id_year;
		this.yearDto = yearDto;
	}


	public GroupsDto(GroupsDto groupsDto) {
		super();
		this.id_group = groupsDto.getId_group();
		this.group_name = groupsDto.getGroup_name();
		this.id_year = groupsDto.getId_year();
	}


	public String getId_group() {
		return id_group;
	}


	public String getGroup_name() {
		return group_name;
	}


	public String getId_year() {
		return id_year;
	}

	public YearDto getYearDto() {
		return yearDto;
	}

	public void setId_group(String id_group) {
		this.id_group = id_group;
	}


	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}


	public void setId_year(String id_year) {
		this.id_year = id_year;
	}

	public void setYearDto(YearDto yearDto) {
		this.yearDto = yearDto;
	}
}
