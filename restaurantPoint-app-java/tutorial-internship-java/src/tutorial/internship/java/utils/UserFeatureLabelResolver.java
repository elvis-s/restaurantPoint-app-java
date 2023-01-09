package tutorial.internship.java.utils;

import java.util.HashMap;
import java.util.Map;
import tutorial.internship.java.model.UserFeature.*;
import tutorial.internship.java.model.UserFeature;

public class UserFeatureLabelResolver {
 
	private static Map<UserFeature, String> userFeatureLabelMap;
    
	public static String getUserFeatureLabel(UserFeature userFeature) {
    	return getUserFeatureLabelMap().get(userFeature);
    }
  private static Map<UserFeature, String>getUserFeatureLabelMap(){
	 if(userFeatureLabelMap == null) {
		 userFeatureLabelMap = new HashMap<>();
		 userFeatureLabelMap.put(UserFeature.RESTAURANT_POINT, "Restaurant Point");
		 userFeatureLabelMap.put(UserFeature.RESTAURANT_MANAGER, "Restaurant Manager");
		 userFeatureLabelMap.put(UserFeature.MENU_MANAGER, "Menu Manager");
		 userFeatureLabelMap.put(UserFeature.MENU_ITEM_MANAGER, "Menu Item Manager");
		 userFeatureLabelMap.put(UserFeature.TABLE_MANAGER, "Table Manager");
		 userFeatureLabelMap.put(UserFeature.TABLE_ORDERS, "Table Orders");
		 userFeatureLabelMap.put(UserFeature.ORDER_STATUS, "Order Status");
		 userFeatureLabelMap.put(UserFeature.ORDERS, "Orders");
	 }
		 return userFeatureLabelMap;
 }
}
