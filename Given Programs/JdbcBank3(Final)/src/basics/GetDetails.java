package basics;
import java.io.Console;
import java.util.*;
import bankconstants.BankConstants;

public class GetDetails {
	public String adminUserName;
	public String adminPassWord;
	public String userName;
	public String pinNumber;
	public int accountBalance;
	public void getAdminLoginDetails()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(BankConstants.getUserName);
		adminUserName = scanner.nextLine();
		System.out.println(BankConstants.getPassword);
		adminPassWord = scanner.nextLine();
	}
	public boolean getUserCreateAccountDetails()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(BankConstants.getUserName);
		userName = scanner.nextLine();
		//pinNumber = PasswordField.readPassword("Enter pin:");
		System.out.println(BankConstants.getPassword+"(PIN):");
		//char[] pinNumberCharacters =console.readPassword();
		//pinNumber = new String(pinNumberCharacters);
		pinNumber = scanner.nextLine();
		if(pinNumber.matches("[0-9]+"))
		{
		System.out.println("Enter your "+BankConstants.startingBalance+":");
		accountBalance = scanner.nextInt();
		if(accountBalance<100)
		{
			System.out.println(BankConstants.startingBalance+" should be more than 100");
			return false;
		}
		return true;
		}
		System.out.println("Please Give Pin Number in Digits");
		return false;
		
	}
	public void getUserLoginDetails()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(BankConstants.getUserName);
		userName = scanner.nextLine();
		System.out.println(BankConstants.getPassword+"(PIN):");
		pinNumber = scanner.nextLine();
	}
	public void getDeleteUserDetails()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(BankConstants.getUserName);
		userName = scanner.nextLine();
	}
}
