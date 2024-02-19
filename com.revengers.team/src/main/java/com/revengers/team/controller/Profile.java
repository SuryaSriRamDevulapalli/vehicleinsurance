package com.revengers.team.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.revengers.team.encapsulated.InsuranceEntity;
import com.revengers.team.encapsulated.InsuranceEntityClaim;
import com.revengers.team.implementation.Implementation;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("unused")
public class Profile extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	public Profile() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		Implementation imp = (Implementation) session.getAttribute("insuranceSearch");
		 InsuranceEntity insuranceEntity = imp.getInsuranceEntity();
		 InsuranceEntityClaim insuranceEntityClaim = imp.getInsuranceEntityClaim();
		
		PrintWriter pw = response.getWriter();
		pw.print("<html><body><style>");
		pw.print("header{\r\n"
				+ "background-color: wheat;\r\n"
				+ "color: #7b312d;\r\n"
				+ "font-weight: bold;\r\n"
				+ "margin-top:  0;\r\n"
				+ "margin-bottom: 0;\r\n"
				+ "padding: 20px;\r\n"
				+ "font-size: 45px;\r\n"
				+ "text-shadow: 2px 2px 4px  rgba(0, 0, 0, 0.5); \r\n"
				+ "display: flex;\r\n"
				+ "align-items: center; \r\n"
				+ "justify-content: center;\r\n"
				+ "box-shadow: 2px 2px 4px rgba(0, 0, 0, 1.5);\r\n"
				+ "}\r\n"
				+ "header img {\r\n"
				+ "  margin-right: 20px;\r\n"
				+ "  height: 70px;\r\n"
				+ "}\r\n"
				+ "body{\r\n"
				+ "margin: 0;\r\n"
				+ "padding: 0;\r\n"
				+ "background-color: #7b312d;\r\n"
				+ "font-family: Arial, sans-serif;\r\n"
				+ "} ");
		pw.print(".bottom-bar {\r\n"
				+ "    background-color: wheat;\r\n"
				+ "    height: 50px;\r\n"
				+ "    width: 100%;\r\n"
				+ "    position: fixed;\r\n"
				+ "    bottom: 0;\r\n"
				+ "    left: 0;\r\n"
				+ "}");
		pw.write(".bill {\r\n"
				+ "    max-width: 600px;\r\n"
				+ "    margin: 0 auto;\r\n"
				+ "    padding: 20px;\r\n"
				+ "    background-color: wheat;\r\n"
				+ "    border-radius: 10px;\r\n"
				+ "    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
				+ "}\r\n"
				+ ".bill form {\r\n"
				+ "    display: grid;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".bill label {\r\n"
				+ "    font-weight: bold;\r\n"
				+ "    color: #7b312d;\r\n"
				+ "}\r\n"
				+ ".bill input[type=\"text\"] {\r\n"
				+ "    width: auto;\r\n"
				+ "    padding: 10px;\r\n"
				+ "    border: 1px solid white;\r\n"
				+ "    border-radius: 5px;  \r\n"
				+ "    color: black;\r\n"
				+ "    font-weight: bold;\r\n"
				+ "}\r\n"
				+ ".bill input[type=\"submit\"] {\r\n"
				+ "    padding: 10px 20px;\r\n"
				+ "    background-color: #7b312d;\r\n"
				+ "    color: wheat;\r\n"
				+ "    border: none;\r\n"
				+ "    border-radius: 5px;\r\n"
				+ "    cursor: pointer;\r\n"
				+ "}");
		pw.print("h2{\r\n"
				+ "  color: #7b312d;\r\n"
				+ "  text-shadow: 2px 2px 4px  rgba(0, 0, 0, 0.5); \r\n"
				+ "}");
		pw.print("</style>");
		pw.print("<header>\r\n"
				+ "    <img src=\"https://ih1.redbubble.net/image.457170105.5964/st,small,507x507-pad,600x600,f8f8f8.jpg\" alt=\"\">\r\n"
				+ "    REVENGERS VEHICLE INSURANCE\r\n"
				+ "</header>");
		pw.write("<br>");
		pw.write("<div class=\"bill\">\r\n"
				+ "        <h2>Personal Details:</h2>");
		pw.write("<form>");
		pw.write("    <label for=\"name\">Name:</label>\r\n"
		        + "    <input type=\"text\" id=\"name\" name=\"name\" value=\"" + (insuranceEntity != null ? insuranceEntity.getName() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"number\">Number:</label>\r\n"
		        + "    <input type=\"text\" id=\"number\" name=\"number\" value=\"" + (insuranceEntity != null ? insuranceEntity.getNumber() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"email\">Email:</label>\r\n"
		        + "    <input type=\"text\" id=\"email\" name=\"email\" value=\"" + (insuranceEntity != null ? insuranceEntity.getEmail() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"pincode\">PinCode:</label>\r\n"
		        + "    <input type=\"text\" id=\"pincode\" name=\"pincode\" value=\"" + (insuranceEntity != null ? insuranceEntity.getPincode() : "") + "\" readonly ><br>\r\n");
		pw.write("</form>");
		pw.write("    </div>");
		
		pw.write("<br>");
		pw.write("<div class=\"bill\">\r\n"
				+ "        <h2>Vehicle Details:</h2>");
		pw.write("<form>");
		pw.write("    <label for=\"vehicle_name\">Vehicle Name:</label>\r\n"
		        + "    <input type=\"text\" id=\"vehicle_name\" name=\"vehicle_name\" value=\"" + (insuranceEntity != null ? insuranceEntity.getVehicle_name() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"vehicle_no\">Vehicle Number:</label>\r\n"
		        + "    <input type=\"text\" id=\"vehicle_no\" name=\"vehicle_no\" value=\"" + (insuranceEntity != null ? insuranceEntity.getVehicle_no() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"variant\">Variant:</label>\r\n"
		        + "    <input type=\"text\" id=\"variant\" name=\"variant\" value=\"" + (insuranceEntity != null ? insuranceEntity.getVariant(): "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"fuel_type\">Fuel Type:</label>\r\n"
		        + "    <input type=\"text\" id=\"fuel_type\" name=\"fuel_type\" value=\"" + (insuranceEntity != null ? insuranceEntity.getFuel_type() : "") + "\" readonly ><br>\r\n");
		pw.write("</form>");
		pw.write("    </div>");
		
		pw.write("<br>");
		pw.write("<div class=\"bill\">\r\n"
				+ "        <h2>Policy Details:</h2>");
		pw.write("<form>");
		pw.write("    <label for=\"policy_no\">Policy Number:</label>\r\n"
		        + "    <input type=\"text\" id=\"policy_no\" name=\"policy_no\" value=\"" + (insuranceEntity != null ? insuranceEntity.getPolicy_no() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"customer_id\">Customer ID:</label>\r\n"
		        + "    <input type=\"text\" id=\"customer_id\" name=\"customer_id\" value=\"" + (insuranceEntity != null ? insuranceEntity.getCustomer_id() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"policy_type\">Policy Type:</label>\r\n"
		        + "    <input type=\"text\" id=\"policy_type\" name=\"policy_type\" value=\"" + (insuranceEntity != null ? insuranceEntity.getPolicy_type(): "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"price\">Price(Annually in rupees):</label>\r\n"
		        + "    <input type=\"text\" id=\"price\" name=\"price\" value=\"" + (insuranceEntity != null ? insuranceEntity.getPrice() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"timestamp_column\">Policy taken on:</label>\r\n"
		        + "    <input type=\"text\" id=\"timestamp_column\" name=\"timestamp_column\" value=\"" + (insuranceEntity != null ? insuranceEntity.getTimestamp_column() : "") + "\" readonly ><br>\r\n");
		pw.write("</form>");
		pw.write("    </div>");
		
		pw.write("<br>");
		pw.write("<div class=\"bill\">\r\n"
				+ "        <h2>Claim Details:</h2>");
		pw.write("<form action=\"index.jsp\" method=\"post\">");
		pw.write("    <label for=\"claim_id\">Claim ID:</label>\r\n"
		        + "    <input type=\"text\" id=\"claim_id\" name=\"claim_id\" value=\"" + (insuranceEntityClaim != null ? insuranceEntityClaim.getClaim_id() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"damage_on\">Damage On:</label>\r\n"
		        + "    <input type=\"text\" id=\"damage_on\" name=\"damage_on\" value=\"" + (insuranceEntityClaim != null ? insuranceEntityClaim.getDamage_on() : "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"bill_amount\">Bill Amount(rupees):</label>\r\n"
		        + "    <input type=\"text\" id=\"bill_amount\" name=\"bill_amount\" value=\"" + (insuranceEntityClaim != null ? insuranceEntityClaim.getBill_amount(): "") + "\" readonly ><br>\r\n");
		pw.write("    <label for=\"claim_amount\">Claim Amount(rupees):</label>\r\n"
		        + "    <input type=\"text\" id=\"claim_amount\" name=\"claim_amount\" value=\"" + (insuranceEntityClaim != null ? insuranceEntityClaim.getClaim_amount() : "") + "\" readonly ><br>\r\n");
		pw.write("<input type=\"submit\" value=\"Back to Homepage\">");
		pw.write("</form>");
		pw.write("    </div>");
		
		pw.print("</body></html>");
		
	}
}
