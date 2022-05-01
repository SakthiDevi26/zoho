package customers.registeration.classes;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import customers.methods.SearchByCategoryDriver;
import customers.methods.ViewCustomerAccount;
import customers.methods.afterlogin.ViewMyCart;
import customers.methods.afterlogin.ViewMyWishList;
import main.Main;
import utilities.classes.PrintMenu;

public class CustomerAfterLoginDriver {
	public void customerAfterLoginDriver()
	{
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		printMenu.printAfterLoginCustomerMainMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			SearchByCategoryDriver categoryDriver = new SearchByCategoryDriver();
			categoryDriver.searchByCategoryDriver();
			break;
		case 2:
			ViewCustomerAccount viewCustomerAccount = new ViewCustomerAccount();
			viewCustomerAccount.viewCustomerAccount();
			break;
		case 3:
			//My orders
			break;
		case 4:
			ViewMyCart viewCart = new ViewMyCart();
			viewCart.viewMyCart();
			break;
		case 5:
				ViewMyWishList viewWishList = new ViewMyWishList();
				viewWishList.viewMyWishList();
			break;
		case 6:
			//feedback
			break;
		case 7:
			System.out.println(ShoppingAppConstants.thankYouMessage);
			CustomerLogout customerLogout = new CustomerLogout();
			customerLogout.customerLogout();
			Main.main(null);
			break;
		}
	}
}