package user.classes;
import java.util.*;

import bankconstants.BankConstants;
import basics.PrintMenu;
import user.interfaces.UserRegisterationDrivable;

public class UserRegisterationDriver implements UserRegisterationDrivable{
	public void userRegister()
	{	
		UserLogin userLogin = new UserLogin();
		PrintMenu printMenu = new PrintMenu();
		printMenu.printUserMainMenu();
		Scanner scanner = new Scanner(System.in);
		try
		{
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			CreateUserAccount createAccount = new CreateUserAccount();
			if(createAccount.createUserAccount())
			{
				System.out.println("Account Created Successfully");
				System.out.println("Now you login");
				userLogin.userLoginAccount();		
			}
			else
			{
				System.out.println("Account cannot be created");
				userRegister();
			}
			break;
		case 2:
			userLogin.userLoginAccount();
			break;
		default:
			System.out.println(BankConstants.invalidChoice);
			userRegister();
		}
		}
		catch(InputMismatchException e)
		{
			System.out.println(BankConstants.invalidChoice);
			userRegister();
		}
	}
}
