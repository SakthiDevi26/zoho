package databaseoperations.classes.suppliers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.interfaces.suppliers.ProductDeletable;
import sql.DatabaseConnection;
import utilities.GetDetails;
import view.suppliers.ViewSupplierProducts;

public class DeleteProduct implements ProductDeletable{
	String sql="";
	Connection connect = DatabaseConnection.getConnection();

	public boolean deleteProduct(String supplierUserName) {
		// TODO Auto-generated method stub
		GetSupplierDetails getSupplierDetails = new GetSupplierDetails();
		GetDetails getDetails = new GetDetails();
		ViewSupplierProducts viewProduct = new ViewSupplierProducts();
		
		viewProduct.viewSupplierAllProducts(supplierUserName);
		if(getDetails.getProductIdForModification())
		{
		try {
			Statement statement = connect.createStatement();
			sql ="Delete from "+ShoppingAppConstants.productsTable+ " where "+ShoppingAppConstants.productIdColumn+" = '"+getDetails.productId +
					"' and "+ ShoppingAppConstants.supplierIdColumn + " = " + getSupplierDetails.getSupplierId(supplierUserName);
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
		else
		{
			System.out.println(ShoppingAppConstants.invalidChoice);
			if(deleteProduct(supplierUserName))
			{
				return true;
			}
		}
		return false;
	}

}
