package utilities;

import appconstants.ShoppingAppConstants;
public class PrintMenu {
	
	public void printMainMenu()
	{
		System.out.println(ShoppingAppConstants.stars);
		System.out.println("\t\t\t->||Welcome To The Ethereal Emporium||<-");
		System.out.println(ShoppingAppConstants.stars);
		System.out.println("\t\t\t\t\t\t-We Deliver Your Desire!!!");
		System.out.println("Are You?");
		System.out.println(ShoppingAppConstants.one+"Customer");
		System.out.println(ShoppingAppConstants.two+"Supplier");
		System.out.println(ShoppingAppConstants.three+"Admin");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printRegisterationDriverMenu()
	{
		System.out.println(ShoppingAppConstants.hello);
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
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printUpdateProductDriverMenu()
	{
		System.out.println("What Do You Want To Update??");
		System.out.println(ShoppingAppConstants.one+"Product Name");
		System.out.println(ShoppingAppConstants.two+"Product Category");
		System.out.println(ShoppingAppConstants.three+"Product Description");
		System.out.println(ShoppingAppConstants.four+"Product Price");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printBeforeLoginCustomerMainMenu()
	{
		System.out.println(ShoppingAppConstants.one+"Search Product By Category");
		System.out.println(ShoppingAppConstants.two+"SignUp/Login");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printAfterLoginCustomerMainMenu()
	{
		System.out.println(ShoppingAppConstants.one+"Search Product By Category");
		System.out.println(ShoppingAppConstants.two+"My Account");
		System.out.println(ShoppingAppConstants.three+"My Orders");
		System.out.println(ShoppingAppConstants.four+"My Cart");
		System.out.println(ShoppingAppConstants.five+"My Wishlist");
		System.out.println(ShoppingAppConstants.six+"Give Feedback");
		System.out.println(ShoppingAppConstants.seven+"Logout");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printProductCategories()
	{
		System.out.println(ShoppingAppConstants.smallHyphen+"Our Categories"+ShoppingAppConstants.smallHyphen);
		System.out.println(ShoppingAppConstants.one+"Clothing");
		System.out.println(ShoppingAppConstants.two+"Jewellery");
		System.out.println(ShoppingAppConstants.three+"Beauty");
		System.out.println(ShoppingAppConstants.four+"Electronics");
		System.out.println(ShoppingAppConstants.five+"Grocery");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printPaymentMode()
	{
		System.out.println(ShoppingAppConstants.smallHyphen+"Mode Of Payment"+ShoppingAppConstants.smallHyphen);
		System.out.println(ShoppingAppConstants.one+"Online Payment");
		System.out.println(ShoppingAppConstants.two+"Cash On Delivery");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printAddressOption()
	{
		System.out.println("Do you want to?");
		System.out.println(ShoppingAppConstants.one+"Use same address");
		System.out.println(ShoppingAppConstants.two+"Change address");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printCartDriverMenu()
	{
		System.out.println("What do you want to do?");
		System.out.println(ShoppingAppConstants.one+"Remove Product from My Cart");
		System.out.println(ShoppingAppConstants.two+"Buy Now");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printWishListDriverMenu()
	{
		System.out.println("What do you want to do?");
		System.out.println(ShoppingAppConstants.one+"Remove Product from My WishList");
		System.out.println(ShoppingAppConstants.two+"View Product");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printAdminMethodsMenu()
	{
		System.out.println("What do you want to do?");
		System.out.println(ShoppingAppConstants.one+"View Suppliers");
		System.out.println(ShoppingAppConstants.two+"View Customers");
		System.out.println(ShoppingAppConstants.three+"Manage Orders");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printAdminOrdersManagementMenu()
	{
		System.out.println(ShoppingAppConstants.one+"Update Delivery Date");
		System.out.println(ShoppingAppConstants.two+"Update Order Status");
		System.out.println(ShoppingAppConstants.three+"Go Home");
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printUpdateDeliveryStatusMenu()
	{
		System.out.println("Update delivery status as :");
		System.out.println(ShoppingAppConstants.one+ShoppingAppConstants.processed);
		System.out.println(ShoppingAppConstants.two+ShoppingAppConstants.shipped);
		System.out.println(ShoppingAppConstants.three+ShoppingAppConstants.delivered);
		System.out.println(ShoppingAppConstants.four+ShoppingAppConstants.cancelled);
		System.out.println(ShoppingAppConstants.enterChoice);
	}
	
	public void printDeliveredOrderDetailsMenu()
	{
		System.out.println(ShoppingAppConstants.bigUnderscoreLine);
		System.out.println("NEED HELP WITH YOUR ITEM?\n");
		System.out.println(ShoppingAppConstants.one+"Contact Supplier");
		System.out.println(ShoppingAppConstants.bigUnderscoreLine);
		System.out.println("HOW'S YOUR ITEM?\n");
		System.out.println(ShoppingAppConstants.two+"Write a product review");
		System.out.println(ShoppingAppConstants.bigUnderscoreLine);
		System.out.println("ORDER INFO\n");
		System.out.println(ShoppingAppConstants.three+"View Order Info");
		System.out.println("\n"+ShoppingAppConstants.stars);
		System.out.println(ShoppingAppConstants.enterChoice);
	}	
}
