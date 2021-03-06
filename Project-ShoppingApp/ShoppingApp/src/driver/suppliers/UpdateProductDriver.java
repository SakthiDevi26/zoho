package driver.suppliers;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.suppliers.updateproductdetails.UpdateProductCategory;
import databaseoperations.classes.suppliers.updateproductdetails.UpdateProductDescription;
import databaseoperations.classes.suppliers.updateproductdetails.UpdateProductName;
import databaseoperations.classes.suppliers.updateproductdetails.UpdateProductPrice;
import databaseoperations.interfaces.suppliers.updateproduct.ProductCategoryUpdatable;
import databaseoperations.interfaces.suppliers.updateproduct.ProductDescriptionUpdatable;
import databaseoperations.interfaces.suppliers.updateproduct.ProductNameUpdatable;
import databaseoperations.interfaces.suppliers.updateproduct.ProductPriceUpdatable;
import utilities.*;
import view.suppliers.ViewSupplierProducts;

public class UpdateProductDriver {
	
	/**
	 * 
	 * @param supplierUserName
	 */
	public void updateProductDriver(String supplierUserName) {
		
		Scanner scanner = new Scanner(System.in);
		ViewSupplierProducts viewProducts = new ViewSupplierProducts();
		PrintMenu printMenu = new PrintMenu();
		GetDetails getDetails = new GetDetails();
		
		viewProducts.viewSupplierAllProducts(supplierUserName);
		if(getDetails.getProductIdForModification()) {
			printMenu.printUpdateProductDriverMenu();
			int choice = scanner.nextInt();
			switch(choice)
			{
				case 1:
					ProductNameUpdatable updateProductName = new UpdateProductName();
					if(updateProductName.updateProductName(getDetails.productId)) {
						
						System.out.println(ShoppingAppConstants.successfulUpdate);
					}
					else {
						
						System.out.println(ShoppingAppConstants.failedUpdate);
					}
					break;
				case 2:
					ProductCategoryUpdatable updateProductCategory = new UpdateProductCategory();
					if(updateProductCategory.updateProductCategory(getDetails.productId)) {
						
						System.out.println(ShoppingAppConstants.successfulUpdate);
					}
					else {
						
						System.out.println(ShoppingAppConstants.failedUpdate);
					}
					break;
				case 3:
					ProductDescriptionUpdatable updateProductDescription = new UpdateProductDescription();
					if(updateProductDescription.updateProductDescription(getDetails.productId)) {
						
						System.out.println(ShoppingAppConstants.successfulUpdate);
					}
					else {
						
						System.out.println(ShoppingAppConstants.failedUpdate);
					}
					break;
				case 4:
					ProductPriceUpdatable updateProductPrice = new UpdateProductPrice();
					if(updateProductPrice.updateProductPrice(getDetails.productId)) {
						
						System.out.println(ShoppingAppConstants.successfulUpdate);
					}
					else {
						
						System.out.println(ShoppingAppConstants.failedUpdate);
					}
					break;
				default:
					
					System.out.println(ShoppingAppConstants.invalidChoice);
					updateProductDriver(supplierUserName);
			}
		
		}
		else {
			
			System.out.println(ShoppingAppConstants.invalidChoice);
			updateProductDriver(supplierUserName);
		}
	}
}
