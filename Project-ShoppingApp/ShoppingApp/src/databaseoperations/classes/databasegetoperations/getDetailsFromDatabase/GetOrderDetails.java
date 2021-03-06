package databaseoperations.classes.databasegetoperations.getDetailsFromDatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.OrderDetailsGettable;
import sql.DatabaseConnection;

public class GetOrderDetails implements OrderDetailsGettable {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int supplierId,currentCustomerId,productPrice,orderId,productId,customerId;
	public long customerPhoneNumber,supplierPhoneNumber;
	public String productName,productCategory,customerAddress,customerName,deliveryStatus,deliveryDateString,supplierName,productDescription;
	Date deliveryDate;
	
	/**
	 * @param productId
	 */
	public int getOrderId(int productId) {
		
		sql ="Select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.productIdColumn+" = "
				+productId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				
				orderId = resultset.getInt(ShoppingAppConstants.orderIdColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderId;
	}

	/**
	 * @param orderId
	 */
	public String getDeliveryStatus(int orderId) {
		
		sql ="Select * from "+ShoppingAppConstants.shipmentTable+" where "+ShoppingAppConstants.orderIdColumn+" = "
				+orderId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				
				deliveryStatus = resultset.getString(ShoppingAppConstants.deliveryStatusColumn);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deliveryStatus;
	}
	/**
	 * @param orderId
	 */
	public String getDeliveryDate(int orderId) {
		
		sql ="Select * from "+ShoppingAppConstants.shipmentTable+" where "+ShoppingAppConstants.orderIdColumn+" = "
				+orderId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				
				deliveryDate = resultset.getDate(ShoppingAppConstants.deliveryDateColumn);
				deliveryDateString = deliveryDate.toString();
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deliveryDateString;
	}
}
