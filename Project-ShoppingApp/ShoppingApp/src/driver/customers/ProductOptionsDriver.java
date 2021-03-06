package driver.customers;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.customers.CheckCustomerLoggedIn;
import databaseoperations.classes.customers.addmethods.AddToCart;
import databaseoperations.classes.customers.addmethods.AddToWishList;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.databaseprintoperations.PrintMenuUsingDataBase;
import databaseoperations.interfaces.checkable.ProductIdCheckable;
import databaseoperations.interfaces.customers.CustomerLoggedInCheckable;
import databaseoperations.interfaces.customers.addmethods.CartAddable;
import databaseoperations.interfaces.customers.addmethods.WishListAddable;
import databaseoperations.interfaces.printable.DatabaseMenuPrintable;
import driver.orders.ShippingAddressDriver;
import view.customers.ViewMyCart;
import view.customers.ViewMyWishList;
import view.customers.ViewProductInDetail;


public class ProductOptionsDriver {

	/**
	 * 
	 * @param productId
	 */
	public void productOptionsDriver(int productId) {
		
		DatabaseMenuPrintable printMenuUsingDatabase = new PrintMenuUsingDataBase();
		CustomerLoggedInCheckable checkCustomerLoggedIn = new CheckCustomerLoggedIn();
		ProductIdCheckable checkProductId = new CheckProductId();
		ViewProductInDetail viewProduct = new ViewProductInDetail();
		CustomerRegisterationDriver customerRegisterDriver = new CustomerRegisterationDriver();
		CustomerMainDriver customerMainDriver = new CustomerMainDriver();
		Scanner scanner = new Scanner(System.in);
		
		
		printMenuUsingDatabase.printProductOptionsDriver(productId);
		
		int choice = scanner.nextInt();
		switch(choice) {
		
		case 1:
			if(checkCustomerLoggedIn.isCustomerLoggedin()) {
				
				if(!checkProductId.isProductIdInCart(productId)) {
					
					CartAddable addCart = new AddToCart();
					if(addCart.addToCart(productId)) {
						
						System.out.println(ShoppingAppConstants.productAdded);
						viewProduct.viewProductInDetail(productId);
					}
				}
				else {
					
					ViewMyCart viewCart = new ViewMyCart();
					viewCart.viewMyCart();
				}
			}
			else {
				
				if(customerRegisterDriver.customerRegisterationDriver()) {
					viewProduct.viewProductInDetail(productId);
				}
			}
			break;
		
		case 2:
			if(checkCustomerLoggedIn.isCustomerLoggedin()) {
				
				if(!checkProductId.isProductIdInWishList(productId)) {
					WishListAddable addWishlist = new AddToWishList();
					
					if(addWishlist.addToWishList(productId)) {
						System.out.println(ShoppingAppConstants.productAdded);
						viewProduct.viewProductInDetail(productId);
					}
				}
				else {
					ViewMyWishList viewWishlist = new ViewMyWishList();
					viewWishlist.viewMyWishList();
				}
			}
			else {
				if(customerRegisterDriver.customerRegisterationDriver())
				{
					viewProduct.viewProductInDetail(productId);
				}
			}
			break;
		
		case 3:
			if(checkCustomerLoggedIn.isCustomerLoggedin()) {
				ShippingAddressDriver shipAddressDrive = new ShippingAddressDriver();
				shipAddressDrive.shippingAddressDriver(productId);
			}
			else {
				if(customerRegisterDriver.customerRegisterationDriver()) {
					viewProduct.viewProductInDetail(productId);
				}
			}
			break;
		
		case 4:
			customerMainDriver.customerMainDriver();
			break;
		
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
		productOptionsDriver(productId);
	}
}
