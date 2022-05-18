package com.ty.visitor.controller;

import com.ty.visitor.dao.UserDao;

public class TestDeleteUser {
	public static void main(String[] args) {
		UserDao userDao=new UserDao();
		int res=userDao.deleteUserById(1);
		if(res>0)
			System.out.println("User Deleted");
		else
			System.out.println("No user found");
	}
}
