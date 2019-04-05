package com.capg.bean;

public class Bank {
	private Long AccountNo;
	private String AccHolderName;
	private String FatherName;
	private Long MobileNo;
	private double Balance;
	private String Password;
	private String Address;
	public Bank()
	{
		super();
	}
	public Bank(Long accountNo, String accHolderName,String fatherName, Long mobileNo,String address, double balance, String password) {
		super();
		AccountNo = accountNo;
		AccHolderName = accHolderName;
		MobileNo = mobileNo;
		Balance = balance;
		Password = password;
		FatherName = fatherName;
		Address = address;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Long getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(Long accountNo) {
		AccountNo = accountNo;
	}
	public String getAccHolderName() {
		return AccHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		AccHolderName = accHolderName;
	}
	public Long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		MobileNo = mobileNo;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFatherName()
	{
		return FatherName;
	}
	public void setFatherName(String fatherName)
	{
		FatherName = fatherName;
	}
	
}
