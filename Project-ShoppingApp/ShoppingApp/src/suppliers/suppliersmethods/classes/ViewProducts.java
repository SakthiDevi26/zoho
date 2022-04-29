package suppliers.suppliersmethods.classes;

import java.sql.Connection;
import java.sql.*;

import sql.DatabaseConnection;
import utilities.classes.GetDetailsFromDatabase;
import appconstants.ShoppingAppConstants;

public class ViewProducts {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	//String productDescription ="";
	public void viewAllProducts(String supplierUserName) {
		// TODO Auto-generated method stub
		GetDetailsFromDatabase getDetailsFromDb = new GetDetailsFromDatabase();
		int supplierId =getDetailsFromDb.getSupplierId(supplierUserName);
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery("Select * from "+ShoppingAppConstants.productsTable+" where "
			+ShoppingAppConstants.supplierIdColumn+" = "+ supplierId);
			System.out.println("----------------------<< My Products >>----------------------");
			while (resultset.next())
			{
				String productName = resultset.getString(ShoppingAppConstants.productNameColumn);
				String productCategory = resultset.getString(ShoppingAppConstants.productCategoryColumn);
				String productDescription = resultset.getString(ShoppingAppConstants.productDescriptionColumn);
				int productPrice = resultset.getInt(ShoppingAppConstants.productPriceColumn);
				System.out.printf("%12s %12s %12s\n",
						"Product Name",
						"Product Category","Product Price");
				System.out.printf("%12s %12s %12d\n\n",productName,productCategory,productPrice);
				System.out.printf("%12s\n","Product Description:");
				System.out.printf("%12s\n\n",productDescription);
				System.out.println(ShoppingAppConstants.line+ShoppingAppConstants.line);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}