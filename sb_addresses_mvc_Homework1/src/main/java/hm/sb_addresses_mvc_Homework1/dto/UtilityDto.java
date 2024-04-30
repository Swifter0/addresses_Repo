package hm.sb_addresses_mvc_Homework1.dto;

public class UtilityDto {

	private int id;
	private String name;
	
	
	public UtilityDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "UtilityDto [id=" + id + ", name=" + name + "]";
	}
	
}
