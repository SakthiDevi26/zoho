package databaseoperations.classes.databasegetoperations.getEntities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import entities.Products;
import sql.DatabaseConnection;

public class GetProductEntityDetails {

	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public ArrayList<Products> getProductList()
	{
		ArrayList<Products> productList = new ArrayList<Products>();
		
		 sql ="Select * from "+ShoppingAppConstants.productsTable ;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				
				while(resultset.next()) {
						
					int productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
					String productName = resultset.getString(ShoppingAppConstants.productNameColumn);
					String productCategory = resultset.getString(ShoppingAppConstants.productCategoryColumn);
					String productDescription = resultset.getString(ShoppingAppConstants.productDescriptionColumn);
					int productPrice = resultset.getInt(ShoppingAppConstants.productPriceColumn);
					
					Products product = new Products(productId, productName, productCategory, productDescription, productPrice);
					productList.add(product);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return productList;
	}
	public ArrayList<Products> getProductList( int productId)
	{
		ArrayList<Products> productList = new ArrayList<Products>();
		
		 sql ="Select * from "+ShoppingAppConstants.productsTable+" where "+ ShoppingAppConstants.productIdColumn +" = "+productId;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				
				while(resultset.next()) {
						
					String productName = resultset.getString(ShoppingAppConstants.productNameColumn);
					String productCategory = resultset.getString(ShoppingAppConstants.productCategoryColumn);
					String productDescription = resultset.getString(ShoppingAppConstants.productDescriptionColumn);
					int productPrice = resultset.getInt(ShoppingAppConstants.productPriceColumn);
					
					Products product = new Products(productId, productName, productCategory, productDescription, productPrice);
					productList.add(product);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return productList;
		
	}
}
