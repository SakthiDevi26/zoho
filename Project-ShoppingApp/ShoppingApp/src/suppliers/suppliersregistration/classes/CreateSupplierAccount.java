package suppliers.suppliersregistration.classes;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import appconstants.ShoppingAppConstants;
import sql.DatabaseConnection;
import utilities.classes.GetDetails;

public class CreateSupplierAccount {
	String sql="";
	Connection connect = DatabaseConnection.getConnection();

	public boolean createSupplierAccount()
	{
		GetDetails getDetails = new GetDetails();
		if(getDetails.getSupplierCreateAccountDetails())
		{
		try {
			Statement statement = connect.createStatement();
			sql ="Insert into "+ShoppingAppConstants.suppliersTable+
					"("+ShoppingAppConstants.supplierUserNameColumn+","+ShoppingAppConstants.supplierPasswordColumn+","+ShoppingAppConstants.supplierPhoneNumberColumn+")"
					+ " values('"+ getDetails.supplierUserName+"','" +getDetails.supplierPassword+ "'," + getDetails.supplierPhoneNumber +")";
			if (statement.executeUpdate(sql)==1)
			{
				//System.out.println("Savings account user added successfully!!");
				return true;
			}
		}catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Username already exists. Please try unique username.");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return false;
		
	}
}