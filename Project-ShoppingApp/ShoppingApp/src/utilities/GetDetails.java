package utilities;

import java.util.*;
import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckProductId;
import databaseoperations.classes.suppliers.CreateSupplierAccount;
import databaseoperations.interfaces.suppliers.SupplierAccountCreatable;
import entities.Products;
import passwordencryption.EncryptPassword;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class GetDetails {
	
	public String supplierUserName; 
	public String supplierPassword;
	public long supplierPhoneNumber;
	public String productName;
	public String productCategory;
	public String productDescription;
	public int productPrice;
	public int productId,orderId, supplierId;
	public String supplierHashedPassword;
	public String customerUserName;
	public String customerPassword;
	public long customerPhoneNumber;
	public String customerHashedPassword;
	public String customerAddress;
	private String adminUserName;
	private String adminPassword;
	public String deliveryStatus;
	public String deliveryDate;
	
	Scanner scanner = new Scanner(System.in);
	SupplierAccountCreatable createSupplierAccount = new CreateSupplierAccount();

	public boolean getSupplierCreateAccountDetails() throws NoSuchAlgorithmException, NoSuchProviderException {
		
		System.out.println(ShoppingAppConstants.enterUserName);
		supplierUserName = scanner.nextLine();
		
		//username must be letters
		if(supplierUserName.matches("[a-zA-Z]+")) { 
			
			System.out.println(ShoppingAppConstants.enterPassword);
			supplierPassword = scanner.nextLine();
			
			//hashing password using SHA
			supplierHashedPassword = EncryptPassword.encryptPassword(supplierPassword);
			System.out.println(ShoppingAppConstants.enterPhoneNumber);
			
			try {
				supplierPhoneNumber = scanner.nextLong();
				String supplierPhoneNumberString =Long.toString(supplierPhoneNumber);
				int phoneNumberLength = supplierPhoneNumberString.length();
				if(phoneNumberLength!=10) {
					
					System.out.println("Invalid PhoneNumber.Please enter 10 digits number.");
					return false;
				}
				else {
					
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
	
	
	public void getSupplierLoginDetails() {
		
		System.out.println(ShoppingAppConstants.enterUserName);
		supplierUserName = scanner.nextLine();
		System.out.println(ShoppingAppConstants.enterPassword);
		supplierPassword = scanner.nextLine();
	}
	
	
	public boolean getProductDetails()
	{
		System.out.println("Enter Product Name:");
		productName = scanner.nextLine();
		System.out.println("Enter Product Category:");
		productCategory = scanner.nextLine();
		System.out.println("Enter Product Description:");
		productDescription = scanner.nextLine();
		
		try {
			System.out.println("Enter Product Price:");
			productPrice = scanner.nextInt();
			Products product = new Products();
			product.setProductPrice(productPrice);
		}
		catch(InputMismatchException e) {
			
			System.out.println("Enter valid product price");
			return false;
		}
		
		//must contain atleast one alphabet letter (name cannot be only numbers)
		if(!(productName.matches(".*[a-zA-Z]+.*")&&productCategory.matches(".*[a-zA-Z]+.*")&&productDescription.matches(".*[a-zA-Z]+.*"))) {
			System.out.println("Product Name, Category and description must contain atleast one alphabet");
			return false;
		}
		return true;		
	}
	
	
	public boolean getProductIdForModification() {
		
		System.out.println("Enter Product Id you wish to modify/remove:");
		productId = scanner.nextInt();
		CheckProductId checkProductId = new CheckProductId();
		if(checkProductId.isProductIdInProductTable(productId)) {
			return true;
		}
		return false;		
	}
	
	
	public void getProductNameToUpdate() {
		
		System.out.println("Enter New Product Name:");
		productName = scanner.nextLine();
	}
	
	
	public void getProductCategoryToUpdate() {
		
		System.out.println("Enter New Product Category:");
		productCategory = scanner.nextLine();		
	}
	
	
	public void getProductDescriptionToUpdate() {
		System.out.println("Enter New Product Description:");
		productDescription = scanner.nextLine();		
	}
	
	
	public void getProductPriceToUpdate() {
		System.out.println("Enter New Product Price:");
		productPrice = scanner.nextInt();		
	}
	
	
	public boolean getCustomerCreateAccountDetails() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		System.out.println(ShoppingAppConstants.enterUserName);
		customerUserName = scanner.nextLine();
		
		if(customerUserName.matches("[a-zA-Z]+")) {
			System.out.println(ShoppingAppConstants.enterPassword);
			customerPassword = scanner.nextLine();
			customerHashedPassword = EncryptPassword.encryptPassword(customerPassword);
			System.out.println(ShoppingAppConstants.enterAddress);
			customerAddress = scanner.nextLine();
			System.out.println(ShoppingAppConstants.enterPhoneNumber);
			try {
				customerPhoneNumber = scanner.nextLong();
				String customerPhoneNumberString =Long.toString(customerPhoneNumber);
				int phoneNumberLength = customerPhoneNumberString.length();
				
				//phone number must be 10 digits
				if(phoneNumberLength!=10) {
					System.out.println("Invalid PhoneNumber.Please enter 10 digits number.");
					return false;
				}
				else {
					
					return true;
				}
			}
			catch(InputMismatchException e) {
				
				System.out.println(ShoppingAppConstants.enterOnlyNumbers);
				return false;
			}
		}
			
		else {
			System.out.println("UserName cannot contain digits.Please enter valid UserName..");
			return false;
		}
	}
	
	
	public boolean getCustomerLoginDetails() {
		
		System.out.println(ShoppingAppConstants.enterPhoneNumber);
		
		try {
			
			customerPhoneNumber = scanner.nextLong();
			scanner.nextLine();
			System.out.println(ShoppingAppConstants.enterPassword);
			customerPassword = scanner.nextLine();
			String customerPhoneNumberString =Long.toString(customerPhoneNumber);
			int phoneNumberLength = customerPhoneNumberString.length();
			if(phoneNumberLength!=10) {
				System.out.println("Invalid PhoneNumber.Please enter 10 digits number.");
				return false;
			}
			else {
				return true;
			}
		}
		catch(InputMismatchException e) {
			
			System.out.println(ShoppingAppConstants.enterOnlyNumbers);
			return false;
		}
		
	}
	
	
	public void getCustomerNewAddress() {
		
		System.out.println("Enter new Address to ship the product:");
		customerAddress = scanner.nextLine();
	}
	
	
	public void getOrderId() {
		
		System.out.println("Enter Order Id to view the details:");
		System.out.println(ShoppingAppConstants.goHome);
		orderId = scanner.nextInt();
	}
	
	
	public void getSupplierId() {
		
		System.out.println("Enter Supplier Id to view their products:");
		System.out.println(ShoppingAppConstants.goHome);
		supplierId = scanner.nextInt();
	}
	
	
	public void getAdminLoginDetails() {
		
		System.out.println("Hello Admin");
		System.out.println(ShoppingAppConstants.enterUserName);
		setAdminUserName(scanner.nextLine());
		System.out.println(ShoppingAppConstants.enterPassword);
		setAdminPassword(scanner.nextLine());
	}
	
	//getters and setters - encapsulation
	public String getAdminUserName() {
		return adminUserName;
	}
	
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public void getOrderDetails() {

		System.out.println("Give the current status of the product: ");
		deliveryStatus = scanner.nextLine();
		System.out.println("Enter the delivery date of the product in YYYY-MM-DD:");
		deliveryDate = scanner.nextLine();
	}
	
	public void getDeliveryDateToUpdate()
	{
		System.out.println("Enter the new delivery date of the product in YYYY-MM-DD:");
		deliveryDate = scanner.nextLine();
	}	
}
