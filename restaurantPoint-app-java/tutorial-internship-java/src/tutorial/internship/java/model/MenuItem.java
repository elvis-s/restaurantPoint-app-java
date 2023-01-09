package tutorial.internship.java.model;

public class MenuItem {
private int id;
private String menuItemName;
private MenuItemCathegory mealDrink;
private double price;
private String menuName;
private String restaurantName;

public String getMenuName() {
	return menuName;
}

public String getRestaurantName() {
	return restaurantName;
}

public void setRestaurantName(String restaurantName) {
	this.restaurantName = restaurantName;
}

public void setMenuName(String menuName) {
	this.menuName = menuName;
}

public MenuItem (String restaurantName,String menuName,int id, String menuItemName,MenuItemCathegory mealDrink,Double price ) {
	
	this.id=id;
	this.menuItemName=menuItemName;
	this.mealDrink = mealDrink;
	this.price= price;
	this.menuName=menuName;
	this.restaurantName= restaurantName;
}

public int getId() {
	return id;
}

public void setId(int id) {
	id = id;
}

public String getMenuItemName() {
	return menuItemName;
}

public void setMenuItemName(String menuItemName) {
	menuItemName = menuItemName;
}

public double getPrice() {
	return price;
}

public MenuItemCathegory getMealDrink() {
	return mealDrink;
}

public void setMealDrink(MenuItemCathegory mealDrink) {
	this.mealDrink = mealDrink;
}

public void setPrice(double price) {
	price = price;
}

}
