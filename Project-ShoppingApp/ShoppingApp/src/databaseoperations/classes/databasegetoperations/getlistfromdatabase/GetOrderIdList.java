package databaseoperations.classes.databasegetoperations.getlistfromdatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;

public class GetOrderIdList {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int orderId,productId,customerId;
	public ArrayList<Integer> getOrderIdList(int customerId)
	{
		ArrayList<Integer> orderIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.customerIdColumn+" = "
				+customerId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(!resultset.next())
			{
				System.out.println("Sorry your cart is empty :(");
			}
			else
				{
				resultset.previous();
				while(resultset.next())
				{
					orderId = resultset.getInt(ShoppingAppConstants.orderIdColumn);
					orderIdList.add(orderId);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return orderIdList;
	}
	
	

	public ArrayList<Integer> getAllOrderIdList() {
		// TODO Auto-generated method stub
		ArrayList<Integer> allOrderIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.ordersTable;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
				while(resultset.next())
				{
					orderId = resultset.getInt(ShoppingAppConstants.orderIdColumn);
					allOrderIdList.add(orderId);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allOrderIdList;
	}

}
