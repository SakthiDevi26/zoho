package driver.admin;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.admin.UpdateDeliveryDate;
import databaseoperations.classes.databasecheckoperations.CheckOrderId;
import databaseoperations.interfaces.admin.DeliveryDateUpdatable;
import databaseoperations.interfaces.checkable.OrderIdCheckable;
import utilities.PrintMenu;


public class ManageOrderDetails {

	/**
	 * 
	 * @param orderId
	 */
	public void manageOrderDetails(int orderId) {
		
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		OrderIdCheckable checkOrderId = new CheckOrderId();
		
		if(!checkOrderId.isOrderInParticularStatus(orderId,ShoppingAppConstants.delivered)) {
			
			printMenu.printAdminOrdersManagementMenu();
			
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				DeliveryDateUpdatable updateDeliveryDate = new UpdateDeliveryDate();
				
				if(updateDeliveryDate.updateDeliveryDate(orderId)) {
					System.out.println(ShoppingAppConstants.successfulDateUpdate);
				}
				else {
					System.out.println(ShoppingAppConstants.failedDeliveryUpdate);
				}
				break;
			
			case 2:
				
				UpdateDeliveryStatusDriver deliveryStatusDrive = new UpdateDeliveryStatusDriver();
				deliveryStatusDrive.updateDeliveryStatusDriver(orderId);
				break;
			
			case 3:
				
				AdminMethodsDriver adminMethodsDrive = new AdminMethodsDriver();
				adminMethodsDrive.adminMethodsDriver();
				break;
			}			
		}
	}
}
