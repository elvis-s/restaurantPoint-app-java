package tutorial.internship.java.model;

import tutorial.internship.login.UserRole;

public class User {
private String userName;
private String password;
private UserRole userRole;

 
 public User(String userName, String password, UserRole userRole) {
	
	this.userName = userName;
	this.password = password;
	this.userRole = userRole;
}

public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}

public UserRole getUserRole() {
	return userRole;
}



}
