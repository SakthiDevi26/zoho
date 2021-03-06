package basics;

import bankconstants.BankConstants;

public class PrintMenu {
	
	public void printMainMenu()
	{
		System.out.println(BankConstants.hyphen+"Welcome To Bank"+BankConstants.hyphen);
		System.out.println("Are you?");
		System.out.println(BankConstants.one+BankConstants.admin);
		System.out.println(BankConstants.two+BankConstants.user);
		System.out.println(BankConstants.three+"I want to Exit");
		System.out.println(BankConstants.enterChoice);
	}
	public void printAdminMenu()
	{
		System.out.println("\n"+BankConstants.hello+BankConstants.admin+"!");
		System.out.println(BankConstants.quoteLine);
		System.out.println(BankConstants.body);
		System.out.println(BankConstants.one+"View Users");
		System.out.println(BankConstants.two+"Add "+BankConstants.user);
		System.out.println(BankConstants.three+"Delete "+BankConstants.user);
		System.out.println(BankConstants.four+BankConstants.logout);
		System.out.println(BankConstants.enterChoice);
	}
	public void printUserMainMenu()
	{
		System.out.println("\n"+BankConstants.hello+" "+BankConstants.user+"!");
		System.out.println(BankConstants.one+"Create a new "+BankConstants.user+BankConstants.account);
		System.out.println(BankConstants.two+"Login into Existing "+BankConstants.user+BankConstants.account);
		System.out.println(BankConstants.enterChoice);
	}
	public void printAccountTypeMenu()
	{
		System.out.println(BankConstants.hyphen+BankConstants.account+" Type"+BankConstants.hyphen);
		System.out.println(BankConstants.one+BankConstants.savingsAccount);
		System.out.println(BankConstants.two+BankConstants.checkingAccount);
		System.out.println("Enter "+BankConstants.account+" Type");
	}
	public void printSavingsUserMenu()
	{
		System.out.println("Hello "+BankConstants.savingsAccount+" User"+"!");
		System.out.println(BankConstants.quoteLine);
		System.out.println(BankConstants.body);
		System.out.println(BankConstants.one+BankConstants.depositMoney);
		System.out.println(BankConstants.two+BankConstants.withdrawMoney);
		System.out.println(BankConstants.three+BankConstants.swipeCardTransfer);
		System.out.println(BankConstants.four+"Apply Interest");
		System.out.println(BankConstants.five+BankConstants.viewBalance);
		System.out.println(BankConstants.six+BankConstants.transferToFriend);
		System.out.println(BankConstants.seven+BankConstants.logout);
		System.out.println(BankConstants.enterChoice);
	}
	public void printCheckingUserMenu()
	{
		System.out.println("Hello "+BankConstants.checkingAccount+" User"+"!");
		System.out.println(BankConstants.quoteLine);
		System.out.println(BankConstants.body);
		System.out.println(BankConstants.one+BankConstants.depositMoney);
		System.out.println(BankConstants.two+BankConstants.withdrawMoney);
		System.out.println(BankConstants.three+BankConstants.swipeCardTransfer);
		System.out.println(BankConstants.four+BankConstants.viewBalance);
		System.out.println(BankConstants.five+BankConstants.transferToFriend);
		System.out.println(BankConstants.six+BankConstants.logout);
		System.out.println(BankConstants.enterChoice);
	}

}
