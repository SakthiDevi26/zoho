package view.admin;

import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetIdUsingId;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetAllIdList;
import databaseoperations.interfaces.gettable.IdGettable;
import databaseoperations.interfaces.gettable.IdListGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;

public class ViewAllOrders {
	
	public void viewAllOrders() {		
		
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		IdListGettable getIdList = new GetAllIdList();
		IdGettable getId = new GetIdUsingId();
		
		ArrayList<Integer> orderIdList = new ArrayList<Integer>();
		orderIdList = getIdList.getAllIdList(ShoppingAppConstants.ordersTable, ShoppingAppConstants.orderIdColumn);
		if(!orderIdList.isEmpty())
		{
			System.out.println(ShoppingAppConstants.equalLine+"\n");
			System.out.println("\t\t\t\tORDERS RECEIVED");
			System.out.println(ShoppingAppConstants.equalLine+"\n");
			System.out.printf("%30s %20s\n","Order Id",
					"Product Name");
			System.out.println("\t\t"+ShoppingAppConstants.underscoreLine);
	
			ListIterator<Integer> orderIdListIterator = orderIdList.listIterator();
			while(orderIdListIterator.hasNext())
			{
				int productId = getId.getId(orderIdListIterator.next(),ShoppingAppConstants.productIdColumn, ShoppingAppConstants.ordersTable,ShoppingAppConstants.orderIdColumn);
				orderIdListIterator.previous();
				String productName = getProductDetails.getProductDetail(productId,ShoppingAppConstants.productNameColumn);
				System.out.printf("%30s %20s\n", orderIdListIterator.next(),productName);
			}
			System.out.println("\n"+ShoppingAppConstants.equalLine);	
		}
	}
}
