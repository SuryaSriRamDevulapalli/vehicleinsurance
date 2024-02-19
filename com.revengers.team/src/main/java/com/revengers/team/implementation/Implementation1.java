package com.revengers.team.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revengers.team.encapsulated.InsuranceEntityEmail;
import com.revengers.team.jdbc.JDBC;


public class Implementation1 {
	
	Connection connect;
	PreparedStatement prep;
	ResultSet resultset;
	Statement state;
	
	public Implementation1() {
		connect = JDBC.getinstance();
	}	
	//compose
	public int InsertCompose(InsuranceEntityEmail entity) throws SQLException {
		int result = 0;
		System.out.println("Implementation is triggered");
		String query = "insert into emails (sender, recipient, subject, message) values (?, ?, ?, ?)";

		
			prep = connect.prepareStatement(query);
			
			prep.setString(1,entity.getSender());
			prep.setString(2,entity.getRecipient());
			prep.setString(3,entity.getSubject());
			prep.setString(4,entity.getMessage());
			
			result = prep.executeUpdate();
		
		return result;
	}
	//FetchSent
	public List<InsuranceEntityEmail> fetchSent() throws SQLException {
	    List<InsuranceEntityEmail> listProduct = new ArrayList<>();
	    System.out.println("Fetch data triggered");
	    String query = "SELECT * FROM emails order by timestamp_column desc";

	    state = connect.createStatement();
		resultset = state.executeQuery(query);
		
		InsuranceEntityEmail entity = null;
	        
	        while (resultset.next()) { 
	        	entity = new InsuranceEntityEmail();
	            entity.setSender(resultset.getString(1));
	            entity.setRecipient(resultset.getString(2));
	            entity.setSubject(resultset.getString(3));
	            entity.setMessage(resultset.getString(4));
	            entity.setTimestamp_column(resultset.getTimestamp(5));
	            listProduct.add(entity);
	        }        
//	        try {
//	            if (prep != null) prep.close();
//	            if (resultset != null) resultset.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }  
	    return listProduct;
	}

}
