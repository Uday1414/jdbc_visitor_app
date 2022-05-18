package com.ty.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.visitor.dto.User;
import com.ty.visitor.util.AES;
import com.ty.visitor.util.ConnectionHelper;
import static com.ty.visitor.util.AppConstants.SECRETE_KEY;

public class UserDao {
	public int saveUser(User user) {
		 String query="INSERT INTO user VALUES(?,?,?,?,?,?)";
		 Connection connection=ConnectionHelper.getConnection();
		 
		 try {
			 String enc=AES.encrypt(user.getPassword(), SECRETE_KEY);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setLong(4, user.getPhone());
			preparedStatement.setString(5, enc);
			preparedStatement.setString(6, user.getRole());
			
			return preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		 return 0;
	}
	
	public User validateUser(String email,String password) {
		String query="SELECT * FROM user WHERE email=? and password=?";
		
		Connection connection=ConnectionHelper.getConnection();
		
		try {
			String enc=AES.encrypt(password, SECRETE_KEY);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2,enc);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				User user=new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPhone(resultSet.getLong(4));
				user.setRole(resultSet.getString(6));
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int updateUser(int id,User user) {
		String query="UPDATE user SET name=?,email=?,password=?,phone=? WHERE id=?";
		Connection connection=ConnectionHelper.getConnection();
		String enc=AES.encrypt(user.getPassword(), SECRETE_KEY);
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail() );
			preparedStatement.setString(3, enc);
			preparedStatement.setLong(4, user.getPhone());
			preparedStatement.setInt(5, id);
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int deleteUserById(int id) {
		String query="DELETE FROM user WHERE id=?";
		
		Connection connection=ConnectionHelper.getConnection();
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
}
