package view.admin;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetIdUsingId;
import databaseoperations.classes.databasegetoperations.getEntities.GetOrderDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetCustomerEntityDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetProductEntityDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetSupplierEntityDetails;
import databaseoperations.interfaces.gettable.IdGettable;
import driver.admin.ManageOrderDetails;
import entities.Customers;
import entities.Products;
import entities.Shipment;
import entities.Suppliers;

public class DisplayOrderDetails {

	/**
	 * 
	 * @param orderId
	 */
	public void displayOrderDetails(int orderId) {
		
		//order details
		System.out.println(ShoppingAppConstants.greaterThanLine+"\n");
		System.out.println("\t\t\tORDER DETAILS\n");
		System.out.println(ShoppingAppConstants.lessThanLine+"\n");
		System.out.printf("%s", "orderId");
		System.out.printf("\n%d", orderId);
		
		GetOrderDetails getOrder = new GetOrderDetails();
		for(Shipment order : getOrder.getOrderDetails(orderId))
		{
			System.out.print("\nOrder is "+order.deliveryStatus);
			if(!(order.deliveryStatus.equals(ShoppingAppConstants.cancelled))) {
				System.out.printf("%32s %s","Delivery Date: " ,order.deliveryDate);
			}
		}
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		
		//product details
		IdGettable getId = new GetIdUsingId();
		int productId = getId.getId(orderId, ShoppingAppConstants.productIdColumn, ShoppingAppConstants.ordersTable, ShoppingAppConstants.orderIdColumn);
		GetProductEntityDetails getProduct = new GetProductEntityDetails();
		for(Products product : getProduct.getProductList(productId))
		{
			System.out.println(product.productName);
			System.out.println(product.productCategory);
			System.out.println("Cost :"+product.getProductPrice());
		}
		
		System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		
		
		//supplier details
		int supplierId = getId.getId(productId, ShoppingAppConstants.supplierIdColumn, ShoppingAppConstants.productsTable, ShoppingAppConstants.productIdColumn);
		
		GetSupplierEntityDetails getSupplier = new GetSupplierEntityDetails();
		for(Suppliers supplier : getSupplier.getSupplierList(supplierId))
		{
			System.out.printf("%s", "Supplier Id\n");
			System.out.printf("%d", supplierId);
			System.out.printf("\n%s",supplier.supplierName);
			System.out.printf("%50s %s","Contact supplier at: ",supplier.supplierPhoneNumber);
			System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		}
		
		
		
		//customer details
		int customerId = getId.getId(orderId, ShoppingAppConstants.customerIdColumn,ShoppingAppConstants.ordersTable ,ShoppingAppConstants.orderIdColumn);
		
		GetCustomerEntityDetails getCustomer = new GetCustomerEntityDetails();
		for(Customers customer : getCustomer.getCustomerList(customerId))
		{
			System.out.println("Shipping Details\n");
			System.out.printf("%s", customer.customerName);
			System.out.printf("\n%s", customer.customerAddress);
			System.out.printf("\n%d", customer.customerPhoneNumber);
			System.out.println("\n"+ShoppingAppConstants.bigUnderscoreLine+"\n");
		}
		
		ManageOrderDetails manageOrderDetails = new ManageOrderDetails();
		manageOrderDetails.manageOrderDetails(orderId);		
	}
}
