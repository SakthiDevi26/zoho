package utilities.classes;
import java.util.*;
import appconstants.ShoppingAppConstants;
import suppliers.suppliersregistration.classes.CreateSupplierAccount;

public class GetDetails {
	public String supplierUserName;
	public String supplierPassword;
	public long supplierPhoneNumber;
	public String productName;
	public String productCategory;
	public String productDescription;
	public int productPrice;
	
	
	Scanner scanner = new Scanner(System.in);
	CreateSupplierAccount createSupplierAccount = new CreateSupplierAccount();
	public boolean getSupplierCreateAccountDetails()
	{
		System.out.println(ShoppingAppConstants.enterUserName);
		supplierUserName = scanner.nextLine();
		if(supplierUserName.matches("[a-zA-Z]+"))
		{
			System.out.println(ShoppingAppConstants.enterPassword);
			supplierPassword = scanner.nextLine();
			System.out.println(ShoppingAppConstants.enterPhoneNumber);
			try {
			supplierPhoneNumber = scanner.nextLong();
			String supplierPhoneNumberString =Long.toString(supplierPhoneNumber);
			int phoneNumberLength = supplierPhoneNumberString.length();
			if(phoneNumberLength!=10)
			{
				System.out.println("Invalid PhoneNumber.Please enter 10 digits number.");
				return false;
			}
			else
			{
				return true;
			}
			}
			catch(InputMismatchException e)
			{
				System.out.println(ShoppingAppConstants.enterOnlyNumbers);
				return false;
			}
		}
		else {
			System.out.println("UserName cannot contain digits.Please enter valid UserName..");
			return false;
		}
	}
	public void getSupplierLoginDetails()
	{
		System.out.println(ShoppingAppConstants.enterUserName);
		supplierUserName = scanner.nextLine();
		System.out.println(ShoppingAppConstants.enterPassword);
		supplierPassword = scanner.nextLine();
	}
	public void getProductDetails()
	{
		System.out.println("Enter Product Name:");
		productName = scanner.nextLine();
		System.out.println("Enter Product Category:");
		productCategory = scanner.nextLine();
		System.out.println("Enter Product Description:");
		productDescription = scanner.nextLine();
		System.out.println("Enter Product Price:");
		productPrice = scanner.nextInt();
	}
}