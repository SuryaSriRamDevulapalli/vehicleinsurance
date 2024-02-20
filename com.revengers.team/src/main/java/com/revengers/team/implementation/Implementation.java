package com.revengers.team.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.revengers.team.encapsulated.InsuranceEntity;
import com.revengers.team.encapsulated.InsuranceEntityClaim;
import com.revengers.team.jdbc.JDBC;


public class Implementation {
	
	Connection connect;
	PreparedStatement prep;
	ResultSet resultset;
	Statement state;
	private InsuranceEntity insuranceEntity;
    private InsuranceEntityClaim insuranceEntityClaim;
    
    public Implementation(InsuranceEntity insuranceEntity, InsuranceEntityClaim insuranceEntityClaim) {
        this.insuranceEntity = insuranceEntity;
        this.insuranceEntityClaim = insuranceEntityClaim;
    }
    public InsuranceEntity getInsuranceEntity() {
        return insuranceEntity;
    }
    public InsuranceEntityClaim getInsuranceEntityClaim() {
        return insuranceEntityClaim;
    }
	public Implementation() {
		connect = JDBC.getinstance();
	}	
	//enrollment
	public int Enrollment(InsuranceEntity entity) throws SQLException {
		int result = 0;
		System.out.println("Enrollemnt method triggered");
		
		String policy_type = entity.getPolicy_type();
		int price = pricepolicy(policy_type);
		
		String query = "insert into enrollment (policy_no, vehicle_name, variant, vehicle_no, policy_type, customer_id, price, name, email, number, pincode, fuel_type) values (?,?,?,?,?,?,?,?,?,?,?,?)";

		prep = connect.prepareStatement(query);
		prep.setInt(1, Randomgen.PolicyNo());
		prep.setString(2, entity.getVehicle_name());
		prep.setString(3, entity.getVariant());
		prep.setString(4, entity.getVehicle_no());
		prep.setString(5, entity.getPolicy_type());
		prep.setInt(6, Randomgen.Customerid());
		prep.setInt(7, price);
		prep.setString(8, entity.getName());
		prep.setString(9, entity.getEmail());
		prep.setString(10, entity.getNumber());
		prep.setInt(11, entity.getPincode());
		prep.setString(12, entity.getFuel_type());
		result = prep.executeUpdate();
		
		return result;	
	}
	
	private static int pricepolicy(String policy_type) {
	    if (policy_type.equalsIgnoreCase("Comprehensive")) {
	        return 5600;
	    } else {
	        return 4500; 
	    } 
	}

	
	public int PolicyNumberDB() throws SQLException {
	    String query = "SELECT policy_no FROM enrollment ORDER BY timestamp_column DESC LIMIT 1";
        prep = connect.prepareStatement(query);
        resultset = prep.executeQuery();
        if (resultset.next()) {
            return resultset.getInt("policy_no");
        } else {
            return 0;
        }
    }

    public int CustomerIDDB() throws SQLException {
        String query = "SELECT customer_id FROM enrollment ORDER BY timestamp_column DESC LIMIT 1";
        prep = connect.prepareStatement(query);
        resultset = prep.executeQuery();
        if (resultset.next()) {
            return resultset.getInt("customer_id");
        } else {
            return 0;
        }
    }
    
    public int priceDB() throws SQLException {
    	String query = "SELECT price FROM enrollment ORDER BY timestamp_column DESC LIMIT 1";
        prep = connect.prepareStatement(query);
        resultset = prep.executeQuery();
        if (resultset.next()) {
            return resultset.getInt("price");
        } else {
            return 0;
        }
    }
    //claim
    public int ClaimStatus(InsuranceEntityClaim entity) throws SQLException {
		int result = 0;
		System.out.println("ClaimStatus method triggered");
		
		 int claimAmount = ClaimAmount(entity);
	
		String query = "INSERT INTO claim (policy_no, customer_id, policy_type, damage_on, bill_amount, claim_amount) VALUES (?, ?, ?, ?, ?, ?)";

		prep = connect.prepareStatement(query);
		prep.setInt(1, entity.getPolicy_no());
		prep.setInt(2, entity.getCustomer_id());
		prep.setString(3, entity.getPolicy_type());
		prep.setString(4, entity.getDamage_on());
		prep.setInt(5,entity.getBill_amount());
		prep.setInt(6, claimAmount);
		result = prep.executeUpdate();
		
		return result;	
	}
    
    public int ClaimAmount(InsuranceEntityClaim entity) {
        int billAmount = entity.getBill_amount();
        String damageOn = entity.getDamage_on();
        int claimAmount = 0;

        if (damageOn.equalsIgnoreCase("metal")) {
            claimAmount = (int) (billAmount * 0.85); 
        } else if (damageOn.equalsIgnoreCase("plastic")) {
            claimAmount = billAmount / 2;
        } 
        return claimAmount;
    }
	//read
    public Implementation SearchCustID(int fEcustomer_id) throws SQLException {
        InsuranceEntity entity = null;
        InsuranceEntityClaim entityClaim = null;
        System.out.println("Implementation class Triggered");

        String query = "SELECT e.policy_no, e.vehicle_name, e.variant, e.vehicle_no, e.policy_type, e.customer_id, e.price, e.name, e.email, e.number, e.pincode, e.fuel_type, e.timestamp_column, c.claim_id, c.damage_on, c.bill_amount, c.claim_amount FROM enrollment e JOIN claim c ON e.policy_no = c.policy_no WHERE e.customer_id = ?";
        prep = connect.prepareStatement(query);
        prep.setInt(1, fEcustomer_id);
        resultset = prep.executeQuery();

        while (resultset.next()) {
            entity = new InsuranceEntity(); // Initializing the object to avoid null pointer exception
            entity.setPolicy_no(resultset.getInt(1));
            entity.setVehicle_name(resultset.getString(2));
            entity.setVariant(resultset.getString(3));
            entity.setVehicle_no(resultset.getString(4));
            entity.setPolicy_type(resultset.getString(5));
            entity.setCustomer_id(resultset.getInt(6));
            entity.setPrice(resultset.getInt(7));
            entity.setName(resultset.getString(8));
            entity.setEmail(resultset.getString(9));
            entity.setNumber(resultset.getString(10));
            entity.setPincode(resultset.getInt(11));
            entity.setFuel_type(resultset.getString(12));
            entity.setTimestamp_column(resultset.getTimestamp(13));

            entityClaim = new InsuranceEntityClaim();
            entityClaim.setClaim_id(resultset.getInt(14));
            entityClaim.setDamage_on(resultset.getString(15));
            entityClaim.setBill_amount(resultset.getInt(16));
            entityClaim.setClaim_amount(resultset.getInt(17));
        }

        Implementation imp = new Implementation(entity, entityClaim);
        return imp;
    }

}


