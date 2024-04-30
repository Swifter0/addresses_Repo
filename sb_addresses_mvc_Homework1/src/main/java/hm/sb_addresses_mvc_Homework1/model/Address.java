package hm.sb_addresses_mvc_Homework1.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "userid")
	private int userid;
	
	@Transient
	private List<Integer> utilities;
	
	
	public Address() {
		
		this.utilities = new ArrayList<>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public List<Integer> getUtilities() {
		return utilities;
	}


	public void setUtilities(List<Integer> utilities) {
		this.utilities = utilities;
	}
	
	public void addUtility(int id) {
		
		this.utilities.add(id);
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street=" + street + ", userid=" + userid + ", utilities="
				+ utilities + "]";
	}

}
