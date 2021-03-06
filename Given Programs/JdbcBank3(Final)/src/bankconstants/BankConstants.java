package bankconstants;

public class BankConstants {

	//PrintMenu 
	public static String savingsAccount = "Savings Account";
	public static String checkingAccount = "Checking Account";
	public static String user ="User";
	public static String admin = "Admin";
	public static String enterChoice ="Enter your choice:";
	public static String one ="1)";
	public static String two ="2)";
	public static String three ="3)";
	public static String four ="4)";
	public static String five ="5)";
	public static String six ="6)";
	public static String seven ="7)";
	public static String hello ="Hello";
	public static String whatWantToDo ="What do you want to do?";
	public static String logout = "Logout";
	public static String account ="Account";
	public static String hyphen ="-----";
	public static String depositMoney ="Deposit Money";
	public static String withdrawMoney="Withdraw Money";
	public static String swipeCardTransfer ="Transfer Money Using SwipeCard";
	public static String viewBalance ="View Balance";
	public static String transferToFriend ="Transfer money to a friend";
	
	//GetDetails
	public static String getUserName ="Enter User Name:";
	public static String getPassword ="Enter Password ";
	public static String startingBalance ="Starting Balance";
	public static String getAmount ="Enter Amount:";
	
	//message
	public static String invalidChoice = "Invalid. Enter Valid Choice\n";
	public static String invalidAmount ="Amount is invalid";
	public static String successfulLogin ="LoggedIn Successfully!!\n";
	public static String successfulLogout ="LoggedOut SuccessFully!!\n";
	public static String failedLogin ="Login Failed :(";
	public static String invalidLoginCredentials ="User Name or Password is wrong or do not exists.Please enter correct credentials\n";
	public static String incompleteFields ="Sorry all fields are required.\n";
	public static String successfulWithdraw ="MSG : Amount Withdrawed Successfully!\n";
	public static String successfulDeposit ="MSG : Amount Deposited Successfully!\n";
	public static String successfulTransfer ="MSG : Amount Transferred Successfully!\n";
	public static String failedMessage ="ERR : Failed :(\n";
	public static String thankyouMessage ="Thank you. Visit Again:)\n";
	public static String insufficientBalance ="Sorry. Your Balance is insufficient";
	public static String unexistUser = "User doesn't Exist";
	
	//sql'
	public static String adminTable = "admin";
	public static String savingsCustomerTable = "savings_customer";
	public static String checkingCustomerTable = "checking_customer";
	
	public static String accountNumberColumn ="ac_no";
	public static String userNameColumn ="name";
	public static String balanceColumn ="balance";
	public static String pinNumberColumn ="pass_code";
	public static String adminNameColumn ="aname";
	public static String adminPasswordColumn ="admin_pass";
	
	//cowsay
	public static String body = " \t\t\t^__^\n" +
			" \t\t\t(oo)\\_______\n" +
			" \t\t\t(__)\\        )\\/\\\n" +
			" \t\t\t     ||----w |\n" +
			" \t\t\t     ||     ||\n";

			public static String quoteLine = "------------------------\nWhat Do You want to do?\n------------------------\n"
		  + "\t\t \\\n" +
			"\t\t   \\\n" +
			"\t\t      \\";
			 public static void run() {
				    String anim= "|/-\\";
				    int x = 0;
				    while (true) {
				      System.out.print(anim.charAt(x++ % anim.length()));
				      try { Thread.sleep(100); }
				      catch (Exception e) {};
				      System.out.print("\b\b  \b\b");
				      

				    }
				  }
}
