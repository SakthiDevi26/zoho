package adminfunctions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sql.DBConnection;
import bankconstants.BankConstants;

public class ViewUsers{
	String sql="";
	Connection connect = DBConnection.getConnection();
	public void viewAllUsers()
	{
		Statement statement;
		try {
			statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery("Select * from "+BankConstants.savingsCustomerTable);
			System.out.println("----------------Savings Account---------------");
			System.out.printf("%12s %10s %12s %12s\n",
					"Account No", "Name",
					"Balance","PinNumber");
			while (resultset.next())
			{
				int accountNumber = resultset.getInt(BankConstants.accountNumberColumn);
				String accountName = resultset.getString(BankConstants.userNameColumn);
				int balance = resultset.getInt(BankConstants.balanceColumn);
				String pinNumber= resultset.getString(BankConstants.pinNumberColumn);
				System.out.printf("%12d %10s %10d.00 %12s\n",accountNumber,accountName,balance,pinNumber);
			}
			//view checking account customer
			Statement statement1 = connect.createStatement(); 
			ResultSet resultset1 = statement1.executeQuery("Select * from "+BankConstants.checkingCustomerTable);
			System.out.println("\n----------------Checking Account---------------");
			System.out.printf("%12s %10s %12s %12s\n",
					"Account No", "Name",
					"Balance","PinNumber");
			while (resultset1.next())
			{
				int accountNumber = resultset1.getInt(BankConstants.accountNumberColumn);
				String accountName = resultset1.getString(BankConstants.userNameColumn);
				int balance = resultset1.getInt(BankConstants.balanceColumn);
				String pinNumber= resultset1.getString(BankConstants.pinNumberColumn);
				System.out.printf("%12d %10s %10d.00 %12s\n",accountNumber,accountName,balance,pinNumber);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}

