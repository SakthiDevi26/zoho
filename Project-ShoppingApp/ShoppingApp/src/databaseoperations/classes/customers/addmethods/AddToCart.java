package databaseoperations.classes.customers.addmethods;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.interfaces.customers.addmethods.CartAddable;
import sql.DatabaseConnection;

public class AddToCart implements CartAddable{
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	int customerId;
	
	/**
	 * @param productId
	 */
	public boolean addToCart(int productId) {
		
		GetCustomerDetails getCustomerDetails = new GetCustomerDetails();
		customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		sql = "insert into "+ShoppingAppConstants.cartTable+" values ("+customerId+","+productId+")";
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
