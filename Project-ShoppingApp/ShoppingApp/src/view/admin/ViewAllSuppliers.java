package view.admin;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasecheckoperations.CheckSupplierId;
import databaseoperations.classes.databasegetoperations.GetDetailsInHashMapFromDatabase;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetCustomerDetails;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetSupplierEntityDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetCustomerIdList;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetSupplierIdList;
import databaseoperations.interfaces.checkable.SupplierIdCheckable;
import databaseoperations.interfaces.gettable.SupplierDetailsGettable;
import databaseoperations.interfaces.gettable.SupplierIdListGettable;
import driver.admin.AdminMethodsDriver;
import driver.customers.MyCartDriver;
import driver.suppliers.SupplierMethodsDriver;
import entities.Customers;
import entities.Suppliers;
import utilities.GetDetails;
import view.suppliers.ViewSupplierProducts;

public class ViewAllSuppliers {

	int supplierId;
	String supplierUserName;
	public void ViewAllSuppliers() {
		
		
		GetDetails getDetails = new GetDetails();
		SupplierIdCheckable checkSupplierId = new CheckSupplierId();
		SupplierDetailsGettable getSupplierDetails = new GetSupplierDetails();
		SupplierIdListGettable getSuppliersIdList = new GetSupplierIdList();
		ViewSupplierProducts view = new ViewSupplierProducts();
		AdminMethodsDriver adminMethodsDrive = new AdminMethodsDriver();
		
		
		System.out.println(ShoppingAppConstants.bigEqualLine+"\n");
		System.out.println("\t\t\t\t\tOUR SUPPLIERS");
		System.out.println(ShoppingAppConstants.bigEqualLine+"\n");
		System.out.printf("%s %20s %35s\n","Supplier Id",
				"Name","PhoneNumber");
		System.out.println(ShoppingAppConstants.bigUnderscoreLine);
		
		GetSupplierEntityDetails getSupplier = new GetSupplierEntityDetails();
		ArrayList<Suppliers>supplierList = getSupplier.getSupplierList();
		for(Suppliers supplier : supplierList)
		{
			System.out.printf("%d %30s %40d\n",supplier.supplierId,supplier.supplierName,supplier.supplierPhoneNumber);
		
		}
		System.out.println("\n"+ShoppingAppConstants.bigEqualLine);
			System.out.println("\n"+ShoppingAppConstants.bigEqualLine);
			getDetails.getSupplierId();
			
			supplierUserName = getSupplierDetails.getSupplierName(getDetails.supplierId);
			
			if(getDetails.supplierId!=0 && checkSupplierId.isSupplierIdInSupplierTable(getDetails.supplierId)) {
				
				view.viewSupplierAllProducts(supplierUserName);
			}
			else if(getDetails.supplierId==0) {
				
				adminMethodsDrive.adminMethodsDriver();
			}
			else {
				System.out.println(ShoppingAppConstants.invalidChoice);
			}
		}

}
