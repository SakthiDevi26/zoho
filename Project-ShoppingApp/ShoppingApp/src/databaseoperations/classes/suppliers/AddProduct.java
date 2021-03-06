package databaseoperations.classes.suppliers;

import java.sql.Connection;
import java.sql.*;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.interfaces.suppliers.ProductAddable;
import sql.DatabaseConnection;
import utilities.GetDetails;

public class AddProduct implements ProductAddable{
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	public boolean addProduct(String supplierUserName) {
		GetSupplierDetails getSupplierDetails = new GetSupplierDetails();
		GetDetails getDetails = new GetDetails();
		if(getDetails.getProductDetails())
		{
		try {
			Statement statement = connect.createStatement();
			sql ="Insert into "+ShoppingAppConstants.productsTable+
					"("+ShoppingAppConstants.productNameColumn+","+ShoppingAppConstants.productCategoryColumn+","+ShoppingAppConstants.productDescriptionColumn+","
					+ ShoppingAppConstants.productPriceColumn +","+ShoppingAppConstants.supplierIdColumn+")"
					+ " values('"+ getDetails.productName +"','" + getDetails.productCategory + "','" + getDetails.productDescription 
					+"',"+getDetails.productPrice+","+getSupplierDetails.getSupplierId(supplierUserName)+")";
			if (statement.executeUpdate(sql)==1)
			{
				return true;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return false;
	}

}
