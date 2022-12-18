package cu.edu.cujae.backend.core.dto;

public class TownDto {

    protected String id_town;
    protected String town;


    public TownDto() {
        super();

    }


    public TownDto(String id_town, String town) {

        super();
        this.id_town = id_town;
        this.town = town;
    }


    public TownDto(TownDto townDto) {
        super();
        this.id_town = townDto.getId_town();
        this.town = townDto.getTown();
    }


    public String getId_town() {
        return id_town;
    }


    public String getTown() {
        return town;
    }


    public void setId_town(String id_town) {
        this.id_town = id_town;
    }


    public void setTown(String town) {
        this.town = town;
    }




}
