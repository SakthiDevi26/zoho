package databaseoperations.classes.customers.removemethods;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.interfaces.customers.removemethods.ProductFromCartRemovable;
import sql.DatabaseConnection;

public class RemoveProductFromCart implements ProductFromCartRemovable{
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	int customerId;
	
	/**
	 * @param productId
	 */
	public boolean removeProductFromCart(int productId) {
		// TODO Auto-generated method stub
		
		GetCustomerDetails getCustomerDetails = new GetCustomerDetails();
		customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		sql = "delete from "+ShoppingAppConstants.cartTable+" where "+ShoppingAppConstants.customerIdColumn+" = "+customerId +
				" and "+ShoppingAppConstants.productIdColumn+ " = "+productId;
		
		Statement statement;
		try {
			statement = connect.createStatement();
			if(statement.executeUpdate(sql)==1) {
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;				
	}
}
