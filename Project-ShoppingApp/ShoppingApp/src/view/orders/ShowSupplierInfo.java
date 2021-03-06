package view.orders;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetIdUsingId;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.interfaces.gettable.IdGettable;
import databaseoperations.interfaces.gettable.SupplierDetailsGettable;
import driver.orders.ShowDeliveredOrderDetailsDriver;

public class ShowSupplierInfo {

	/**
	 * 
	 * @param orderId
	 */
	public void showSupplierInfo(int orderId) {
		
		Scanner scanner = new Scanner(System.in);
		SupplierDetailsGettable getSupplierDetails = new GetSupplierDetails();
		IdGettable getId = new GetIdUsingId();
		
		int productId = getId.getId(orderId,ShoppingAppConstants.productIdColumn,ShoppingAppConstants.ordersTable,ShoppingAppConstants.orderIdColumn);
		int supplierId = getSupplierDetails.getSupplierId(productId);
		String supplierName = getSupplierDetails.getSupplierName(supplierId);
		long supplierPhoneNumber = getSupplierDetails.getSupplierPhoneNumber(supplierId);
		
		System.out.println(ShoppingAppConstants.supplierBox);
		System.out.println("\n\t\t\t\t"+supplierName);
		System.out.println("\n\t\t\t\t"+supplierPhoneNumber);
		System.out.println("\n"+ShoppingAppConstants.equalLine);
		System.out.println(ShoppingAppConstants.goBack);
		
		int userInput = scanner.nextInt();
		if(userInput==0) {
			ShowDeliveredOrderDetailsDriver showDeliveredOrderDrive = new ShowDeliveredOrderDetailsDriver();
			showDeliveredOrderDrive.showDeliveredOrderDetailsDriver(orderId);
		}
		else {
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
	}
}
