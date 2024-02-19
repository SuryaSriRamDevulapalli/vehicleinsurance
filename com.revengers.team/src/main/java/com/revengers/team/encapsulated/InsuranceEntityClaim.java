package com.revengers.team.encapsulated;

public class InsuranceEntityClaim {
	
	private int claim_id;
	private int policy_no;
	private int customer_id;
	private String policy_type;
	private String damage_on;
	private int bill_amount;
	private int claim_amount;
	
	public int getClaim_id() {
		return claim_id;
	}
	public void setClaim_id(int claim_id) {
		this.claim_id = claim_id;
	}
	public int getClaim_amount() {
		return claim_amount;
	}
	public void setClaim_amount(int claim_amount) {
		this.claim_amount = claim_amount;
	}
	public int getPolicy_no() {
		return policy_no;
	}
	public void setPolicy_no(int policy_no) {
		this.policy_no = policy_no;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getPolicy_type() {
		return policy_type;
	}
	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}
	public String getDamage_on() {
		return damage_on;
	}
	public void setDamage_on(String damage_on) {
		this.damage_on = damage_on;
	}
	public int getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(int bill_amount) {
		this.bill_amount = bill_amount;
	}

}
