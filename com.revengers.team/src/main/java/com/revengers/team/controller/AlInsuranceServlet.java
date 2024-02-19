package com.revengers.team.controller;

import java.io.IOException;
import java.util.List;

import com.revengers.team.encapsulated.ALEntity;
import com.revengers.team.implementation.ImplementationOther;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AlInsuranceServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public AlInsuranceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	String SNo=request.getParameter("SNo");
//	int sno=0;
//	try {
//		sno=Integer.parseInt(SNo);
//	}
//	catch(Exception e) {
//		sno=0;
//	}
//	String name=request.getParameter("name");
//	String age=request.getParameter("age");
//	int Age=0;
//	try {
//		Age=Integer.parseInt(age);
//	}catch(Exception e) {
//		Age=0;
//	}
//	String policyNo=request.getParameter("policyNo");
//	String startDate=request.getParameter("startDate");
//	String endDate=request.getParameter("endDate");
//	ALEntity enrol=new ALEntity();
//	enrol.setSNo(sno);
//	enrol.setName(name);
//	enrol.setAge(Age);
//	enrol.setPolicyNo(policyNo);
//	enrol.setStartDate(startDate);
//	enrol.setEndDate(endDate);
//	
//	
//	
//		Implementation imp = new Implementation();
//		int result = imp.Insertmethod2(enrol);
//		HttpSession session = request.getSession();
//		session.setAttribute("register", enrol);
//
//		//RequestDispatcher success = request.getRequestDispatcher("/ViewEnrolment.html");
//		RequestDispatcher success = request.getRequestDispatcher("AlEnrolment.html");
//		RequestDispatcher failed = request.getRequestDispatcher("Failure.html");
//
//		(result >= 1 ? success : failed).forward(request, response);
//
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Get is Triggered");
		ImplementationOther imp = new ImplementationOther();
		List<ALEntity> result = imp.ALFetch();
		HttpSession session = request.getSession();
		session.setAttribute("details2", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/FetchAir.jsp");
		try {
			rd.forward(request, response);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			 
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
