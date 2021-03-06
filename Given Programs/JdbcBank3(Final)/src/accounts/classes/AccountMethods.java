package accounts.classes;

import java.sql.Connection;
import java.sql.SQLException;

import sql.DBConnection;

public abstract class AccountMethods {
	protected static final int NULL = 0;

	static Connection connect = DBConnection.getConnection();
	//used for savingsAccount
	static String sql = "";
	    // Abstract
	    /**
	     * Function to deposit funds into the account as long as
	     * the given criteria is satisfied
	     * 
	     * @param amount value to be deposited
	     * @param accountNumber of which account to be used
	     * @throws SQLException 
	     */
	    public abstract boolean depositMoney(int accountNumber, int amount) throws SQLException; 

	    /**
	     * Function to withdraw funds from the Account
	     *  
	     * 
	     * @param amount value to be withdrawn
	     * @param accountNumber of which account to be used
	     * @param balance in the account
	     * @throws SQLException 
	     */    
	    public abstract boolean withdrawMoney(int accountNumber,int balance, int amount) throws SQLException; 
	    /**
	     * Function to swipe funds through card from the Account
	     *  
	     * 
	     * @param amount value to be used for purchase
	     * @param accountNumber of which account to be used
	     * @param balance in the account
	     * @throws SQLException 
	     */    
	    public abstract boolean swipeTransferMoney(int accountNumber,int balance, int amount) throws SQLException;
	    /**
	     * Function to view balance
	     * 
	     * @param accountNumber of which account balance to be viewed
	     */
	    public abstract void getBalance(int accountNumber);
	    public abstract boolean transferMoney(int senderAccountNumber,int receiverAccountNumber,int amount, int accountBalance);
}
