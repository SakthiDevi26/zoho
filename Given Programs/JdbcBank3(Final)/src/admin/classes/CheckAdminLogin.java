package admin.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.interfaces.CheckAdminLoginInterface;
import sql.DBConnection;
import bankconstants.BankConstants;
import basics.GetDetails;

public class CheckAdminLogin implements CheckAdminLoginInterface {
	
	String sql="";
	Connection connect = DBConnection.getConnection();
	GetDetails getDetails = new GetDetails();
	CheckAdminLoginSecondChance secondChanceLogin = new CheckAdminLoginSecondChance();
	
	
	public boolean canAdminLogin(String adminUserName, String adminPassWord) {
		// TODO Auto-generated method stub
		if (adminUserName == "" || adminPassWord == "") {
			System.out.println(BankConstants.incompleteFields);
			return false;
		}
		sql = "select * from "+BankConstants.adminTable+" where "+BankConstants.adminNameColumn+"='"
				+ adminUserName + "' and "+BankConstants.adminPasswordColumn+"='" + adminPassWord+"'";
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next())
			{
				System.out.println(BankConstants.successfulLogin);	
				return true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(BankConstants.invalidLoginCredentials);
		getDetails.getAdminLoginDetails();
		if(secondChanceLogin.canAdminLogin(getDetails.adminUserName, getDetails.adminPassWord))
		{
			System.out.println(BankConstants.successfulLogin);
			return true;
		}
		return false;
	}
}
