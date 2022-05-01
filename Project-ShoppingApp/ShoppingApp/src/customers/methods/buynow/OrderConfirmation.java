package customers.methods.buynow;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.registeration.classes.CustomerMainDriver;

public class OrderConfirmation {

	public void orderConfirmation(int productId) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		DisplayOrderSummary displayOrder = new DisplayOrderSummary();
		displayOrder.displayOrderSummary(productId);
		System.out.println("Do you want to place order? Type: y/n");
		String userInput = scanner.nextLine();
		if(userInput.equals("y"))
		{
			PaymentModeDriver paymentModeDriver = new PaymentModeDriver();
			paymentModeDriver.paymentModeDriver(productId);
		}
		else if(userInput.equals("n"))
		{
			System.out.println("Alas!! you missed the product.But still there are plenty...");
			CustomerMainDriver customerMainDrive = new CustomerMainDriver();
			customerMainDrive.customerMainDriver();
			
		}
		else
		{
			System.out.println(ShoppingAppConstants.invalidChoice);
			orderConfirmation(productId);
		}
	}
	//PaymentModeDriver paymentDriver = new PaymentModeDriver();
	//paymentDriver.paymentModeDriver(productId);
}
