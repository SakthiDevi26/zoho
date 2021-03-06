package view.suppliers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.ListIterator;
import sql.DatabaseConnection;
import appconstants.ShoppingAppConstants;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetIdUsingId;
import databaseoperations.classes.databasegetoperations.getDetailsFromDatabase.GetSupplierDetails;
import databaseoperations.classes.databasegetoperations.getEntities.GetProductEntityDetails;
import databaseoperations.classes.databasegetoperations.getlistfromdatabase.GetProductIdList;
import databaseoperations.interfaces.gettable.IdGettable;
import databaseoperations.interfaces.gettable.ProductIdListGettable;
import databaseoperations.interfaces.gettable.SupplierDetailsGettable;
import driver.suppliers.SupplierMethodsDriver;
import entities.Products;

public class ViewSupplierProducts {
	
	String sql="";
	Connection connect = DatabaseConnection.getConnection();

	/**
	 * 
	 * @param supplierUserName
	 */
	public void viewSupplierAllProducts(String supplierUserName) {
		
		//objects
		SupplierMethodsDriver supplierMethodsDrive = new SupplierMethodsDriver();
		SupplierDetailsGettable getSupplierDetails = new GetSupplierDetails();
		ProductIdListGettable getProductIdList = new GetProductIdList();
		
		
		int supplierId = getSupplierDetails.getSupplierId(supplierUserName);
	
		//get all product Id of specific supplier
		ArrayList<Integer> productIdList = new ArrayList<Integer>();
		productIdList = getProductIdList.getSupplierProductIdList(supplierId);
		
		if(!productIdList.isEmpty())
		{
		
			//print all the products with details
			System.out.println(ShoppingAppConstants.smallHyphen+"<< Products >>"+ShoppingAppConstants.smallHyphen+"\n");
			ListIterator<Integer> productIdListIterator = productIdList.listIterator();
			while(productIdListIterator.hasNext())
			{
				GetProductEntityDetails getProduct = new GetProductEntityDetails();
				ArrayList<Products> productList = getProduct.getProductList(productIdListIterator.next());
				productIdListIterator.previous();
				for (Products product : productList)
				{
					System.out.printf("%12s %20s %20s %20s\n","Product Id",
							"Name",
							"Category","Price");		
					System.out.println(ShoppingAppConstants.bigUnderscoreLine+"\n");	
					System.out.printf("%12d %20s %20s %20d\n\n\n",productIdListIterator.next(),product.productName,product.productCategory,product.getProductPrice());
					System.out.printf("%s\n\n","Product Description:");
					String[] productDescriptionSplit = product.productDescription.split("[.]",0);
					
					for(String productDescriptionFormatted:productDescriptionSplit) {
						System.out.printf("%12s\n",productDescriptionFormatted);
					}
					System.out.println("\n"+ShoppingAppConstants.equalLine+ShoppingAppConstants.equalLine+"\n");
				}
			}
		}
		else
		{
			System.out.println("Sorry there is no product :(");
			supplierMethodsDrive.supplierMethodsDriver(supplierUserName);

		}
	}
}
