package driver.customers;

import java.util.Scanner;

import utilities.PrintMenu;

public class CustomerBeforeLoginDriver {
	
	public void customerBeforeLoginDriver() {
		
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		CustomerMainDriver customerMainDriver = new CustomerMainDriver();
		
		printMenu.printBeforeLoginCustomerMainMenu();
		
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			SearchByCategoryDriver categoryDriver = new SearchByCategoryDriver();
			categoryDriver.searchByCategoryDriver();
			break;
		case 2:
			CustomerRegisterationDriver customerRegisterDriver = new CustomerRegisterationDriver();
			if(customerRegisterDriver.customerRegisterationDriver()) {
				customerMainDriver.customerMainDriver();
			}
			break;
		}
	}
}
