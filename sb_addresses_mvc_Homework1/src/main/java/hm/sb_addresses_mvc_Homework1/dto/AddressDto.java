package hm.sb_addresses_mvc_Homework1.dto;

import java.util.List;

public class AddressDto {

	private String city;
	private String street;
	private List<UtilityDto> utilities;
	
	
	public AddressDto(String city, String street, List<UtilityDto> utilities) {
		super();
		this.city = city;
		this.street = street;
		this.utilities = utilities;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public List<UtilityDto> getUtilities() {
		return utilities;
	}


	public void setUtilities(List<UtilityDto> utilities) {
		this.utilities = utilities;
	}


	@Override
	public String toString() {
		return "AddressDto [city=" + city + ", street=" + street + ", utilities=" + utilities + "]";
	}
	
}
