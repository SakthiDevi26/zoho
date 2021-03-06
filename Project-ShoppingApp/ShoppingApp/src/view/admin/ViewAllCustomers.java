package view.admin;

import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetCustomerEntityDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetCustomerIdList;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import databaseoperations.interfaces.gettable.CustomerIdListGettable;
import entities.Customers;


public class ViewAllCustomers {

	public void viewAllCustomers() {
		
		System.out.println(ShoppingAppConstants.bigEqualLine+"\n");
		System.out.println("\t\t\t\t\tOUR CUSTOMERS");
		System.out.println("\t\t\tDon't Find Customers for products,find products for Customers\n");
		System.out.println(ShoppingAppConstants.bigEqualLine+"\n");
		System.out.printf("%s %20s %35s %40s\n","Customer Id",
				"Customer Name","Customer Address","Customer PhoneNumber");
		System.out.println(ShoppingAppConstants.bigUnderscoreLine);
		
		GetCustomerEntityDetails getCustomer = new GetCustomerEntityDetails();
		ArrayList<Customers> customerList = new ArrayList<Customers>();
		customerList = getCustomer.getCustomerList();
		for(Customers customer : customerList)
		{
			System.out.printf("%d %20s %40s %40s\n",customer.customerId,customer.customerName,customer.customerAddress,
					customer.customerPhoneNumber);
		}
			System.out.println("\n"+ShoppingAppConstants.bigEqualLine);			
	}
}
