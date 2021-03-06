package driver.customers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.customers.CreateCustomerAccount;
import databaseoperations.interfaces.customers.CustomerAccountCreatable;
import utilities.GetDetails;
import utilities.PrintMenu;

public class CustomerRegisterationDriver {
	
	public boolean customerRegisterationDriver() {
		
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		CustomerAccountCreatable createCustomerAccount = new CreateCustomerAccount();
		CustomerLogin customerLogin = new CustomerLogin();
		
		printMenu.printRegisterationDriverMenu();
		int choice = scanner.nextInt();
		switch(choice) {
		
		case 1:
			try {
				if(createCustomerAccount.createCustomerAccount()) {
					
					System.out.println("Account Created Successfully!!");
					System.out.println("Now you Login...");
					if(customerLogin.customerLogin()) {
						
						System.out.println(ShoppingAppConstants.successfulLogin);
						return true;
					}
					else {
						customerRegisterationDriver();
					}

				}
			} 
			catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 2:
			if(customerLogin.customerLogin()) {
				System.out.println(ShoppingAppConstants.successfulLogin);
				return true;
			}
			else {
				customerRegisterationDriver();
			}
			break;
		
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
			customerRegisterationDriver();
		}
		return true;	
	}
}
