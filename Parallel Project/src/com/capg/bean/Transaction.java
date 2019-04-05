package com.capg.bean;

import java.util.Date;

public class Transaction {
	Long accountId;
	String type;
	Date d;
	Double amount;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public Transaction() {
		super();
	}
	public Transaction(Long accountId, String type, Date d, Double amount) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.d = d;
		this.amount =amount;
	}
	@Override
	public String toString() {
		return  accountId + " " + d + " " + type  + " " + amount;
	}
		
}

