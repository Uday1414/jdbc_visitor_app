package com.ty.visitor.controller;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitor.dto.Visitor;

public class TestVisitorInsert {
	public static void main(String[] args) {
		Visitor visitor=new Visitor();
		visitor.setId(6);
		visitor.setName("sivaraj");
		visitor.setEmail("siva@mail.com");
		visitor.setPhone("78554545");
		visitor.setAge(23);
		visitor.setGender("Male");
		visitor.setDob("8-AUG-1996");
		visitor.setVisitDate("15-MAY-2022");
		visitor.setVisitTime("18:00");
		
		VisitorDao visitorDao=new VisitorDao();
		int res=visitorDao.saveVisitor(visitor);
		if(res>0)
			System.out.println("Visitor saved");
		else
			System.out.println("Not saved");
	}
}
