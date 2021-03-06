package databaseoperations.classes.databasegetoperations.getlistfromdatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.CustomerIdListGettable;
import sql.DatabaseConnection;

public class GetCustomerIdList implements CustomerIdListGettable{
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int orderId,productId,customerId;
	
	
	public ArrayList<Integer> getAllCustomerId() {
		
		ArrayList<Integer> customerIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.customersTable;
		
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			while(resultset.next()) {
				customerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
				customerIdList.add(customerId);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerIdList;
	}
	
	/**
	 * @param productId
	 */
	public ArrayList<Integer> getReviewedCustomerIdList(int productId) {

		ArrayList<Integer> reviewedCustomerIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.feedbackTable+" where "+ShoppingAppConstants.productIdColumn+" = "+productId;
		
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
				
			while(resultset.next()) {
				customerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
				reviewedCustomerIdList.add(customerId);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reviewedCustomerIdList;
	}
	
}
