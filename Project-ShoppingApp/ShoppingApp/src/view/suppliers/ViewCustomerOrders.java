package view.suppliers;

import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckOrderId;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetOrderDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetCustomerEntityDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetProductIdList;
import databaseoperations.interfaces.checkable.OrderIdCheckable;
import databaseoperations.interfaces.gettable.OrderDetailsGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import databaseoperations.interfaces.gettable.ProductIdListGettable;
import databaseoperations.interfaces.gettable.SupplierDetailsGettable;
import driver.suppliers.SupplierMethodsDriver;
import entities.Customers;
import utilities.GetDetails;


public class ViewCustomerOrders {
	
	ArrayList<Integer> ordersProductIdList = new ArrayList<Integer>();
	
	/**
	 * 
	 * @param supplierUserName
	 */
	public void viewCustomerOrders(String supplierUserName) {
			
		//objects
		GetCustomerEntityDetails getCustomer = new GetCustomerEntityDetails();
		SupplierMethodsDriver supplierMethodsDrive = new SupplierMethodsDriver();
		GetDetails getDetails = new GetDetails();
		ProductIdListGettable getProductIdList = new GetProductIdList();
		SupplierDetailsGettable getSupplierDetails = new GetSupplierDetails();
		OrderDetailsGettable getOrderDetails = new GetOrderDetails();
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		OrderIdCheckable checkOrderId = new CheckOrderId();
		
		int supplierId = getSupplierDetails.getSupplierId(supplierUserName); 
		ArrayList<Integer> supplierProductIdList = new ArrayList<Integer>();
		supplierProductIdList = getProductIdList.getSupplierProductIdList(supplierId); 
		
		if(!supplierProductIdList.isEmpty()) {
			ListIterator<Integer> supplierProductIdIterator = supplierProductIdList.listIterator();
			
			while(supplierProductIdIterator.hasNext()) {
				ordersProductIdList = getProductIdList.getOrdersProductIdList(supplierProductIdIterator.next());
			}

			if(!ordersProductIdList.isEmpty())
			{
				System.out.println(ShoppingAppConstants.equalLine+"\n");
				System.out.println("\t\t\t\tMy PRODUCT ORDERS");
				System.out.println(ShoppingAppConstants.equalLine+"\n");
				System.out.printf("%30s %20s\n","Order Id",
						"Product Name");
				System.out.println("\t\t"+ShoppingAppConstants.underscoreLine);
		
				
				ListIterator<Integer> ordersProductIdIterator = ordersProductIdList.listIterator();			
				while(ordersProductIdIterator.hasNext()) {
					int orderId = getOrderDetails.getOrderId(ordersProductIdIterator.next());
					ordersProductIdIterator.previous();
					
					String productName = getProductDetails.getProductDetail(ordersProductIdIterator.next(),ShoppingAppConstants.productIdColumn);
					System.out.printf("%30s %20s\n", orderId,productName);
				}
				System.out.println("\n"+ShoppingAppConstants.equalLine);
				
				getDetails.getOrderId();
				if(getDetails.orderId!=0 && checkOrderId.isOrderIdInOrdersTable(getDetails.orderId)) {
					ViewCustomerDetails viewCustomer = new ViewCustomerDetails();
					viewCustomer.viewCustomerDetails(getDetails.orderId);
				}
				else if(getDetails.orderId==0) {
					supplierMethodsDrive.supplierMethodsDriver(supplierUserName);
				}
				else {
					System.out.println(ShoppingAppConstants.invalidChoice);
					viewCustomerOrders(supplierUserName);
				}
					
			}
			else {
				System.out.println("You haven't received any orders :(\n");
				supplierMethodsDrive.supplierMethodsDriver(supplierUserName);
			}
		}
		else {
			System.out.println("You have no Products\n");
			supplierMethodsDrive.supplierMethodsDriver(supplierUserName);
		}
	}
}

