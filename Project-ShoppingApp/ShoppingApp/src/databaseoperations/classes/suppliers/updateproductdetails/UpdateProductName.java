package databaseoperations.classes.suppliers.updateproductdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.suppliers.updateproduct.ProductNameUpdatable;
import sql.DatabaseConnection;
import utilities.GetDetails;

public class UpdateProductName implements ProductNameUpdatable {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public boolean updateProductName(int productId) {
		// TODO Auto-generated method stub
		GetDetails getDetails = new GetDetails();
		getDetails.getProductNameToUpdate();
		try {
			connect.setAutoCommit(false);

			Statement statement = connect.createStatement();


			sql = "update "+ShoppingAppConstants.productsTable+" set "+ShoppingAppConstants.productNameColumn+"='"+getDetails.productName+ 
					"' where " +ShoppingAppConstants.productIdColumn+"=" + productId;
			if (statement.executeUpdate(sql) == 1) {
				connect.commit();
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				connect.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// return
		return false;
	}

}
