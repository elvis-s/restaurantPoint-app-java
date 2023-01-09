package tutorial.internship.login.dataproviders;

import java.util.ArrayList;
import java.util.List;

import tutorial.internship.java.model.User;
import tutorial.internship.login.UserRole;

public class UserDataProvider {
  
	private List<User> userList = new ArrayList<>();
  
  public UserDataProvider() {
	  
  userList.add(new User("1", "1", UserRole.ADMIN));
  userList.add(new User("testWaiter1", "waiter123", UserRole.WAITER));
  userList.add(new User("testWaiter1", "waiter654", UserRole.WAITER));
  userList.add(new User("testCook", "cook123", UserRole.COOK));
  }

  public List<User> getUserList(){
	return userList;
}
 
}
