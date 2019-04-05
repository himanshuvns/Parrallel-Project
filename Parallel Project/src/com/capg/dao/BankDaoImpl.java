package com.capg.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.capg.bean.Bank;
import com.capg.dao.BankDao;
import com.capg.bean.Transaction;

public class BankDaoImpl implements BankDao{
	static ArrayList<Bank> account = new ArrayList<Bank>();
	static List<Transaction> transaction = new ArrayList<Transaction>();
	Transaction t;
	
	static
	{
		account.add(new Bank(11503642l, "Himanhsu","Ajeet Singh", 9855843325l,"dsbjgluerk.gh  kadsfhaf  jkafdjuh",500.0 , "ankit"));
		transaction.add(new Transaction(123456L, "Deposit", new Date(), 2000.0));
		account.add(new Bank(11504494l, "Shashank","mayank", 45894158l,"dsbjgluerk.gh  kadsfhaf  jkafdjuh",880.0 , "sunny"));
		transaction.add(new Transaction(123459L, "Deposit", new Date(), 2000.0));
	}
	
	@Override
	public String createAccount(Bank b) {
		account.add(b);
		return "created";
	}

	@Override
	public Double showBalance(Long acc) {
		for(Bank b:account)
		{
			if(b.getAccountNo()==acc)
			{
				return b.getBalance();
			}
		}
		return null;
	}

	@Override
	public String deposit(Long acc,Double amount) {
		Double updateAmount =0.0;
		for(Bank a:account)
		{
			if(a.getAccountNo().equals(acc) && amount>0)
			{
				{
					t = new Transaction();
					t.setAccountId(acc);
					t.setAmount(amount);
					t.setD(new Date());
					t.setType("Deposit");
					transaction.add(t);
				}
				updateAmount =a.getBalance()+amount;
				return "success";
			}
		}
		return "invalid amount";
		
	}

	@Override
	public String withdraw(Long accountId, Double amount) {
		Double updateAmount =0.0;
		for(Bank a:account)
		{
			if(a.getAccountNo().equals(accountId));
			{
				if(a.getBalance()>=amount){
				{
					t = new Transaction();
					t.setAccountId(accountId);
					t.setAmount(amount);
					t.setD(new Date());
					t.setType("Withdraw");
					transaction.add(t);
				}
				updateAmount = a.getBalance()-amount;
				a.setBalance(updateAmount);
				return "success";
			}
			}
		}
		return "Insufficient amount";
		
	}

	@Override
	public String fundTransfer(Long accountId1, Long accountId2, Double amount) {
		synchronized(this)
		{
//				Transaction 
			t = new Transaction();
			t.setAccountId(accountId1);
			t.setAmount(amount);
			t.setD(new Date());
			t.setType("Fund Transfer Deposit");
			transaction.add(t);
			t = new Transaction();
			t.setAccountId(accountId2);
			t.setAmount(amount);
			t.setD(new Date());
			t.setType("Fund Transfer Deposit");
			transaction.add(t);
			String status=withdraw(accountId1, amount);
			transaction.remove(transaction.size()-1);
			if(status.equals("success"))
			{
				deposit(accountId2, amount);
				transaction.remove(transaction.size()-1);
				return "success";
			}
			else
			{
				return "Invalid Amount";
			}
		}
		
	}

	@Override
	public void printTransaction(Long accountId) {
		for(Transaction t: transaction)
		{
			{
				System.out.println(t);
			}
		}
		
	}
	
	public Boolean uniqueIds(Long id)
	{
		List<Long> uniqueId = account.stream().map((e)->e.getAccountNo()).collect(Collectors.toList());
		if(uniqueId.contains(id))
		{
			return true;
		}
		return false;
	}

}
