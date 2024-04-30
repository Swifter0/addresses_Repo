package hm.sb_addresses_mvc_Homework1.dto;

import java.util.List;


public class UserDto {

	private int id;
	private String name;
	private List<AddressDto> addresses;
	
	
	public UserDto(int id, String name, List<AddressDto> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.addresses = addresses;
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


	public List<AddressDto> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
	}
	
}
