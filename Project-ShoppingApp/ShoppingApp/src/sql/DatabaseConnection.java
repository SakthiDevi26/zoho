package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	static Connection connect; // Global Connection Object
    
	public static Connection getConnection() {
       
    	try {
           
    		String mysqlJDBCDriver
                = "com.mysql.jdbc.Driver"; //jdbc driver
            String url
                = "jdbc:mysql://localhost:3306/shopping_app?autoReconnect=true&useSSL=false"; //mysql url
            String user = "root";   //mysql username
            String pass = "1234";  //mysql passcode
            Class.forName(mysqlJDBCDriver);
            connect = DriverManager.getConnection(url, user,
                                              pass);
        }
        catch (Exception e) {
            System.out.println("Database Connection Failed!");
        }
    	
        return connect;
    }
}
