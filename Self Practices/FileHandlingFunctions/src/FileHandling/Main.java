package FileHandling;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws FileNotFoundException
	{
		try {
		File file = new File("Registeration.txt");
			if(file.createNewFile())
			{
				System.out.println("File created successfully");
			}
		}
		catch(IOException e)
		{
			System.out.println("File cannot be created");
		}
		printMainMenu();
	}
	public static void printMainMenu() throws FileNotFoundException
	{
		Registeration user = new Registeration();
		int choice;
		Scanner scanner = new Scanner(System.in);
		System.out.println("1)Create New Account");
		System.out.println("2)Login into existing account");
		System.out.println("Enter your choice:");
		choice = scanner.nextInt();
		if(choice==1)
		{
			user.createNewAccount();
		}
		else if(choice==2)
		{
			user.loginAccount();
		}
		else{
			System.out.println("Enter valid choice");
		}
	}
}
