package suppliers.suppliersmethods.classes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import customers.registeration.classes.CustomerMainDriver;
import sql.DatabaseConnection;
import utilities.classes.GetDetails;
import utilities.classes.databaseoperations.databasecheckoperations.CheckOrderId;
import utilities.classes.databaseoperations.databasegetoperations.GetDetailsFromDatabase;
import utilities.classes.databaseoperations.databasegetoperations.GetListDetailsFromDatabase;

public class ViewSupplierOrders {
	ArrayList<Integer> ordersProductIdList = new ArrayList<Integer>();
	public void viewSupplierOrders(String supplierUserName) {
		GetDetails getDetails = new GetDetails();
		GetListDetailsFromDatabase getListDetailsFromDb = new GetListDetailsFromDatabase();
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		CheckOrderId checkOrderId = new CheckOrderId();
		
		int supplierId = getDetailsFromDb.getSupplierId(supplierUserName); 
		ArrayList<Integer> supplierProductIdList = new ArrayList<Integer>();
		supplierProductIdList = getListDetailsFromDb.getSupplierProductIdList(supplierId); 
		if(!supplierProductIdList.isEmpty())
		{
			ListIterator<Integer> supplierProductIdIterator = supplierProductIdList.listIterator();
			while(supplierProductIdIterator.hasNext())
			{
			
				ordersProductIdList = getListDetailsFromDb.getOrdersProductIdList(supplierProductIdIterator.next());

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
				while(ordersProductIdIterator.hasNext())
				{
					int orderId = getDetailsFromDb.getOrderId(ordersProductIdIterator.next());
					ordersProductIdIterator.previous();
					String productName = getDetailsFromDb.getProductName(ordersProductIdIterator.next());
					System.out.printf("%30s %20s\n", orderId,productName);
				}
				System.out.println("\n"+ShoppingAppConstants.equalLine);
			}
			else
			{
				System.out.println("You haven't received any orders :(");
			}
		}
		else
		{
			System.out.println("You have no Products");
		}
		getDetails.getOrderId();
		if(getDetails.orderId!=0 && checkOrderId.isOrderIdInOrdersTable(getDetails.orderId))
		{
			//ShowOrderDetails showOrderDetails = new ShowOrderDetails();
			//showOrderDetails.showOrderDetails(getDetails.orderId);
		}
		else if(getDetails.orderId==0)
		{
			CustomerMainDriver customerMainDrive = new CustomerMainDriver();
			customerMainDrive.customerMainDriver();
		}
		else
		{
			System.out.println(ShoppingAppConstants.invalidChoice);
			viewSupplierOrders(supplierUserName);
		}
			
	}
}
