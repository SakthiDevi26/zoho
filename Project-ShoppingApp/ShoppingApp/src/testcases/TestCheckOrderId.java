package testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;

class TestCheckOrderId {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	
	@Test
	void testIsOrderIdInOrdersTable() {
		
		int orderId = 2;
		boolean answer = true;
		boolean testValue;
		sql = "select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.orderIdColumn+"="
				+ orderId;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			testValue = resultset.next();
			assertEquals(answer,testValue);
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Test
	void testIsOrderIdInShipmentTable() {
		
		int orderId = 1;
		boolean answer = true;
		boolean testValue;
		sql = "select * from "+ShoppingAppConstants.shipmentTable+" where "+ShoppingAppConstants.orderIdColumn+"="
				+ orderId;
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			testValue=resultset.next();
			assertEquals(answer,testValue);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
