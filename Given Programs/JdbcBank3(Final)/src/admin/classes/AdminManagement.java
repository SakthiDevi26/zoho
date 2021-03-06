package admin.classes;

import java.util.*;

import admin.interfaces.AdminManageable;
import adminfunctions.*;

import basics.Main;
import basics.PrintMenu;
import 	bankconstants.BankConstants;
public class AdminManagement implements AdminManageable {
	public void adminOperations() {
		
		PrintMenu printMenu = new PrintMenu();
		Scanner scanner = new Scanner(System.in);
		
		printMenu.printAdminMenu();
		try
		{
		int choice;
		choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			ViewUsers viewUser = new ViewUsers();
			viewUser.viewAllUsers();
			break;
		case 2:
			AddUsers addUser = new AddUsers();
			if(addUser.addUsers())
			{
				System.out.println("User added successfully");
			}
			else
			{
				System.out.println("User cannot be added. Sorry");
			}
			break;
		case 3:
			DeleteUsers deleteUser = new DeleteUsers();
			if(deleteUser.deleteUsers())
			{
				System.out.println("User deleted successfully");
			}
			else
			{
				System.out.println("User cannot be deleted. Sorry");
			}
			break;
		case 4:
			System.out.println(BankConstants.successfulLogout);
			Main.main(null);
			break;
		default:
			System.out.println(BankConstants.invalidChoice);
		}

		adminOperations();
		}
		catch(InputMismatchException e)
		{
			System.out.println(BankConstants.invalidChoice);
			adminOperations();
		}
	}
}
