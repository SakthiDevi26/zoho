package databaseoperations.classes.databasegetoperations.getDetailsFromDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appconstants.ShoppingAppConstants;
import databaseoperations.interfaces.gettable.IdGettable;
import sql.DatabaseConnection;

public class GetIdUsingId implements IdGettable {

	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	int valueId;
	
	
	public int getId(int id, String valueIdColumn, String tableName, String columnName)
	{
		sql ="Select * from "+ tableName +" where "+ columnName +" = "+id;
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			if(resultset.next()) {
				valueId = resultset.getInt(valueIdColumn);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valueId;		
	}
}
