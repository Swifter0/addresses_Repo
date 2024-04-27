package hm.sb_addresses_mvc_Homework1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hm.sb_addresses_mvc_Homework1.database.Database;

@Service
public class AppService {

	private Database db;

	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
