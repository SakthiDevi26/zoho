package view.customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetProductDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetCustomerIdList;
import databaseoperations.interfaces.gettable.CustomerIdListGettable;
import databaseoperations.interfaces.gettable.ProductDetailsGettable;
import databaseoperations.interfaces.gettable.SupplierDetailsGettable;
import driver.customers.ProductOptionsDriver;
import sql.DatabaseConnection;

public class ViewProductInDetail {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	
	public String productName, productCategory,productDescription,supplierName,feedback,analyzedFeedback,customerName;
	public int productPrice,supplierId,customerId;
	public long supplierPhoneNumber;
	
	/**
	 * 
	 * @param productId
	 */
	public void viewProductInDetail(int productId) {
		
		//objects
		ProductOptionsDriver productOptionDriver = new ProductOptionsDriver();
		ProductDetailsGettable getProductDetails = new GetProductDetails();
		SupplierDetailsGettable getSupplierDetails = new GetSupplierDetails();
		CustomerIdListGettable getCustomerIdList = new GetCustomerIdList();
		
		//get product details
		productName = getProductDetails.getProductName(productId);
		productCategory = getProductDetails.getProductCategory(productId);
		productDescription = getProductDetails.getProductDescription(productId);
		productPrice = getProductDetails.getProductPrice(productId);
		
		//display product details
		System.out.println("\n"+ShoppingAppConstants.equalLine);
		System.out.printf("\n%12s %30s\n",
				"Product Name",
				"Category");
		System.out.printf("%12s %30s\n\n",productName,productCategory);
		System.out.printf("%12s\n","Description:");
		String[] productDescriptionSplit = productDescription.split("[.]",0);
		
		for(String productDescriptionFormatted:productDescriptionSplit) {
			System.out.printf("%12s\n",productDescriptionFormatted);
		}
		System.out.println(ShoppingAppConstants.bigUnderscoreLine);	
		
		//get supplier details
		supplierId = getSupplierDetails.getSupplierId(productId);
		supplierName = getSupplierDetails.getSupplierName(supplierId);
		supplierPhoneNumber = getSupplierDetails.getSupplierPhoneNumber(supplierId);
		
		//display supplier details
		System.out.printf("\n\nSold by :%s\n",supplierName);
		System.out.printf("Contact Supplier at %d\n\n", supplierPhoneNumber);
		System.out.printf("Buy at only:%d\n\n",productPrice);
		System.out.println(ShoppingAppConstants.bigUnderscoreLine);	
		System.out.println("\n"+ShoppingAppConstants.equalLine);
		
		//reviews to be added
		
		productOptionDriver.productOptionsDriver(productId);
	}

}