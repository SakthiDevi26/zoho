package databaseoperations.classes.databasegetoperations.getEntities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appconstants.ShoppingAppConstants;
import entities.Customers;
import entities.Suppliers;
import sql.DatabaseConnection;

public class GetSupplierEntityDetails {

	String sql;
	Connection connect = DatabaseConnection.getConnection();
	public ArrayList<Suppliers> getSupplierList()
	{
		 ArrayList<Suppliers>supplierList = new ArrayList<Suppliers>();
		 sql ="Select * from "+ShoppingAppConstants.suppliersTable ;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				
				while(resultset.next()) {
					
					int supplierId = resultset.getInt(ShoppingAppConstants.supplierIdColumn);
					String supplierName = resultset.getString(ShoppingAppConstants.supplierUserNameColumn);
					String supplierPassword = resultset.getString(ShoppingAppConstants.supplierPasswordColumn);
					long supplierPhoneNumber = resultset.getLong(ShoppingAppConstants.supplierPhoneNumberColumn);
					Suppliers supplier = new Suppliers(supplierId, supplierName, supplierPhoneNumber);
					supplierList.add(supplier);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return supplierList;
			
	}
	public ArrayList<Suppliers> getSupplierList(int id)
	{
		 ArrayList<Suppliers>supplierList = new ArrayList<Suppliers>();
		 sql ="Select * from "+ShoppingAppConstants.suppliersTable +" where "+ShoppingAppConstants.supplierIdColumn+" = "+id;
			try {
				Statement statement = connect.createStatement();
				ResultSet resultset = statement.executeQuery(sql);
				
				while(resultset.next()) {

					int supplierId = resultset.getInt(ShoppingAppConstants.supplierIdColumn);
					String supplierName = resultset.getString(ShoppingAppConstants.supplierUserNameColumn);
					String supplierPassword = resultset.getString(ShoppingAppConstants.supplierPasswordColumn);
					long supplierPhoneNumber = resultset.getLong(ShoppingAppConstants.supplierPhoneNumberColumn);
					Suppliers supplier = new Suppliers(supplierId, supplierName, supplierPhoneNumber);
					supplierList.add(supplier);
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return supplierList;
			
	}

}
