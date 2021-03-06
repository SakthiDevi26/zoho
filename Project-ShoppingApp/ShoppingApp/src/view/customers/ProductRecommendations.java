package view.customers;

import java.util.Map;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.GetDetailsInHashMapFromDatabase;
import databaseoperations.interfaces.gettable.DetailsInHashMapGettable;

public class ProductRecommendations {
	
	int productId;

	public int showProductRecommendations() {
		
		Scanner scanner = new Scanner(System.in);

		DetailsInHashMapGettable getDetailsMapFromDb = new GetDetailsInHashMapFromDatabase();
		Map<Integer, String> productRecommendationMap = getDetailsMapFromDb.getProductRecommendationDetails();
		
		System.out.println("\n-----------------------<< Enjoy Your Hustle Free Shopping >>---------------------\n");
		System.out.printf("%20s\n",ShoppingAppConstants.productRecommendation);
		System.out.printf("%12s %25s\n","Product Id","Product Name");
		System.out.println(ShoppingAppConstants.underscoreLine);
		
		for(Map.Entry<Integer, String> entry : productRecommendationMap.entrySet()) {
			
			System.out.printf("%12d %25s\n",entry.getKey(),entry.getValue());
			System.out.println(ShoppingAppConstants.hyphenLine);
		}
		System.out.println("\nEnter the product id to view the product:");
		System.out.println("Not interested in any? press 0");
		productId = scanner.nextInt();
		
		//if customer enters the productId in random options
		if(productRecommendationMap.containsKey(productId)) {
			
			return productId;
		}
		else if(productId!=0) {//if customer enters invalid id any number other than 0
			
			return 1;
		}

		return 0; //if customer doesn't like any random product
			
	}

}
