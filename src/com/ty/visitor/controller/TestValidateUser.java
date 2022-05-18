package com.ty.visitor.controller;

import com.ty.visitor.dao.UserDao;
import com.ty.visitor.dto.User;

public class TestValidateUser {
	 public static void main(String[] args) {
		UserDao userDao=new UserDao();
		User user=userDao.validateUser("ud@mail.com", "uday@1414");
		if(user!=null)
			System.out.println(user);
		else
			System.out.println("No User found");
	}
}
