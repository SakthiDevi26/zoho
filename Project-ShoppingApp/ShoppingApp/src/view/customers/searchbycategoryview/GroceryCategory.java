package view.customers.searchbycategoryview;

import java.util.Map;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.databasegetoperations.GetDetailsInHashMapFromDatabase;
import databaseoperations.interfaces.checkable.ProductIdCheckable;
import databaseoperations.interfaces.gettable.DetailsInHashMapGettable;

public class GroceryCategory {
	
	int productId;
	
	public int showGroceryCategoryProducts() {
		
		String productCategory ="grocery";
		Scanner scanner = new Scanner(System.in);
		ProductIdCheckable checkProductId = new CheckProductId();
		DetailsInHashMapGettable getDetailsMapFromDb = new GetDetailsInHashMapFromDatabase();
		
		Map<Integer, String> productByCategoryMap = getDetailsMapFromDb.getProductByCategoryDetails(productCategory);
		if(!productByCategoryMap.isEmpty()) {
		
			System.out.println(ShoppingAppConstants.smallHyphen+"<< Healthy eating is a journey that begins here >>"+ShoppingAppConstants.smallHyphen+"\n");
			System.out.printf("%12s %25s\n","Product Id",
					"Product Name");
			System.out.println(ShoppingAppConstants.underscoreLine);
			
			for(Map.Entry<Integer, String> entry : productByCategoryMap.entrySet()) {
				
				System.out.printf("%12d %25s\n",entry.getKey(),entry.getValue());
				System.out.println(ShoppingAppConstants.hyphenLine);
			}
			System.out.println("Enter ProductId of the product you love: ");
			
			productId = scanner.nextInt();
			if(checkProductId.isProductIdInProductTable(productId)) {
				
				return productId;
			}
		}
		else {
			
			System.out.println("Sorry there is no Grocery product");
		}
		
		return 0;		
	}
}
