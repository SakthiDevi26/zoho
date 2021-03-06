package view.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import driver.customers.CustomerMainDriver;
import sql.DatabaseConnection;

public class ViewCustomerAccount {
	
	String sql="",sql1="";
	Connection connect = DatabaseConnection.getConnection();
	
	public int customerId;
	public long customerPhoneNumber;
	public String customerName,customerAddress;
	
	public void viewCustomerAccount() {
		
		Scanner scanner = new Scanner(System.in);
		CustomerMainDriver customerMainDrive = new CustomerMainDriver();
		CustomerDetailsGettable getCustomerDetails = new GetCustomerDetails();
		
		customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		customerName = getCustomerDetails.getCustomer(customerId,ShoppingAppConstants.customersTable);
		customerPhoneNumber = getCustomerDetails.getCustomerPhoneNumber(customerId);
		customerAddress = getCustomerDetails.getCustomer(customerId, ShoppingAppConstants.customerAddressColumn);
			
		
		System.out.println(ShoppingAppConstants.equalLine+"\n\n");
		System.out.println("\t\t"+ShoppingAppConstants.smallHyphen+"MY PROFILE"+ShoppingAppConstants.smallHyphen);
		System.out.printf("\n%s %25s\n","\t\tName","\t\tPhone Number");
		System.out.print("\t\t"+customerName);
		System.out.println("\t\t\t"+customerPhoneNumber);
		System.out.println("\t\t"+ShoppingAppConstants.underscoreLine);
		System.out.println("\t\tDeliver My orders to");
		System.out.println("\t\t"+customerAddress);
		System.out.println("\n"+ShoppingAppConstants.equalLine);
		System.out.println("Press 0 to go to main");
		
		int userInput = scanner.nextInt();
		if(userInput==0) {
			
			customerMainDrive.customerMainDriver();
		}
		else {
			
			System.out.println("Sorry.Invalid Input. Terminating...");
		}
	
	}
}
