package driver.suppliers;

import java.util.*;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.suppliers.AddProduct;
import databaseoperations.classes.suppliers.DeleteProduct;
import databaseoperations.interfaces.suppliers.ProductAddable;
import databaseoperations.interfaces.suppliers.ProductDeletable;
import main.Main;
import utilities.PrintMenu;
import view.suppliers.ViewCustomerOrders;
import view.suppliers.ViewSupplierProducts;

public class SupplierMethodsDriver {

	public void supplierMethodsDriver(String supplierUserName) {

		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		printMenu.printSupplierMethodsMenu();
		
		int choice = scanner.nextInt();
		switch(choice) {
		
		case 1:
			
			ViewSupplierProducts viewProduct = new ViewSupplierProducts();
			viewProduct.viewSupplierAllProducts(supplierUserName);
			break;
		case 2:
			
			ProductAddable addProduct = new AddProduct();
			if(addProduct.addProduct(supplierUserName)) {
				
				System.out.println("Product Added Successfully");
			}
			else {
				
				System.out.println("Product Cannot be Added. Sorry :(");
			}
			break;
		case 3:
			
			ProductDeletable deleteProduct = new DeleteProduct();
			if(deleteProduct.deleteProduct(supplierUserName)) {
				
				System.out.println("Product Deleted Successfully");
			}
			else {
				
				System.out.println("Product Cannot be Deleted. Sorry :(");
			}
			break;
		case 4:
			
			UpdateProductDriver updateProductDriver = new UpdateProductDriver();
			updateProductDriver.updateProductDriver(supplierUserName);
			break;
		case 5:
			ViewCustomerOrders viewCustomerOrders = new ViewCustomerOrders();
			viewCustomerOrders.viewCustomerOrders(supplierUserName);
			break;
		case 6:
			//feedback to be added
		case 7:
			
			System.out.println("Thank you! Logged out successfully!!\n");
			
			//exception on feedback analyzer API
			try {
				
				Main.main(null);
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
			break;
		default:
			
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
		supplierMethodsDriver(supplierUserName);
	}
}
