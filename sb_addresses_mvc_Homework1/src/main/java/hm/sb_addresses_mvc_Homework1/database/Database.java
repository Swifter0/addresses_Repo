package hm.sb_addresses_mvc_Homework1.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;
import org.springframework.stereotype.Repository;

import hm.sb_addresses_mvc_Homework1.model.Address;
import hm.sb_addresses_mvc_Homework1.model.User;

@Repository
public class Database {

	private SessionFactory sessionFactory;
	
	
	public Database() {
		
		Configuration config = new Configuration();
		config.configure();
		
		this.sessionFactory = config.buildSessionFactory();
		
	}


	public User getUserById(String userId) {
		
		User user = null;
		List<Address> addresses = new ArrayList<>();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		/**User lekérése*/
		user = session.get(User.class, userId);
		
		if(user != null) {
			
			/**Ha a userünk megvan lekérjük a hozzá tartozó címeket*/
			SelectionQuery<Address> query = 
					session.createSelectionQuery("SELECT a FROM Address a WHERE userid = ?1",Address.class);
			
			query.setParameter(1, userId);
			
			addresses = query.getResultList();
			
			/**Minden címhez feltöltjük a utility ID listát*/
			for(int index = 0; index < addresses.size(); index++) {
				
				Address currentAddress = addresses.get(index);
				
				Query nQuery =
						session.createNativeQuery("SELECT * FROM addresses_utilities_mapping WHERE addressid = ?", Object[].class);
				nQuery.setParameter(1, currentAddress.getId());
				
				
				List<Object[]> rows = nQuery.getResultList();
				
				for(int rowsIndex = 0; rowsIndex < rows.size(); index++) {
					
					Object[] currentObject = rows.get(rowsIndex);
					
					int utilityId = Integer.parseInt(currentObject[2].toString());
					currentAddress.addUtility(utilityId);
				}
				
				user.addAddress(currentAddress);
				
			}
			
				
		}
		
		tx.commit();
		session.close();
		
		return user;
	}
	
	
	
	
	
	
	
	
	
}
