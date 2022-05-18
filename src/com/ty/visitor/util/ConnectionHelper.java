package com.ty.visitor.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import static com.ty.visitor.util.AppConstants.*;

public class ConnectionHelper {
	static String DRIVER="com.mysql.cj.jdbc.Driver";
	static String URL="jdbc:mysql://localhost:3307/jdbc_visitor";
	 static String USER="root";
	 static String PASSWORD="root";
	
	
	
		static {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
							e.printStackTrace();
			}
		}
		
		public static Connection getConnection() {
			try {
				return DriverManager.getConnection(URL,USER,PASSWORD);
			}catch(SQLException e){
				e.printStackTrace();
			}
			return null;
		}
	}


