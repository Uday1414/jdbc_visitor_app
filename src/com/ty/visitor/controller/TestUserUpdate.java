package com.ty.visitor.controller;

import com.ty.visitor.dao.UserDao;
import com.ty.visitor.dto.User;

public class TestUserUpdate {
	public static void main(String[] args) {
		User user=new User();
		user.setId(1);
		user.setName("bhaskar");
		user.setEmail("bh@mail.com");
		user.setPhone(8328640567l);
		user.setPassword("bhas@1414");
		
		UserDao userDao=new UserDao();
		int res=userDao.updateUser(1, user);
		if(res>0)
			System.out.println("User Updated");
		else
			System.out.println("No user found");
	}
}
