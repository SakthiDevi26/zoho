package databaseoperations.classes.databasegetoperations.getlistfromdatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.ProductIdListGettable;
import sql.DatabaseConnection;

public class GetProductIdList implements ProductIdListGettable{
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int orderId,productId,customerId;
	
	/**
	 * @param supplierId
	 */
	public ArrayList<Integer> getSupplierProductIdList(int supplierId) {
		
		ArrayList<Integer> productIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.productsTable+" where "+ShoppingAppConstants.supplierIdColumn+" = "
				+supplierId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			resultset.previous();
			while(resultset.next()) {
				
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
				productIdList.add(productId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productIdList;
	}

	/**
	 * @param productId
	 */
	public ArrayList<Integer> getOrdersProductIdList(int productId) {

		ArrayList<Integer> productIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.ordersTable+" where "+ShoppingAppConstants.productIdColumn+" = "
				+productId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			while(resultset.next()) {
				
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
				productIdList.add(productId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productIdList;
	}
	
	/**
	 * @param customerId
	 */
	public ArrayList<Integer> getProductIdListInCart(int customerId) {
		
		ArrayList<Integer> productIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.cartTable+" where "+ShoppingAppConstants.customerIdColumn+" = "
				+customerId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			while(resultset.next()) {
				
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
				productIdList.add(productId);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productIdList;
	}
	
	/**
	 * @param customerId
	 */
	public ArrayList<Integer> getProductIdListInWishList(int customerId) {
		
		ArrayList<Integer> productIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.wishlistTable+" where "+ShoppingAppConstants.customerIdColumn+" = "
				+customerId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
				while(resultset.next())
				{
					productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
					productIdList.add(productId);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productIdList;
	}
	
	public ArrayList<Integer> getAllOrderedProductIdList() {
		
		ArrayList<Integer> allOrderedProductIdList = new ArrayList<Integer>();
		sql ="Select * from "+ShoppingAppConstants.ordersTable;
		
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			while(resultset.next()) {
				
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
				allOrderedProductIdList.add(productId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allOrderedProductIdList;
	}
}
