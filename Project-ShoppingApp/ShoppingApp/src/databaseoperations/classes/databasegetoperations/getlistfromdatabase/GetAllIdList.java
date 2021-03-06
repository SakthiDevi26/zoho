package databaseoperations.classes.databasegetoperations.getlistfromdatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import databaseoperations.interfaces.gettable.IdListGettable;
import sql.DatabaseConnection;

public class GetAllIdList implements IdListGettable{

	String sql="";
	Connection connect = DatabaseConnection.getConnection();
	int valueId;
	
public ArrayList<Integer> getAllIdList( String tableName, String valueIdColumnName) {
		
		ArrayList<Integer> valueIdList = new ArrayList<Integer>();
		sql ="Select * from "+ tableName;
		
		try {
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			while(resultset.next()) {
				valueId = resultset.getInt(valueIdColumnName);
				valueIdList.add(valueId);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valueIdList;
	}
}
