package hm.sb_addresses_mvc_Homework1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hm.sb_addresses_mvc_Homework1.database.Database;
import hm.sb_addresses_mvc_Homework1.dto.AddressDto;
import hm.sb_addresses_mvc_Homework1.dto.UserDto;
import hm.sb_addresses_mvc_Homework1.dto.UtilityDto;
import hm.sb_addresses_mvc_Homework1.model.Address;
import hm.sb_addresses_mvc_Homework1.model.User;

@Service
public class AppService {

	private Database db;

	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}

	public UserDto getUserById(String userId) {
		
		UserDto uDto = null;
		
		User user = db.getUserById(userId);
		
		if(user != null) {
			
			List<Address> userAddresses = user.getAddress();
			List<AddressDto> userAddressesDto = new ArrayList<>();
			
			for(int mainIndex = 0; mainIndex < userAddresses.size(); mainIndex++) {
				
				Address currentAddress =  userAddresses.get(mainIndex);
				
				List<Integer> addressUtilities = currentAddress.getUtilities();
				List<UtilityDto> addressUtilitiesDto = new ArrayList<>();
				
				for(int secondIndex = 0; secondIndex < addressUtilities.size(); secondIndex++) {
					
					int currentUtilityId = addressUtilities.get(secondIndex);
					
					RestTemplate rt = new RestTemplate();
					UtilityDto utilityDto =
							rt.getForObject("http://localhost:8081/utility/" + currentUtilityId, UtilityDto.class);
					
					addressUtilitiesDto.add(utilityDto);
				}
				
				AddressDto addressDto = new AddressDto(
						currentAddress.getCity(),
						currentAddress.getStreet(),
						addressUtilitiesDto
						);
				
				userAddressesDto.add(addressDto);
				
			}
			
			uDto = new UserDto(
					user.getId(),
					user.getName(),
					userAddressesDto
					);
					
		}
		
		return uDto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
