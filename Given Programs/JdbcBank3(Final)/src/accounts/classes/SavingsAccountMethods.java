package accounts.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bankconstants.BankConstants;
public class SavingsAccountMethods extends AccountMethods{

	@Override
	public boolean depositMoney(int accountNumber, int amount) throws SQLException {
		// TODO Auto-generated method stub
		if (amount<=0) {
			System.out.println(BankConstants.invalidAmount);
			return false;
		}
		try {
			connect.setAutoCommit(false);
			sql = "select * from "+BankConstants.savingsCustomerTable+" where "+BankConstants.accountNumberColumn+"="
				+ accountNumber;
			PreparedStatement preparedstatement
				= connect.prepareStatement(sql);
			preparedstatement.executeQuery();


			Statement statement = connect.createStatement();


			sql = "update "+BankConstants.savingsCustomerTable+" set "+BankConstants.balanceColumn+"="+BankConstants.balanceColumn+"+"
				+ amount + " where "+BankConstants.accountNumberColumn+"=" + accountNumber;
			if (statement.executeUpdate(sql) == 1) {
				connect.commit();
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			connect.rollback();
		}
		// return
		return false;
	}

	@Override
	public boolean withdrawMoney(int accountNumber, int amount, int accountBalance) {
		// TODO Auto-generated method stub
		int charges=0;
		if(amount%5!=0 || amount<=0) {
			System.out.println(BankConstants.invalidAmount);
			return false;
		}
		if(amount>100)
		{
			charges = (int)(0.04*amount);
			amount = amount + charges;
			System.out.println("Charges: "+charges);
		}
		else
		{
			charges = (int)(0.02*amount);
			amount = amount + charges;
			System.out.println("Charges: "+charges);
		}
		if(amount<accountBalance)
			{
			try {
				connect.setAutoCommit(false);
				sql = "select * from "+BankConstants.savingsCustomerTable+" where "+BankConstants.accountNumberColumn+"="
					+ accountNumber;
				PreparedStatement preparedstatement
					= connect.prepareStatement(sql);
				preparedstatement.executeQuery();
	
	
				Statement statement = connect.createStatement();
				sql = "update "+BankConstants.savingsCustomerTable+" set "+BankConstants.balanceColumn+"="+BankConstants.balanceColumn+"-"+ amount + " where "+BankConstants.accountNumberColumn+"=" + accountNumber;
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
		}
		else
		{
			System.out.println(BankConstants.insufficientBalance);
		}
		// return
		return false;
	}

	@Override
	public boolean swipeTransferMoney(int accountNumber, int accountBalance, int amount) throws SQLException {
		// TODO Auto-generated method stub
		if (amount<=0) {
			System.out.println(BankConstants.invalidAmount);
			return false;
		}
		if(amount<accountBalance)
		{
		int cashBack =(int)(0.01*amount);
		System.out.println("CashBack: "+cashBack);
		amount = amount-cashBack;
		
			try {
				connect.setAutoCommit(false);
				sql = "select * from "+BankConstants.savingsCustomerTable+" where "+BankConstants.accountNumberColumn+"="
					+ accountNumber;
				PreparedStatement preparedstatement
					= connect.prepareStatement(sql);
				preparedstatement.executeQuery();
	
	
				Statement statement = connect.createStatement();
				sql = "update "+BankConstants.savingsCustomerTable+" set "+BankConstants.balanceColumn+"="+BankConstants.balanceColumn+"-"
					+ amount + " where "+BankConstants.accountNumberColumn+"=" + accountNumber;
				if (statement.executeUpdate(sql) == 1) {
					connect.commit();
					return true;
				}

			}
			catch (Exception e) {
				e.printStackTrace();
				connect.rollback();
			}
		}
		else
		{
			System.out.println(BankConstants.insufficientBalance);
		}
		return false;
	}

	@Override
	public void getBalance(int acNo) {
		// TODO Auto-generated method stub
		try {

			// query
			sql = "select * from "+BankConstants.savingsCustomerTable+" where "+BankConstants.accountNumberColumn+"="
				+ acNo;
			PreparedStatement statement
				= connect.prepareStatement(sql);

			ResultSet resultset = statement.executeQuery(sql);
			System.out.println(
				"-----------------------------------------------------------");
			System.out.printf("%12s %10s %10s\n",
							"Account No", "Name",
							"Balance");

			// Execution

			while (resultset.next()) {
				System.out.printf("%12d %10s %10d.00\n",
								resultset.getInt(BankConstants.accountNumberColumn),
								resultset.getString(BankConstants.userNameColumn),
								resultset.getInt(BankConstants.balanceColumn));
			}
			System.out.println(
				"-----------------------------------------------------------\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public boolean applyInterest(int accountNumber, int accountBalance) {
		// TODO Auto-generated method stub
		if(accountBalance>0)
		{
		int interest = (int)(0.02*accountBalance);
		System.out.println("Interest:"+interest);
			try {
				connect.setAutoCommit(false);
				sql = "select * from "+BankConstants.savingsCustomerTable+" where "+BankConstants.accountNumberColumn+"=" + accountNumber;
				PreparedStatement preparedstatement = connect.prepareStatement(sql);
				preparedstatement.executeQuery();
				Statement statement = connect.createStatement();
				sql ="update "+BankConstants.savingsCustomerTable+" set "+BankConstants.balanceColumn+"= "+(accountBalance+interest) +" where "+BankConstants.accountNumberColumn+"="+accountNumber;
					if (statement.executeUpdate(sql) == 1) {
						System.out.println("Interest Applied!");
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
		}
		return false;
	}

	@Override
	public boolean transferMoney(int senderAccountNumber, int receiverAccountNumber, int amount, int accountBalance) {
		// TODO Auto-generated method stub
		if(senderAccountNumber==receiverAccountNumber)
		{
			System.out.println("Cannot transfer between same account");
			return false;
		}
		if (amount<=0) {
			System.out.println(BankConstants.invalidAmount);
			return false;
		}
		if(amount<accountBalance) 
		{
			try {
				connect.setAutoCommit(false);
				sql = "select * from "+BankConstants.savingsCustomerTable+" where "+BankConstants.accountNumberColumn+"=" + receiverAccountNumber;
				PreparedStatement preparedstatement = connect.prepareStatement(sql);
				ResultSet resultset = preparedstatement.executeQuery();
				if(resultset.next())
				{
					Statement statement = connect.createStatement();
					sql = "update "+BankConstants.savingsCustomerTable+" set "
				+BankConstants.balanceColumn+"="+BankConstants.balanceColumn+"-"+ amount + 
				" where "+BankConstants.accountNumberColumn+"=" + senderAccountNumber;
					if(statement.executeUpdate(sql)==1)
					{
						System.out.println("Amount Debited");
					}
					Statement statement1 = connect.createStatement();
					String sql = "update "+BankConstants.savingsCustomerTable+" set "+BankConstants.balanceColumn+"="+BankConstants.balanceColumn+"+"
							+ amount + " where "+BankConstants.accountNumberColumn+"=" + receiverAccountNumber;
					statement1.executeUpdate(sql);
					connect.commit();
					return true;
				}
				else
				{
					System.out.println(BankConstants.unexistUser);
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				try {
					connect.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else
		{
			System.out.println(BankConstants.insufficientBalance);
		}
		return false;
		
	}

}
