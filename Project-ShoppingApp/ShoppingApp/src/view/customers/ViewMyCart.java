package view.customers;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetProductEntityDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetProductIdList;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import databaseoperations.interfaces.gettable.ProductIdListGettable;
import driver.customers.CustomerMainDriver;
import driver.customers.MyCartDriver;
import entities.Products;

public class ViewMyCart {
	CustomerMainDriver customerMainDrive = new CustomerMainDriver();
	CheckProductId checkProductId = new CheckProductId();
	Scanner scanner = new Scanner(System.in);
	public void viewMyCart() {
		
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		CustomerDetailsGettable getCustomerDetails = new GetCustomerDetails();
		ProductIdListGettable getProductIdList = new GetProductIdList();
		
		int customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		
		ArrayList<Integer> productIdList = new ArrayList<Integer>();
		productIdList = getProductIdList.getProductIdListInCart(customerId);
		if(!productIdList.isEmpty()) {
			
			System.out.println(ShoppingAppConstants.smallHyphen+"<< My Cart >>"+ShoppingAppConstants.smallHyphen+"\n");
			
			ListIterator<Integer> iterator = productIdList.listIterator();
			while(iterator.hasNext()) { 
				GetProductEntityDetails getProduct = new GetProductEntityDetails();
				ArrayList<Products> productList = new ArrayList<Products>();
				productList = getProduct.getProductList(iterator.next());
				iterator.previous();
				for(Products product : productList)
				{
				System.out.printf("%12s %20s %20s\n","Product Id",
						"Name",
						"Price");
				System.out.printf("%12s %20s %20d\n", iterator.next(),product.productName,product.getProductPrice());
				}
				System.out.println("\n"+ShoppingAppConstants.equalLine+ShoppingAppConstants.equalLine);
			}
			System.out.println("Enter productId you want to work with:");
			System.out.println(ShoppingAppConstants.goHome);
			
			int productId = scanner.nextInt();
			if(productId!=0 && checkProductId.isProductIdInCart(productId)) {
				
				MyCartDriver myCartDrive = new MyCartDriver();
				myCartDrive.myCartDriver(productId);
			}
			else if(productId==0) {
				
				customerMainDrive.customerMainDriver();
			}
			else {
				
				System.out.println(ShoppingAppConstants.invalidChoice);
				viewMyCart();
			}
		}
		else {
			
			System.out.println("Sorry your cart is empty :(");
		}
	}
	
}
