package admin.methods.manage;

import admin.methods.adminview.DisplayOrderDetails;
import admin.methods.adminview.ViewAllOrders;
import admin.registration.AdminMethodsDriver;
import appconstants.ShoppingAppConstants;
import utilities.classes.GetDetails;
import utilities.classes.databaseoperations.databasecheckoperations.CheckOrderId;

public class ManageOrders {

	public void manageOrders() {
		// TODO Auto-generated method stub
		CheckOrderId checkOrderId = new CheckOrderId();
		GetDetails getDetails = new GetDetails();
		DisplayOrderDetails displayOrderDetails = new DisplayOrderDetails();
		ViewAllOrders viewOrders = new ViewAllOrders();
		viewOrders.viewAllOrders();
		getDetails.getOrderId();
		if(getDetails.orderId!=0 && checkOrderId.isOrderIdInOrdersTable(getDetails.orderId))
		{
			if(checkOrderId.isOrderIdInShipmentTable(getDetails.orderId))
			{
				displayOrderDetails.displayOrderDetails(getDetails.orderId);
			}
			else
			{
				EnterOrderDetails enterOrderDetails = new EnterOrderDetails();
				if(enterOrderDetails.enterOrderDetails(getDetails.orderId))
				{
					//displayOrderDetails
				}
			}
		}
		else if(getDetails.orderId==0)
		{
			AdminMethodsDriver adminMethodsDrive = new AdminMethodsDriver();
			adminMethodsDrive.adminMethodsDriver();
		}
		else
		{
			System.out.println(ShoppingAppConstants.invalidChoice);
			manageOrders();
		}
	}

}
