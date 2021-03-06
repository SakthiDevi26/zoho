package databaseoperations.classes.databasegetoperations.getDetailsFromDatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import sql.DatabaseConnection;

public class GetProductDetails implements ProductDetailsGettable {

	String sql = "";
	Connection connect = DatabaseConnection.getConnection();
	public int supplierId, currentCustomerId, productPrice, orderId, productId, customerId;
	public long customerPhoneNumber, supplierPhoneNumber;
	public String productName, productCategory, customerAddress, customerName, deliveryStatus, deliveryDateString,
			supplierName, productDescription;
	public String feedback, analyzedFeedback,productDetail;
	Date deliveryDate;


	public String getProductDetail(String columnName, String input)
	{
		sql = "Select * from " + ShoppingAppConstants.productsTable + " where " + columnName + " = " + input;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if (resultset.next()) {

				productDetail = resultset.getString(columnName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productDetail;
	}
	
	public int getProductId(int customerId, int orderId) {

		sql = "Select * from " + ShoppingAppConstants.ordersTable + " where " + ShoppingAppConstants.customerIdColumn
				+ " = " + customerId + " and " + ShoppingAppConstants.orderIdColumn + " = " + orderId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if (resultset.next()) {

				productId = resultset.getInt(ShoppingAppConstants.productIdColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productId;
	}

	/**
	 * @param customerId
	 */
	/*
	 * public int getProductId(int id, String tableName, String columnName) {
	 * 
	 * sql = "Select * from " + tableName + " where " + columnName + " = " + id; try
	 * { Statement statement = connect.createStatement(); ResultSet resultset =
	 * statement.executeQuery(sql); if (resultset.next()) {
	 * 
	 * productId = resultset.getInt(ShoppingAppConstants.productIdColumn); } } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return productId; }
	 */

	/**
	 * 
	 * @param productId
	 * @param customerId
	 * @return feedback
	 */
	
	public String getCustomerFeedback(int productId, int customerId) {
		sql = "Select * from " + ShoppingAppConstants.feedbackTable + " where " + ShoppingAppConstants.productIdColumn
				+ " = " + productId + " and " + ShoppingAppConstants.customerIdColumn + " = " + customerId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if (resultset.next()) {
				feedback = resultset.getString(ShoppingAppConstants.feedbackColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feedback;
	}

	/**
	 * 
	 * @param productId
	 * @param customerId
	 * @return analyzedFeedback
	 */
	public String getCustomerAnalyzedFeedback(int productId, int customerId) {
		sql = "Select * from " + ShoppingAppConstants.feedbackTable + " where " + ShoppingAppConstants.productIdColumn
				+ " = " + productId + " and " + ShoppingAppConstants.customerIdColumn + " = " + customerId;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if (resultset.next()) {
				analyzedFeedback = resultset.getString(ShoppingAppConstants.analyzedFeedbackColum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return analyzedFeedback;
	}

	// feedback retrieving - need to be added


	@Override
	public int getProductPrice(int productId) {
		// TODO Auto-generated method stub
		 sql ="Select * from "+ShoppingAppConstants.productsTable+" where "
				  +ShoppingAppConstants.productIdColumn +" = " +productId; 
		  try { 
				  Statement
			  statement = connect.createStatement(); ResultSet resultset =
			  statement.executeQuery(sql); 
			  if(resultset.next()) {
			  
				  productPrice = resultset.getInt(ShoppingAppConstants.productPriceColumn); 
			  } 
		  }
		  catch (SQLException e) { // TODO Auto-generated catch block
			  e.printStackTrace(); 
		  } 
		  	return productPrice; 
	}

	@Override
	public String getProductDetail(int productId, String columnName) {
		// TODO Auto-generated method stub
		 sql ="Select * from "+ShoppingAppConstants.productsTable+" where "
				  +ShoppingAppConstants.productIdColumn +" = " +productId; 
		  try { 
				  Statement
			  statement = connect.createStatement(); ResultSet resultset =
			  statement.executeQuery(sql); 
			  if(resultset.next()) {
			  
				  productDetail = resultset.getString(columnName); 
			  } 
		  }
		  catch (SQLException e) { // TODO Auto-generated catch block
			  e.printStackTrace(); 
		  } 
		
		return productDetail;
	}


}
