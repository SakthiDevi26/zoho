package utilities.classes;

import appconstants.ShoppingAppConstants;
public class PrintMenu {
	public void printMainMenu()
	{
		System.out.println(ShoppingAppConstants.stars);
		System.out.println("\t\t->||Welcome To Shopping App||<-");
		System.out.println(ShoppingAppConstants.stars+"\n");
		System.out.println("Are You?");
		System.out.println(ShoppingAppConstants.one+"Customer");
		System.out.println(ShoppingAppConstants.two+"Supplier");
		System.out.println(ShoppingAppConstants.three+"Shipping Clerk");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	public void printSupplierRegisterationDriverMenu()
	{
		System.out.println(ShoppingAppConstants.hello+"Supplier!!");
		System.out.println(ShoppingAppConstants.one+ShoppingAppConstants.createAccount);
		System.out.println(ShoppingAppConstants.two+ShoppingAppConstants.login);
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	public void printSupplierMethodsMenu()
	{
		System.out.println(ShoppingAppConstants.hello+"Supplier!!");
		System.out.println(ShoppingAppConstants.whatWantToDo);
		System.out.println(ShoppingAppConstants.cowsayBody);
		System.out.println(ShoppingAppConstants.one+"View My Products");
		System.out.println(ShoppingAppConstants.two+"Add Product");
		System.out.println(ShoppingAppConstants.three+"Delete Product");
		System.out.println(ShoppingAppConstants.four+"Update Product");
		System.out.println(ShoppingAppConstants.five+"View Orders of My Products");
		System.out.println(ShoppingAppConstants.six+"View Customer FeedBack");
		System.out.println(ShoppingAppConstants.seven+ShoppingAppConstants.logout);
	}
	
}
