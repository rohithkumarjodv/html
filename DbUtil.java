package com.mphasis.player.dbutil;
 import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private static Connection conn;
	public static Connection openConnection(){
	try{
	     Class.forName("oracle.jdbc.OracleDriver");
	     conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rohith","33451");
	}catch(Exception e) {
		e.printStackTrace();
	}return conn;
}
	public static void closeConnection() {
		try {
		conn.close();
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	
}
}


