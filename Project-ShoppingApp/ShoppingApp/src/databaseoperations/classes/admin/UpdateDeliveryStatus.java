package databaseoperations.classes.admin;

import java.sql.Connection;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.admin.DeliveryStatusUpdatable;
import sql.DatabaseConnection;

public class UpdateDeliveryStatus implements DeliveryStatusUpdatable{
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	
	/**
	 * @param orderId
	 * @param orderStatus
	 */
	public boolean updateDeliveryStatus(int orderId,String orderStatus) {
	
		try {
	
			Statement statement = connect.createStatement();
			sql = "update "+ShoppingAppConstants.shipmentTable+" set "+ShoppingAppConstants.deliveryStatusColumn+"='"+orderStatus+ 
					"' where " +ShoppingAppConstants.orderIdColumn+"=" + orderId;
			if (statement.executeUpdate(sql) == 1) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
			return false;			
	}
}
