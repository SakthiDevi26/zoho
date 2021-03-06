package driver.customers;

import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import utilities.PrintMenu;
import view.customers.ViewProductInDetail;
import view.customers.searchbycategoryview.BeautyCategory;
import view.customers.searchbycategoryview.ClothingCategory;
import view.customers.searchbycategoryview.ElectronicsCategory;
import view.customers.searchbycategoryview.GroceryCategory;
import view.customers.searchbycategoryview.JewelleryCategory;

public class SearchByCategoryDriver {
	
	int productId;
	
	public void searchByCategoryDriver() {
		Scanner scanner = new Scanner(System.in);
		PrintMenu printMenu = new PrintMenu();
		printMenu.printProductCategories();
		
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			ClothingCategory clothingCategory = new ClothingCategory();
			productId = clothingCategory.showClothingCategoryProducts();
			
			if(productId!=0) {
				ViewProductInDetail viewProduct = new ViewProductInDetail();
				viewProduct.viewProductInDetail(productId);
			}
			else {
				System.out.println(ShoppingAppConstants.invalidChoice);
			}
			break;
		
		case 2:
			JewelleryCategory jewelleryCategory = new JewelleryCategory();
			productId = jewelleryCategory.showJewelleryCategoryProducts();
			
			if(productId!=0) {
				ViewProductInDetail viewProduct = new ViewProductInDetail();
				viewProduct.viewProductInDetail(productId);
			}
			else {
				System.out.println(ShoppingAppConstants.invalidChoice);
			}
			break;
		
		case 3:
			BeautyCategory beautyCategory = new BeautyCategory();
			productId = beautyCategory.showBeautyCategoryProducts();
			if(productId!=0) {
				ViewProductInDetail viewProduct = new ViewProductInDetail();
				viewProduct.viewProductInDetail(productId);
			}
			else {
				System.out.println(ShoppingAppConstants.invalidChoice);
			}
			break;
		
		case 4:
			ElectronicsCategory electronicsCategory = new ElectronicsCategory();
			productId = electronicsCategory.showElectronicsCategoryProducts();
			if(productId!=0) {
				ViewProductInDetail viewProduct = new ViewProductInDetail();
				viewProduct.viewProductInDetail(productId);
			}
			else {
				System.out.println(ShoppingAppConstants.invalidChoice);
			}
			break;
		
		case 5:
			GroceryCategory groceryCategory = new GroceryCategory();
			productId = groceryCategory.showGroceryCategoryProducts();
			if(productId!=0) {
				ViewProductInDetail viewProduct = new ViewProductInDetail();
				viewProduct.viewProductInDetail(productId);
			}
			else {
				System.out.println(ShoppingAppConstants.invalidChoice);
			}
			break;
		
		default:
			System.out.println(ShoppingAppConstants.invalidChoice);
		}
		searchByCategoryDriver();				
	}
}
