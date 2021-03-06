package view.customers;

import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckOrderId;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetOrderIdList;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetProductIdList;
import databaseoperations.interfaces.checkable.OrderIdCheckable;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.OrderIdListGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import driver.customers.CustomerMainDriver;
import driver.orders.CustomerOrderDetailsDriver;
import sql.DatabaseConnection;
import utilities.GetDetails;


public class ViewMyOrders {
	
	public void viewMyOrders() {
		
		GetDetails getDetails = new GetDetails();
		OrderIdListGettable getOrderIdList = new GetOrderIdList();
		CustomerDetailsGettable getCustomerDetails = new GetCustomerDetails();
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		OrderIdCheckable checkOrderId = new CheckOrderId();
		
		int customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		ArrayList<Integer> orderIdList = new ArrayList<Integer>();
		orderIdList = getOrderIdList.getOrderIdList(customerId);
		
		if(!orderIdList.isEmpty()) {
			
			System.out.println(ShoppingAppConstants.equalLine+"\n");
			System.out.println("\t\t\t\tMy ORDERS");
			System.out.println(ShoppingAppConstants.equalLine+"\n");
			System.out.printf("%30s %20s\n","Order Id",
					"Product Name");
			System.out.println("\t\t"+ShoppingAppConstants.underscoreLine);
	
			ListIterator<Integer> iterator = orderIdList.listIterator();
			while(iterator.hasNext())
			{
				int productId = getProductDetails.getProductId(customerId,iterator.next());
				iterator.previous();
				String productName = getProductDetails.getProductDetail(productId,ShoppingAppConstants.productIdColumn);
				System.out.printf("%30s %20s\n", iterator.next(),productName);
			}
			System.out.println("\n"+ShoppingAppConstants.equalLine);
			
			getDetails.getOrderId();
			if(getDetails.orderId!=0 && checkOrderId.isOrderIdInOrdersTable(getDetails.orderId)) {
				CustomerOrderDetailsDriver orderDetailsDrive = new CustomerOrderDetailsDriver();
				orderDetailsDrive.customerOrderDetailsDriver(getDetails.orderId);
			}
			else if(getDetails.orderId==0) {
				CustomerMainDriver customerMainDrive = new CustomerMainDriver();
				customerMainDrive.customerMainDriver();
			}
			else {
				System.out.println(ShoppingAppConstants.invalidChoice);
				viewMyOrders();
			}
		
		}
	}
}
