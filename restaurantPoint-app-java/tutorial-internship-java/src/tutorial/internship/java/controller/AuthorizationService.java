package tutorial.internship.java.controller;

import java.util.Arrays;
import tutorial.internship.java.model.UserFeature.*;
import java.util.List;

import tutorial.internship.java.model.UserFeature;
import tutorial.internship.login.UserRole;

public class AuthorizationService {

	public List<UserFeature> getUserFeaturesByUserRole(UserRole userRole){
		
		switch(userRole) {
		case ADMIN: 
			return Arrays.asList(UserFeature.RESTAURANT_POINT, UserFeature.RESTAURANT_MANAGER, UserFeature.MENU_MANAGER,UserFeature.MENU_ITEM_MANAGER, UserFeature.TABLE_MANAGER);
			
				
		case WAITER: 
			return Arrays.asList(UserFeature.RESTAURANT_POINT, UserFeature.TABLE_ORDERS, UserFeature.ORDER_STATUS);
			
		case COOK: 
			return Arrays.asList(UserFeature.RESTAURANT_POINT, UserFeature.ORDERS);
		default: throw new IllegalArgumentException("User role" + userRole + "is not supported");
		
		}
		
		
		
	}
}
