package tutorial.internship.login;

import tutorial.internship.java.model.User;
import tutorial.internship.login.dataproviders.UserDataProvider;


public class LoginController {
	// singelton variable
		private static final LoginController INSTANCE = new LoginController();
		
		UserDataProvider userDataprovider = new UserDataProvider();
		
		private User loggedInUser = null;
		
		public LoginController() {
			
		}
		public void loginUser(String userName, String password) {
			for(User user: userDataprovider.getUserList()) {
				if(user.getUserName().equals(userName)&& 
						user.getPassword().equals(password)) {
					loggedInUser = user;
				}
			}
		//loggedInUser = new User(userName, password); 
			
		
		}
		
		
		public  User getLoggedInUser(){
			return loggedInUser;
			
		}
		
		
		public static LoginController getInstance() {
			
			return INSTANCE;
		}
		public boolean isStringNullOrBlank(String textValue) {
			return textValue == null|| textValue.isBlank();
			
		}
}
