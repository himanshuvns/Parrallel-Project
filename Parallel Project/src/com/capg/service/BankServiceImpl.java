package com.capg.service;
import com.capg.bean.Bank;
import com.capg.service.BankService;
import com.capg.dao.BankDao;
import com.capg.dao.BankDaoImpl;

public class BankServiceImpl implements BankService{
	BankDaoImpl bdao;
	@Override
	public String createAccount(Bank b) {
		bdao = new BankDaoImpl();
		String str = b.getMobileNo()+" ";
		if(b.getAccHolderName().length()<=6)
		{
			return "account holder name should have length more than 6 character.";
		}
		else if(b.getFatherName().length()<=6)
		{
			return "father name should have length more than 6 character.";
		}
		else if(str.length()<10)
		{
			return "Mobile number should have 10 digits";
		}
		else if(b.getAddress().length()<20)
		{
			return "Address should have length more than 20 character.";
		}
		else 
		{
			 b.setAccountNo((long)( Math.random()*99999999));
			String str1 =  bdao.createAccount(b);
			if(str1.equalsIgnoreCase("Created"))
			{
				str1 = "Name:"+b.getAccHolderName()+"\t"+"Account Id:"+b.getAccountNo();
			}
			 return str1;
			 
		}
	}

	@Override
	public Double showBalance(Long acc) {
		bdao = new BankDaoImpl();
		return bdao.showBalance(acc);
		
	}

	@Override
	public String deposit(Long acc,Double bal) {
		if(bal>0)
		{
			bdao=new BankDaoImpl();
			bdao.deposit(acc, bal);
		}
		
		return "success";
		
	}

	@Override
	public String withdraw(Long accountId, Double amount) {
		if(amount>0)
		{
			bdao=new BankDaoImpl();
			return bdao.withdraw(accountId, amount);
		}
		return "Invalid Amount";
		
	}

	@Override
	public String fundTransfer(Long accountId1, Long accountId2, Double amount) {
		bdao = new BankDaoImpl();
		if(amount>0)
		{
			return bdao.fundTransfer(accountId1, accountId2, amount);
		}
		return "Invalid amount";
		
	}

	@Override
	public void printTransaction(Long accountId) {
		bdao.printTransaction(accountId);
		
	}


	public boolean validatePassword(String pass,String repass) {
		if(pass.equals(repass))
		{
			return true;
		}
		else 
			return false;
	}


	public boolean validateAccount(Bank b) {
		if(b.getAccountNo()<8)
		{
			return false;
		}
		else if(b.getPassword().length()<6)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean checkUniqueId(Long rand) {
		// TODO Auto-generated method stub
		bdao = new BankDaoImpl();
		boolean flag=bdao.uniqueIds(rand);
		return flag;
	}

}
