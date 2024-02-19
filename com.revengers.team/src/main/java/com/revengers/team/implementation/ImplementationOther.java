package com.revengers.team.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revengers.team.encapsulated.ALEntity;
import com.revengers.team.encapsulated.Entity;
import com.revengers.team.encapsulated.LIEntity;
import com.revengers.team.jdbc.JDBC;

public class ImplementationOther {
	
	Connection connect;
	PreparedStatement prep;
	ResultSet resultset;
	Statement state;
	
	public ImplementationOther() {
		connect = JDBC.getinstance();
	}
	//create 
	public int Insertmethod(Entity entity) {
		int result = 0;
		String query = "insert into mi values(?,?,?,?,?,?)";
		
		try {
			prep = connect.prepareStatement(query);
			prep.setInt(1, entity.getSNo());
			prep.setString(2, entity.getName());
			prep.setInt(3, entity.getAge());
			prep.setString(4, entity.getPolicyNo());
            prep.setString(5, entity.getStartDate());
			prep.setString(6, entity.getEndDate());
			result = prep.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//fetch(search all)

	public List<Entity>Fetch(){
		List<Entity> listproduct = new ArrayList<Entity>();
		String query = "select * from mi";
		try {
			state=connect.createStatement();
			resultset=state.executeQuery(query);
			Entity enrol=null;
			while(resultset.next()) {
				enrol = new Entity();
				enrol.setSNo(resultset.getInt(1));
				enrol.setName(resultset.getString(2));
				enrol.setAge(resultset.getInt(3));
				enrol.setPolicyNo(resultset.getString(4));
				enrol.setStartDate(resultset.getString(5));
				enrol.setEndDate(resultset.getString(6));
				listproduct.add(enrol);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return listproduct;
	}
	
	
	//AirLine Insurance
	
	//create 
	public int Insertmethod2(ALEntity entity) {                   //ALEntity
		int result = 0;
		String query = "insert into Ai values(?,?,?,?,?,?)";
		
		try {
			prep = connect.prepareStatement(query);
			prep.setInt(1, entity.getSNo());
			prep.setString(2, entity.getName());
			prep.setInt(3, entity.getAge());
			prep.setString(4, entity.getPolicyNo());
            prep.setString(5, entity.getStartDate());
			prep.setString(6, entity.getEndDate());
			result = prep.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//fetch(search all)

	public List<ALEntity>ALFetch(){
		List<ALEntity> listproduct = new ArrayList<ALEntity>();
		String query = "select * from Ai";
		try {
			state=connect.createStatement();
			resultset=state.executeQuery(query);
			ALEntity enrol=null;
			while(resultset.next()) {
				enrol = new ALEntity();
				enrol.setSNo(resultset.getInt(1));
				enrol.setName(resultset.getString(2));
				enrol.setAge(resultset.getInt(3));
				enrol.setPolicyNo(resultset.getString(4));
				enrol.setStartDate(resultset.getString(5));
				enrol.setEndDate(resultset.getString(6));
				listproduct.add(enrol);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return listproduct;
	}
	
	
	//Life Insurance
	
		//create 
		public int Insertmethod3(LIEntity entity) {                   //LIEntity
			int result = 0;
			String query = "insert into Li values(?,?,?,?,?,?)";
			
			try {
				prep = connect.prepareStatement(query);
				prep.setInt(1, entity.getSNo());
				prep.setString(2, entity.getName());
				prep.setInt(3, entity.getAge());
				prep.setString(4, entity.getPolicyNo());
	            prep.setString(5, entity.getStartDate());
				prep.setString(6, entity.getEndDate());
				result = prep.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
		
		//fetch(search all)

		public List<LIEntity>LIFetch(){
			List<LIEntity> listproduct = new ArrayList<LIEntity>();
			String query = "select * from Li";
			try {
				state=connect.createStatement();
				resultset=state.executeQuery(query);
				LIEntity enrol=null;
				while(resultset.next()) {
					enrol = new LIEntity();
					enrol.setSNo(resultset.getInt(1));
					enrol.setName(resultset.getString(2));
					enrol.setAge(resultset.getInt(3));
					enrol.setPolicyNo(resultset.getString(4));
					enrol.setStartDate(resultset.getString(5));
					enrol.setEndDate(resultset.getString(6));
					listproduct.add(enrol);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			return listproduct;
		}
	
}
