package databaseoperations.classes.databasegetoperations.getDetailsFromDatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import sql.DatabaseConnection;

public class GetCustomerDetails implements CustomerDetailsGettable {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int supplierId,currentCustomerId,productPrice,orderId,productId,customerId;
	public long customerPhoneNumber,supplierPhoneNumber;
	public String productName,productCategory,customerAddress,customerName,deliveryStatus,deliveryDateString,supplierName,productDescription;
	Date deliveryDate;
	public String value;
	
	public int getCurrentlyLoggedInCustomerId() {
		
		sql ="Select * from "+ShoppingAppConstants.customerLoginTable;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				currentCustomerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentCustomerId;		
	}
	
	/**
	 * @param customerId
	 */
	public String getCustomer(int customerId, String columnName) {
		
		sql ="Select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+" = '"
				+customerId+"'";
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) 			{
				
				value = resultset.getString(columnName);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	
	/**
	 * @param customerId
	 */
	public long getCustomerPhoneNumber(int customerId)
	{
		sql ="Select * from "+ShoppingAppConstants.customersTable+" where "+ShoppingAppConstants.customerIdColumn+" = '"
				+customerId+"'";
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				
				customerPhoneNumber = resultset.getLong(ShoppingAppConstants.customerPhoneNumberColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerPhoneNumber;
	}

	/**
	 * @param orderId
	 */
}
