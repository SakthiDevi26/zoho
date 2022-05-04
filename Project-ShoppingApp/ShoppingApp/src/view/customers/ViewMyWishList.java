package view.customers;


import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetProductIdList;
import driver.customers.CustomerMainDriver;
import driver.customers.MyWishListDriver;


public class ViewMyWishList {
	CustomerMainDriver customerMainDrive = new CustomerMainDriver();
	CheckProductId checkProductId = new CheckProductId();
	Scanner scanner = new Scanner(System.in);
	public void viewMyWishList()
	{
		GetProductIdList getProductIdList = new GetProductIdList();
		GetCustomerDetails getCustomerDetails = new GetCustomerDetails();
		GetProductDetails getProductDetails = new GetProductDetails();
	
		int customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		ArrayList<Integer> productIdList = new ArrayList<Integer>();
		productIdList = getProductIdList.getProductIdListInWishList(customerId);
		if(!productIdList.isEmpty())
		{
			System.out.println(ShoppingAppConstants.smallHyphen+"<< My WishList >>"+ShoppingAppConstants.smallHyphen+"\n");
			ListIterator<Integer> iterator = productIdList.listIterator();
			while(iterator.hasNext())
			{
				String productName = getProductDetails.getProductName(iterator.next());
				iterator.previous();
				int productPrice = getProductDetails.getProductPrice(iterator.next());
				iterator.previous();
				System.out.printf("%12s %20s %20s\n","Product Id",
						"Name",
						"Price");
				System.out.printf("%12s %20s %20d\n", iterator.next(),productName,productPrice);
				System.out.println("\n"+ShoppingAppConstants.equalLine+ShoppingAppConstants.equalLine);
			}
			System.out.println("Enter productId you want to work with:");
			System.out.println(ShoppingAppConstants.goHome);
			int productId = scanner.nextInt();
			if(productId!=0 && checkProductId.isProductIdInWishList(productId))
			{
				MyWishListDriver myWishListDrive = new MyWishListDriver();
				myWishListDrive.myWishListDriver(productId);
			}
			else if(productId==0)
			{
				customerMainDrive.customerMainDriver();
			}
			else
			{
				System.out.println(ShoppingAppConstants.invalidChoice);
				viewMyWishList();
			}
		}
		else
		{
			System.out.println("Sorry your wishlist is empty :(");
		}
}
}
