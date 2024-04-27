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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Transient
	private List<Integer> addressid;

	public User() {
		this.addressid = new ArrayList<>();
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

	public List<Integer> getAddressid() {
		return addressid;
	}

	public void setAddressid(List<Integer> addressid) {
		this.addressid = addressid;
	}
	
	public void addAddressId(int id) {
		
		this.addressid.add(id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addressid=" + addressid + "]";
	}
	
}
