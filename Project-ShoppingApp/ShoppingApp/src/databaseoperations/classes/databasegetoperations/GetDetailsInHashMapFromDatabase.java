package databaseoperations.classes.databasegetoperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.DetailsInHashMapGettable;
import sql.DatabaseConnection;

public class GetDetailsInHashMapFromDatabase implements DetailsInHashMapGettable{
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public int productId;
	public String productName;

	public Map<Integer, String> getProductRecommendationDetails ()
	{
		
		Map<Integer, String> productRecommendationMap = new HashMap<>();
		
		sql ="SELECT "+ShoppingAppConstants.productIdColumn+","+ShoppingAppConstants.productNameColumn+" FROM "+
				ShoppingAppConstants.productsTable+ " ORDER BY RAND ( ) LIMIT 4";
		
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
				productName = resultset.getString(ShoppingAppConstants.productNameColumn);
				productRecommendationMap.put(productId, productName);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return productRecommendationMap;		
	}
	
	public Map<Integer, String> getProductByCategoryDetails (String productCategory)
	{
		Map<Integer, String> productByCategoryMap = new HashMap<>();
		sql = "Select * from "+ShoppingAppConstants.productsTable+" where "
				+ShoppingAppConstants.productCategoryColumn+" = '"+productCategory+"'";
		
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			
			while (resultset.next()) {
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
				productName = resultset.getString(ShoppingAppConstants.productNameColumn);
				productByCategoryMap.put(productId, productName);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productByCategoryMap;		
	}
	
	
	public Map<Integer, String> getAllProducts()
	{
		Map<Integer, String> products = new HashMap<>();
		sql = "Select * from "+ShoppingAppConstants.productsTable;
		
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				
				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
				productName = resultset.getString(ShoppingAppConstants.productNameColumn);
				products.put(productId, productName);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;		
	}
}
