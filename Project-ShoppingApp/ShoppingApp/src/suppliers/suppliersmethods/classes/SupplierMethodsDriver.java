package suppliers.suppliersmethods.classes;

import java.util.*;

import main.Main;
import suppliers.suppliersregistration.classes.SupplierRegisterationDriver;
import utilities.classes.PrintMenu;

public class SupplierMethodsDriver {

	public void supplierMethodsDriver(String supplierUserName) {

		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		printMenu.printSupplierMethodsMenu();
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			ViewProducts viewProduct = new ViewProducts();
			viewProduct.viewAllProducts(supplierUserName);
			break;
		case 2:
			AddProduct addProduct = new AddProduct();
			if(addProduct.addProduct(supplierUserName))
			{
				System.out.println("Product Added Successfully");
			}
			else
			{
				System.out.println("Product Cannot be Added. Sorry :(");
			}
			break;
		case 3:
			DeleteProduct deleteProduct = new DeleteProduct();
			if(deleteProduct.deleteProduct(supplierUserName))
			{
				System.out.println("Product Deleted Successfully");
			}
			else
			{
				System.out.println("Product Cannot be Deleted. Sorry :(");
			}
			break;
		case 4:
			UpdateProductDriver updateProductDriver = new UpdateProductDriver();
			updateProductDriver.updateProductDriver(supplierUserName);
			break;
		case 5:
			ViewSupplierOrders viewSupplierOrders = new ViewSupplierOrders();
			viewSupplierOrders.viewSupplierOrders(supplierUserName);
			break;
		case 6:
		case 7:
			System.out.println("Thank you! Logged out successfully!!\n");
			Main.main(null);
			break;
		default:
		}
		supplierMethodsDriver(supplierUserName);
	}

}
