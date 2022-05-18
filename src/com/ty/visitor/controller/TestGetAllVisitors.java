package com.ty.visitor.controller;

import java.util.List;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitor.dto.Visitor;

public class TestGetAllVisitors {
	public static void main(String[] args) {
		VisitorDao visitorDao=new VisitorDao();
		List<Visitor> list=visitorDao.getAllVisitors();
		if(list!=null)
		System.out.println(list);
		else
			System.out.println("No visitors");
	}
}
