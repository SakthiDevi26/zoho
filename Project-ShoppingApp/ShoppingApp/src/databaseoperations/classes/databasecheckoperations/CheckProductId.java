package databaseoperations.classes.databasecheckoperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.interfaces.checkable.ProductIdCheckable;
import databaseoperations.interfaces.gettable.CustomerDetailsGettable;
import sql.DatabaseConnection;

public class CheckProductId implements ProductIdCheckable {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	CustomerDetailsGettable getCustomerDetails = new GetCustomerDetails();
	
	/**
	 * @param productId
	 */
	public boolean isProductIdInProductTable(int productId) {
		
		sql = "select * from "+ShoppingAppConstants.productsTable+" where "+ShoppingAppConstants.productIdColumn+"="
				+ productId;
		
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()) {	
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	
	/**
	 * @param productId
	 */
	public boolean isProductIdInCart(int productId) {
		
		int customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		
		sql = "select * from "+ShoppingAppConstants.cartTable+" where "+ShoppingAppConstants.productIdColumn+"="
				+ productId +" and "+ShoppingAppConstants.customerIdColumn+"="+ customerId;
		
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next())
			{	
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @param productId
	 */
	public boolean isProductIdInWishList(int productId) {
		
		int customerId = getCustomerDetails.getCurrentlyLoggedInCustomerId();
		
		sql = "select * from "+ShoppingAppConstants.wishlistTable+" where "+ShoppingAppConstants.productIdColumn+"="
				+ productId + " and "+ShoppingAppConstants.customerIdColumn+ " = "+customerId;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()) {	
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
