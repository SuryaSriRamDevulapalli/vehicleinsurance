package com.revengers.team.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revengers.team.encapsulated.InsuranceEntityEmail;
import com.revengers.team.implementation.Implementation1;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CreatedServletEmail extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public CreatedServletEmail() {
        super();
    }
	//compose
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
	        System.out.println("POST method triggered");
	        
	        String sender = request.getParameter("sender");	  
	        String recipient = request.getParameter("recipient");
	        String subject = request.getParameter("subject");
	        String message = request.getParameter("message");
	    
	            
	        InsuranceEntityEmail insurance = new InsuranceEntityEmail();
	        insurance.setSender(sender);
	        insurance.setRecipient(recipient);
	        insurance.setSubject(subject);
	        insurance.setMessage(message);
	        
	        Implementation1 imp = new Implementation1();
				try {
					int result = imp.InsertCompose(insurance);
				
		
				HttpSession session = request.getSession();
				session.setAttribute("insertCompse", insurance);
	        
	        
				RequestDispatcher success = request.getRequestDispatcher("/SuccessSent.jsp");
				RequestDispatcher failed = request.getRequestDispatcher("Failure.html");
				
				if(result>0) {
					success.forward(request, response);				
				}else {
					failed.forward(request, response);
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    }
	//view sent
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get is triggered");
		String selectedSender = request.getParameter("sender");
		Implementation1 imp = new Implementation1();
		List<InsuranceEntityEmail> result;
		try {
			result = imp.fetchSent(selectedSender);
			HttpSession session = request.getSession();
			session.setAttribute("FetchSent", result);
			
			RequestDispatcher req =  request.getRequestDispatcher("/FetchSent.jsp");
			req.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
