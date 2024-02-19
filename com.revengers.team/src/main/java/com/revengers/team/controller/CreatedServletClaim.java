package com.revengers.team.controller;

import java.io.IOException;
import java.sql.SQLException;
import com.revengers.team.encapsulated.InsuranceEntityClaim;
import com.revengers.team.implementation.Implementation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CreatedServletClaim extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public CreatedServletClaim() {
		super();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String policy_no = request.getParameter("policy_no");
	    int FEpolicy_no = 0;
	    try {
	        FEpolicy_no = Integer.parseInt(policy_no);
	    } catch (NumberFormatException e) {
	        FEpolicy_no = 0; 
	    }
	    String customer_id = request.getParameter("customer_id");
	    int FEcustomer_id = 0;
	    try {
	        FEcustomer_id = Integer.parseInt(customer_id);
	    } catch (NumberFormatException e) {
	        FEcustomer_id= 0; 
	    }
	    String policy_type = request.getParameter("policy_type");
	    String damage_on = request.getParameter("damage_on");
	    String bill_amount = request.getParameter("bill_amount");
	    int FEbill_amount = 0;
	    try {
	        FEbill_amount = Integer.parseInt(bill_amount);
	    } catch (NumberFormatException e) {
	        FEbill_amount= 0; 
	    }
	    
	    InsuranceEntityClaim insurance = new InsuranceEntityClaim();
	    
	    insurance.setPolicy_no(FEpolicy_no);
	    insurance.setCustomer_id(FEcustomer_id);
	    insurance.setPolicy_type(policy_type);
	    insurance.setDamage_on(damage_on);
	    insurance.setBill_amount(FEbill_amount);
	    
	    Implementation imp = new Implementation();
	    
	    try {
	        int result = imp.ClaimStatus(insurance);
	        
	        int claim_amount = imp.ClaimAmount(insurance);
	        
	        request.setAttribute("claim_amount", claim_amount);
	        
	        HttpSession session = request.getSession();
	        session.setAttribute("insuranceClaim", insurance);

	        RequestDispatcher success = request.getRequestDispatcher("/Success1.jsp");
	        RequestDispatcher failed = request.getRequestDispatcher("Failure.html");

	        if(result > 0) {
	            success.forward(request, response);
	        } else {
	            failed.forward(request, response);
	        }       
	    } catch (SQLException e) {
	        
	        e.printStackTrace();
	    }
	}

}
