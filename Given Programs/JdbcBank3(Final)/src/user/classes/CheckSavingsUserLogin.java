package user.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bankconstants.BankConstants;
import basics.GetDetails;
import sql.DBConnection;
import user.interfaces.CheckSavingsUserLoginInterface;

public class CheckSavingsUserLogin implements CheckSavingsUserLoginInterface{
	String sql="";
	Connection connect = DBConnection.getConnection();
	GetDetails getDetails = new GetDetails();
	public boolean canSavingsUserLogin(String userName, String pinNumber)
	{
		if (userName == "" || pinNumber == "") {
			System.out.println(BankConstants.incompleteFields);
			return false;
		}
		sql = "select * from "+BankConstants.savingsCustomerTable+" where "+BankConstants.userNameColumn+"='"
				+ userName + "' and "+BankConstants.pinNumberColumn+"='" + pinNumber+"'";
			try {
				PreparedStatement statement = connect.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery();
				if(resultset.next())
				{
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(BankConstants.invalidLoginCredentials);	
		return false;
	}
}
