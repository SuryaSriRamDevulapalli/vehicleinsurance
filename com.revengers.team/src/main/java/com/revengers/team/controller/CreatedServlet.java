package com.revengers.team.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.revengers.team.encapsulated.InsuranceEntity;
import com.revengers.team.implementation.Implementation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CreatedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public CreatedServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Post Method Triggered");

	    String vehicle_name = request.getParameter("vehicle_name");
	    String variant = request.getParameter("variant");
	    String fuel_type = request.getParameter("fuel_type");
	    String vehicle_no = request.getParameter("vehicle_no");
	    String policy_type = request.getParameter("policy_type");
	    String name =  request.getParameter("name");
	    String email = request.getParameter("email");
	    String number = request.getParameter("number");
        String pincode = request.getParameter("pincode");
        int FEpincode = 0;
        try {
        	FEpincode = Integer.parseInt(pincode);
        } catch (NumberFormatException e) {
        	FEpincode = 0; 
        }

	    InsuranceEntity insurance = new InsuranceEntity();
	    insurance.setVehicle_name(vehicle_name);
	    insurance.setVariant(variant);
	    insurance.setFuel_type(fuel_type);
	    insurance.setVehicle_no(vehicle_no);
	    insurance.setPolicy_type(policy_type);
	    insurance.setName(name);
	    insurance.setEmail(email);
	    insurance.setNumber(number);
	    insurance.setPincode(FEpincode);

	    Implementation imp = new Implementation();

	    try {
	    	 int result = imp.Enrollment(insurance);

	         
	         int policy_no = imp.PolicyNumberDB(); 
	         int customer_id = imp.CustomerIDDB();
	         int price = imp.priceDB();

	         request.setAttribute("policyNumber", policy_no);
	         request.setAttribute("customerID", customer_id); 
	         request.setAttribute("price", price);

	         HttpSession session = request.getSession();
	         session.setAttribute("insuranceInsert", insurance);

	         RequestDispatcher success = request.getRequestDispatcher("/Success.jsp");
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

protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    	
    	System.out.println("GET method is triggered");
    	
    	String customer_id = request.getParameter("customer_id");
        int FEcustomer_id = 0;
        try {
        	FEcustomer_id = Integer.parseInt(customer_id);
        } catch (NumberFormatException e) {
        	FEcustomer_id = 0; 
        }
    	Implementation imp = new Implementation();
    	try {
    		Implementation entity = imp.SearchCustID(FEcustomer_id);
			HttpSession session = request.getSession();
			
			session.setAttribute("insuranceSearch", entity);
			
			RequestDispatcher success = request.getRequestDispatcher("/Profile");
			RequestDispatcher failed = request.getRequestDispatcher("/Failure.html");
			
			if(entity!=null) {
				success.forward(request, response);	
			}else {
				failed.forward(request, response);		
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
    }
}
