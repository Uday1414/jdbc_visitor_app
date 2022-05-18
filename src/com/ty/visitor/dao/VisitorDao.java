package com.ty.visitor.dao;

import static com.ty.visitor.util.AppConstants.SECRETE_KEY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.visitor.dto.Visitor;
import com.ty.visitor.util.AES;
import com.ty.visitor.util.ConnectionHelper;


public class VisitorDao {
	
	public int saveVisitor(Visitor visitor){
		String query="INSERT INTO visitor VALUES (?,?,?,?,?,?,?,?,?)";
		Connection connection=ConnectionHelper.getConnection();
		String name=AES.encrypt(visitor.getName(), SECRETE_KEY);
		String email=AES.encrypt(visitor.getEmail(), SECRETE_KEY);
		String phone=AES.encrypt(visitor.getPhone(), SECRETE_KEY);
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, visitor.getId());
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, phone);
			preparedStatement.setInt(5, visitor.getAge());
			preparedStatement.setString(6, visitor.getGender());
			preparedStatement.setString(7, visitor.getDob());
			preparedStatement.setString(8, visitor.getVisitDate());
			preparedStatement.setString(9, visitor.getVisitTime());
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
	
	public String get(String s) {
		return AES.decrypt(s, SECRETE_KEY);
	}
	
	public Visitor getVisitorById(int id) {
		String query="SELECT * FROM visitor WHERE id=?";
		Connection connection=ConnectionHelper.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				//String name=AES.decrypt(resultSet.getString(2),SECRETE_KEY);
				Visitor visitor=new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(get(resultSet.getString(2)));
				visitor.setEmail(get(resultSet.getString(3)));
				visitor.setPhone(resultSet.getString(4));
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				visitor.setDob(resultSet.getString(7));
				visitor.setVisitDate(resultSet.getString(8));
				visitor.setVisitTime(resultSet.getString(9));
				return visitor;
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
	
	public List<Visitor> getAllVisitors() {
		String query="SELECT * FROM visitor";
		ArrayList<Visitor> arrayList=new ArrayList<>();
		Connection connection=ConnectionHelper.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Visitor visitor=new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(get(resultSet.getString(2)));
				visitor.setEmail(get(resultSet.getString(3)));
				visitor.setPhone(resultSet.getString(4));
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				visitor.setDob(resultSet.getString(7));
				visitor.setVisitDate(resultSet.getString(8));
				visitor.setVisitTime(resultSet.getString(9));
				
				arrayList.add(visitor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return arrayList;
    }
	
	public List<Visitor> getVisitorsByDate(String date) {
		String query="SELECT * FROM visitor WHERE visitdate=?";
		ArrayList<Visitor> arrayList=new ArrayList<>();
		Connection connection=ConnectionHelper.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, date);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Visitor visitor=new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(get(resultSet.getString(2)));
				visitor.setEmail(get(resultSet.getString(3)));
				visitor.setPhone(resultSet.getString(4));
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				visitor.setDob(resultSet.getString(7));
				visitor.setVisitDate(resultSet.getString(8));
				visitor.setVisitTime(resultSet.getString(9));
				
				arrayList.add(visitor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return arrayList;
    }
	
	public List<Visitor> getVisitorsByAgeRange(int a,int b) {
		String query="SELECT * FROM visitor WHERE age BETWEEN ? and ?";
		ArrayList<Visitor> arrayList=new ArrayList<>();
		Connection connection=ConnectionHelper.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, a);
			preparedStatement.setInt(2, b);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Visitor visitor=new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(get(resultSet.getString(2)));
				visitor.setEmail(get(resultSet.getString(3)));
				visitor.setPhone(resultSet.getString(4));
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				visitor.setDob(resultSet.getString(7));
				visitor.setVisitDate(resultSet.getString(8));
				visitor.setVisitTime(resultSet.getString(9));
				
				arrayList.add(visitor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return arrayList;
    }
}
