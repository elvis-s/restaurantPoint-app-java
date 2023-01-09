package tutorial.internship.login.dataproviders;

import java.util.ArrayList;
import java.util.List;

import tutorial.internship.java.model.Menu;
import tutorial.internship.java.model.MenuItem;
import tutorial.internship.java.model.MenuItemCathegory;
import tutorial.internship.java.model.RestaurantData;

public class RestaurantDataProvider {

	
	
	public RestaurantDataProvider() {
		restaurantDetails();
		 menuData();	 menuItemData2();
		 menuItemData1();
	
		 menuItemData3();
		
	}
		List<RestaurantData>restaurantList = new ArrayList();
		
		private void restaurantDetails() {
		restaurantList.add(new RestaurantData("Juvenilja Castelo","Rruga e Durresit"));
		restaurantList.add(new RestaurantData("Kantina Enol","Rruga Myslym Shyri"));
		restaurantList.add(new RestaurantData("Royal Hill","Rruga e Kavajes"));
		restaurantList.add(new RestaurantData("Fish Time","Rruga Don Bosco"));
		
		}
	
	public List<RestaurantData> getRestaurantDataList(){
		return restaurantList;
		
	}

	List<Menu>menu = new ArrayList();
	
	public void menuData() {
		
	menu.add(new Menu("Menu #1"));
	menu.add(new Menu("Menu #2"));
	menu.add(new Menu("Menu #3"));
	}
	public List<Menu> getMenuList(){
	return menu;
		
	}
List<MenuItem>menuItem1 = new ArrayList();
	
	public void menuItemData1() {
		
	menuItem1.add(new MenuItem(null,"Menu #1",1,"Cola", MenuItemCathegory.DRINK, 2.1));
	menuItem1.add(new MenuItem(null,"Menu #1",2, "Fanta", MenuItemCathegory.DRINK, 3.8));
	menuItem1.add(new MenuItem(null,"Menu #1",3, "Pizza", MenuItemCathegory.DRINK, 1.8));
	menuItem1.add(new MenuItem(null,"Menu #1",4, "Sandwich", MenuItemCathegory.DRINK, 3.1));
	menuItem1.add(new MenuItem(null,"Menu #1",5, "Water", MenuItemCathegory.DRINK, 1.2));
	
	}
	public List<MenuItem> getMenuItemList1(){
	return menuItem1;
		
	}
List<MenuItem>menuItem2 = new ArrayList();
	
	public void menuItemData2() {
		
		menuItem1.add(new MenuItem(null,"Menu #2",6,"Cola", MenuItemCathegory.DRINK, 2.8));
		menuItem1.add(new MenuItem(null,"Menu #2",7, "Fanta", MenuItemCathegory.DRINK, 3.8));
		menuItem1.add(new MenuItem(null,"Menu #2",8, "Pizza", MenuItemCathegory.DRINK, 1.8));
		menuItem1.add(new MenuItem(null,"Menu #2",9, "Sandwich", MenuItemCathegory.DRINK, 3.1));
		menuItem1.add(new MenuItem(null,"Menu #2",10, "Water", MenuItemCathegory.DRINK, 1.2));
	
	}
	public List<MenuItem> getMenuItemList2(){
	return menuItem2;
		
	}
List<MenuItem>menuItem3 = new ArrayList();
	
	public void menuItemData3() {
		
		menuItem1.add(new MenuItem(null,"Menu #3",1,"Cola", MenuItemCathegory.DRINK, 2.18));
		menuItem1.add(new MenuItem(null,"Menu #3",2, "Fanta", MenuItemCathegory.DRINK, 3.8));
		menuItem1.add(new MenuItem(null,"Menu #3",3, "Pizza", MenuItemCathegory.DRINK, 1.8));
		menuItem1.add(new MenuItem(null,"Menu #3",4, "Sandwich", MenuItemCathegory.DRINK, 3.1));
		menuItem1.add(new MenuItem(null,"Menu #3",5, "Water", MenuItemCathegory.DRINK, 1.2));
	
	}
	public List<MenuItem> getMenuItemList3(){
	return menuItem3;
		
	}
	List<MenuItem>menuItem4 = new ArrayList();
public void menuItemData4() {
		
		menuItem1.add(new MenuItem("Juvenilja Castelo","Menu #3",1,"Cola", MenuItemCathegory.DRINK, 2.18));
		menuItem1.add(new MenuItem("Juvenilja Castelo","Menu #3",2, "Fanta", MenuItemCathegory.DRINK, 3.8));
		menuItem1.add(new MenuItem("Juvenilja Castelo","Menu #3",3, "Pizza", MenuItemCathegory.DRINK, 1.8));
		menuItem1.add(new MenuItem("Juvenilja Castelo","Menu #3",4, "Sandwich", MenuItemCathegory.DRINK, 3.1));
		menuItem1.add(new MenuItem("Juvenilja Castelo","Menu #3",5, "Water", MenuItemCathegory.DRINK, 1.2));
	
	}
	public List<MenuItem> getMenuItemList4(){
	return menuItem4;
		
	}	
}
