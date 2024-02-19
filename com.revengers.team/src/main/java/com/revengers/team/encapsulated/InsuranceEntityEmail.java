package com.revengers.team.encapsulated;

import java.sql.Timestamp;

public class InsuranceEntityEmail {
	
	private String sender;
	private String recipient;
	private String subject;
	private String message;
	private Timestamp timestamp_column;
	
	public Timestamp getTimestamp_column() {
		return timestamp_column;
	}
	public void setTimestamp_column(Timestamp timestamp_column) {
		this.timestamp_column = timestamp_column;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
