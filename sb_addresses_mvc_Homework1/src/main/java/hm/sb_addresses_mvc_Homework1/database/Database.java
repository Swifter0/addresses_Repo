package hm.sb_addresses_mvc_Homework1.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class Database {

	private SessionFactory sessionFactory;
	
	
	public Database() {
		
		Configuration config = new Configuration();
		config.configure();
		
		this.sessionFactory = config.buildSessionFactory();
		
	}
	
	
	
	
	
	
	
	
	
}
