 package cu.edu.cujae.backend.core.dto;

 public class YearDto {

protected String id_year;
protected String year;


public YearDto(){
	super();

}


public YearDto(String id_year, String year) {

	super();
	this.id_year=id_year;
	this.year=year;
}


public YearDto(YearDto yearDto){
	super();
	this.id_year=yearDto.getId_year();
	this.year=yearDto.getYear();
}


public String getId_year() {
	return id_year;
}


public String getYear() {
	return year;
}


public void setId_year( String id_year) {

	this.id_year=id_year;
}

public void setYear( String year) {
	this.year=year;
}

}
