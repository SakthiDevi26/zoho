import java.io.*;
import java.util.*;
public class User {
	static int accountNumber;
	String userName;
	int balance;
	File file = new File("update.txt");
	static Scanner intscanner = new Scanner(System.in);
	Scanner stringscanner = new Scanner(System.in);
	//ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
	User(int accountNumber, String userName, int balance)
	{
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.balance=balance;
	}
	public String toString()
	{
		return accountNumber+"  "+userName+"  "+balance;
	}
	public static void main(String args[])
	{
		int choice = -1;
		ArrayList<User> userDetails=new ArrayList<User>();
		do {
		printMenu();
		choice = intscanner.nextInt();
		switch(choice) {
		case 1:
			
		}
		
		}while(choice!=0);
	}
	public static void printMenu()
	{
		System.out.println("----These are file operations----");
		System.out.println("1)Insert");
		System.out.println("2)Display");
		System.out.println("3)Deposit");
		System.out.println("0)Exit");
		System.out.println("Enter your choice");
	}
	public static void getDetails()
	{
		System.out.println("Enter account number");
		accountNumber = intscanner.nextInt();
		System.out.println("Enter accounT number");
		accountNumber = intscanner.nextInt();
		System.out.println("Enter accounT number");
		accountNumber = intscanner.nextInt();
		
	}
}
