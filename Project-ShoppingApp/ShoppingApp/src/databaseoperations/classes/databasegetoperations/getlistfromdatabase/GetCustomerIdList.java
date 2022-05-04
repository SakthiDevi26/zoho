package databaseoperations.classes.databasegetoperations.getlistfromdatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;

public class GetCustomerIdList {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int orderId,productId,customerId;
	public ArrayList<Integer> getAllCustomerId() {
		// TODO Auto-generated method stub
		ArrayList<Integer> customerIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.customersTable;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
				while(resultset.next())
				{
					customerId = resultset.getInt(ShoppingAppConstants.customerIdColumn);
					customerIdList.add(customerId);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return customerIdList;
	}
	
}
