package main;
import utilities.classes.*;

import java.util.*;
import appconstants.ShoppingAppConstants;
import suppliers.suppliersregistration.classes.SupplierRegisterationDriver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		SupplierRegisterationDriver supplierRegisterationDriver = new SupplierRegisterationDriver();
		
		printMenu.printMainMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			//customer driver
			break;
		case 2:
			supplierRegisterationDriver.supplierRegisterDriver();
			break;
		case 3:
			//shipping clerk
			break;
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
			Main.main(args);
		}
	}

}
