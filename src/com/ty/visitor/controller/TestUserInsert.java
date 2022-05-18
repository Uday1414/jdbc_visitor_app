package com.ty.visitor.controller;
import com.ty.visitor.dao.UserDao;
import com.ty.visitor.dto.User;

public class TestUserInsert {
	public static void main(String[] args) {
		User user=new User();
		user.setId(1);
		user.setName("uday");
		user.setEmail("ud@mail.com");
		user.setPhone(9985564878l);
		user.setPassword("uday@1414");
		user.setRole("trainer");
		
		UserDao userDao=new UserDao();
		int res=userDao.saveUser(user);
		if(res>0)
			System.out.println("User saved");
		else
			System.out.println("User not saved");
	}
}
