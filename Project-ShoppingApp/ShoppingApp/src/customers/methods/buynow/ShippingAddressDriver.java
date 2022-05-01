package customers.methods.buynow;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import utilities.classes.*;

public class ShippingAddressDriver {

	public void shippingAddressDriver(int productId)
	{
		Scanner scanner = new Scanner(System.in);
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		PrintMenu printMenu = new PrintMenu();
		int customerId = getDetailsFromDb.getCurrentlyLoggedInCustomerId();
		String customerAddress = getDetailsFromDb.getCustomerAddress(customerId);
		System.out.printf("%12s\n","Your Address is");
		System.out.printf("%12s\n\n", customerAddress);
		printMenu.printAddressOption();
		
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			PaymentModeDriver paymentDriver = new PaymentModeDriver();
			paymentDriver.paymentModeDriver()
			break;
		case 2:
			UpdateCustomerAddress updateCustomerAddress = new UpdateCustomerAddress();
			if(updateCustomerAddress.updateCustomerAddress())
			{
				System.out.println(ShoppingAppConstants.addressNoted);
			}
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
			
		}
		shippingAddressDriver();
		
	}
}