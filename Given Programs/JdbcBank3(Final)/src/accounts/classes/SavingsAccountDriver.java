package accounts.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import accounts.interfaces.*;
import sql.DBConnection;
import basics.Main;
import basics.PrintMenu;
import bankconstants.BankConstants;

public class SavingsAccountDriver implements SavingsAccountDrivable{


	SavingsAccountMethods savingAccountMethods = new SavingsAccountMethods();
	Connection connect = DBConnection.getConnection();
	String sql = "";
	public int accountNumber, accountBalance, amount;
	public void SavingsAccount(String userName, String pinNumber) {
		
	sql = "select * from "+BankConstants.savingsCustomerTable+" where "+BankConstants.userNameColumn+"='"
			+ userName + "' and "+BankConstants.pinNumberColumn+"='" + pinNumber+"'";
	
	try {
		PreparedStatement statement = connect.prepareStatement(sql);
		ResultSet resultset = statement.executeQuery();
		resultset.next();
		accountNumber = resultset.getInt(BankConstants.accountNumberColumn);
		accountBalance = resultset.getInt(BankConstants.balanceColumn);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	PrintMenu printmenu = new PrintMenu();
	Scanner scanner = new Scanner(System.in);
	//int choice ;
	printmenu.printSavingsUserMenu();
	try {
	int choice = scanner.nextInt();
	switch(choice)
	{
	case 1:
		//Deposit money
		System.out.print(BankConstants.getAmount);
		amount = scanner.nextInt();
		try {
			if(savingAccountMethods.depositMoney(accountNumber, amount)) {
				System.out.println(BankConstants.successfulDeposit);
			}
			else {
				System.out.println(BankConstants.failedMessage);			
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
	case 2:
		//withdraw
		System.out.print(BankConstants.getAmount);
		amount = scanner.nextInt();
		if(savingAccountMethods.withdrawMoney(accountNumber, amount,accountBalance)) {
			System.out.println(BankConstants.successfulWithdraw);
		}
		else {
			System.out.println(BankConstants.failedMessage);	
			}
		break;
	case 3:
		//swipe
		System.out.print(BankConstants.getAmount);
		amount = scanner.nextInt();
		
		try {
			if (savingAccountMethods.swipeTransferMoney(accountNumber,accountBalance, amount)) {
				System.out.println(BankConstants.successfulTransfer);
			}
			else {
				System.out.println(BankConstants.failedMessage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
	case 4:
		//apply
		if (savingAccountMethods.applyInterest(accountNumber,accountBalance))
		{
			System.out.println("Applied Interest Successfully!");
		}
		else {
			System.out.println(BankConstants.failedMessage);
		}
		break;
	case 5:
		savingAccountMethods.getBalance(accountNumber);
		break;
	case 6:
		int senderAccountNumber = accountNumber;
		System.out.println("Enter Receiver Account Number:");
		int receiverAccountNumber = scanner.nextInt();
		System.out.print(BankConstants.getAmount);
		amount = scanner.nextInt();
		if(savingAccountMethods.transferMoney(senderAccountNumber, receiverAccountNumber, amount, accountBalance))
		{
			System.out.println(BankConstants.successfulTransfer);
		}
		else
		{
			System.out.println(BankConstants.failedMessage);
		}
		break;
	case 7:
		System.out.println(BankConstants.thankyouMessage);
		Main.main(null);;
		break;
	default:
		System.out.println(BankConstants.invalidChoice);
		break;
	}
	SavingsAccount(userName,pinNumber);
	}
	catch(InputMismatchException e)
	{
		System.out.println(BankConstants.invalidChoice);
		SavingsAccount(userName,pinNumber);
	}
	}
}
