package tutorial.internship.java.model;

public class RestaurantData {

	private String restaurantName;
	private String restaurantAddress;
	

public RestaurantData(String restaurantName, String restaurantAddress) {
	
	this.restaurantName = restaurantName;
	this.restaurantAddress = restaurantAddress;
	}


public String getRestaurantName() {
	return restaurantName;
}


public void setRestaurantName(String restaurantName) {
	this.restaurantName = restaurantName;
}


public String getRestaurantAddress() {
	return restaurantAddress;
}


public void setRestaurantAddress(String restaurantAddress) {
	this.restaurantAddress = restaurantAddress;
}


}