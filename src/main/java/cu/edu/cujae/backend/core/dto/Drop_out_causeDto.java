package cu.edu.cujae.backend.core.dto;

public class Drop_out_causeDto {

	protected String id_drop_out_cause;
	protected String drop_out_cause;


	public Drop_out_causeDto() {
		super();

	}


	public Drop_out_causeDto(String id_drop_out_cause, String drop_out_cause) {

		super();
		this.id_drop_out_cause = id_drop_out_cause;
		this.drop_out_cause = drop_out_cause;
	}


	public Drop_out_causeDto(Drop_out_causeDto drop_out_causeDto) {
		super();
		this.id_drop_out_cause = drop_out_causeDto.getId_drop_out_cause();
		this.drop_out_cause = drop_out_causeDto.getDrop_out_cause();
	}


	public String getId_drop_out_cause() {
		return id_drop_out_cause;
	}


	public String getDrop_out_cause() {
		return drop_out_cause;
	}


	public void setId_drop_out_cause(String id_drop_out_cause) {
		this.id_drop_out_cause = id_drop_out_cause;
	}


	public void setDrop_out_cause(String drop_out_cause) {
		this.drop_out_cause = drop_out_cause;
	}

}
