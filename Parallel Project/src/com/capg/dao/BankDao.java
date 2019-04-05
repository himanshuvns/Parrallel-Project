package com.capg.dao;
import com.capg.bean.Bank;

public interface BankDao {

	public String createAccount(Bank b);
	public Double showBalance(Long acc);
	public String deposit(Long acc,Double amount);
	public String withdraw(Long accountId, Double amount);
	public String fundTransfer(Long accountId1, Long accountId2, Double amount);
	public void printTransaction(Long accountId);
}
