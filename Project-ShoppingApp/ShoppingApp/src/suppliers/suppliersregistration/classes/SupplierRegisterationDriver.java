package suppliers.suppliersregistration.classes;
import java.util.*;

import appconstants.ShoppingAppConstants;
import suppliers.suppliersmethods.classes.SupplierMethodsDriver;
import utilities.classes.*;

public class SupplierRegisterationDriver {
	public void supplierRegisterDriver()
	{
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		CreateSupplierAccount createSupplierAccount = new CreateSupplierAccount();
		SupplierLogin supplierLogin = new SupplierLogin();
		GetDetails getDetails = new GetDetails();
		printMenu.printSupplierRegisterationDriverMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			if(createSupplierAccount.createSupplierAccount())
			{
				System.out.println("Account Created Successfully!!");
				System.out.println("Now you Login...");
				if(supplierLogin.supplierLogin());
			}
			break;
		case 2:
			if(supplierLogin.supplierLogin())
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
		supplierRegisterDriver();
		
	}
}
