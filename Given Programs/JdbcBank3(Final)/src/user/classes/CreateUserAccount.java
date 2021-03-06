package user.classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;
import bankconstants.BankConstants;
import basics.GetDetails;
import basics.PrintMenu;
import sql.DBConnection;
import user.interfaces.UserAccountCreatable;

public class CreateUserAccount implements UserAccountCreatable{
	String sql="";
	Connection connect = DBConnection.getConnection();
	public boolean createUserAccount() {
		PrintMenu printMenu = new PrintMenu();
		printMenu.printAccountTypeMenu();
		GetDetails getDetails = new GetDetails();
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		if(choice == 1)
		{
				if(getDetails.getUserCreateAccountDetails())
				{
				Statement statement;
				try {
					statement = connect.createStatement();
					sql ="Insert into "+BankConstants.savingsCustomerTable+
							"("+BankConstants.userNameColumn+","+BankConstants.balanceColumn+","+BankConstants.pinNumberColumn+")"
							+ " values('"+ getDetails.userName+"'," +getDetails.accountBalance+ ",'" + getDetails.pinNumber +"')";
					if (statement.executeUpdate(sql)==1)
					{
						//System.out.println("Savings account user added successfully!!");
						return true;
					}
				}catch (SQLIntegrityConstraintViolationException e) {
					System.out.println("Username Not Available!");
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				} 
			return false;
		}
		else if(choice == 2)
		{
			if(getDetails.getUserCreateAccountDetails())
			{
				Statement statement;
				try {
					statement = connect.createStatement();
					sql ="Insert into "+BankConstants.checkingCustomerTable+
							"("+BankConstants.userNameColumn+","+BankConstants.balanceColumn+","+BankConstants.pinNumberColumn+")"
							+ " values('"+ getDetails.userName+"'," +getDetails.accountBalance+ ",'" + getDetails.pinNumber +"')";
					if (statement.executeUpdate(sql)==1)
					{
						//System.out.println("Checkings account user added successfully!!");
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return false;
		}
		else
		{
			System.out.println(BankConstants.invalidChoice);
			createUserAccount();
		}
		return false;
	}
}
