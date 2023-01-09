package tutorial.internship.login;

import tutorial.internship.java.model.User;

public class RestaurantAdminView {
public void getAllRestaurantsFromAdmin() {
	// get all restaurant from the loggedInUser
	LoginController loginController = LoginController.getInstance();
	User loggedInUser = loginController.getLoggedInUser();
	
	System.out.println("Username: " +loggedInUser.getUserName() );
	System.out.println("Password: " +loggedInUser.getPassword() );
	
	
}
}
