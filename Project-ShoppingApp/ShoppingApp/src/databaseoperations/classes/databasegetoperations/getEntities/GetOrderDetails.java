package databaseoperations.classes.databasegetoperations.getEntities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import appconstants.ShoppingAppConstants;
import entities.Customers;
import entities.Shipment;
import sql.DatabaseConnection;

public class GetOrderDetails {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	
	public ArrayList<Shipment> getOrderDetails(int orderId)
	{
		
		ArrayList<Shipment>orderDetails = new ArrayList<Shipment>();
		 sql ="Select * from "+ShoppingAppConstants.shipmentTable +" where "+ ShoppingAppConstants.orderIdColumn +" = "+orderId;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				
				while(resultset.next()) {
					String deliveryStatus = resultset.getString(ShoppingAppConstants.deliveryStatusColumn);
					java.sql.Date deliveryDate = resultset.getDate(ShoppingAppConstants.deliveryDateColumn);
					Shipment shipment = new Shipment(deliveryStatus, deliveryDate);
					orderDetails.add(shipment);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return orderDetails;
		
	}
}
