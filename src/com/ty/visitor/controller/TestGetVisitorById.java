package com.ty.visitor.controller;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitor.dto.Visitor;

public class TestGetVisitorById {
	public static void main(String[] args) {
		VisitorDao visitorDao=new VisitorDao();
		Visitor visitor=visitorDao.getVisitorById(4);
		if(visitor!=null)
			System.out.println(visitor);
		else
			System.out.println("No visitor Found");
	}
}
