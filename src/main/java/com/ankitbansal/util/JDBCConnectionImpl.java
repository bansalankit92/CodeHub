package com.ankitbansal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionImpl implements IDBConnection {

Connection con = null;
	
	private final String url="jdbc:mysql://localhost:3306/codehub";
	private final String username="root";
	private final String password="root";
	
	
	public void closeConnection() {
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	public Connection getConection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
					
			con = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}


}

	

