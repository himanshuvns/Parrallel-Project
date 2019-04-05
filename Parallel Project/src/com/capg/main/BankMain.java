package com.capg.main;
import java.util.Scanner;

import com.capg.bean.Bank;
import com.capg.service.BankService;
import com.capg.service.BankServiceImpl;

public class BankMain {

	public static void main(String[] args) {
		BankServiceImpl bsi;
		Bank b;
		int choice;
		System.out.println("Enter 1 for creating a bank account.");
		System.out.println("Enter 2 for log in");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			b = new Bank();
			bsi = new BankServiceImpl();
			System.out.println("Enter Account holder name:");
			String accHolderName = sc.nextLine();
			accHolderName = sc.nextLine();
			b.setAccHolderName(accHolderName);
			System.out.println("Enter Father name:");
			String fatherName = sc.nextLine();
			b.setFatherName(fatherName);
			System.out.println("Enter mobile no:");
			Long mobileNo = sc.nextLong();
			b.setMobileNo(mobileNo);
			System.out.println("Enter address (minimum word 20):");
			String address = sc.nextLine();
			address = sc.nextLine();
			b.setAddress(address);
			System.out.println("Enter password:");
			String password = sc.nextLine();
			System.out.println("Enter password to confirm:");
			String ConfirmPassword = sc.nextLine();
			if(bsi.validatePassword(password,ConfirmPassword))
			{
				b.setPassword(password);
			}
			else
			{
				System.out.println("Password Mismatch");
			}
			System.out.println(bsi.createAccount(b));
			break;
			
		case 2:
			b = new Bank();
			System.out.println("Enter Account number:");
			Long accountNo = sc.nextLong();
			b.setAccountNo(accountNo);
			System.out.println("Enter Password:");
			String pass = sc.next();
			b.setPassword(pass);
			bsi = new BankServiceImpl();
			bsi.validateAccount(b);
			System.out.println("Enter 1 for showing balance.");
			System.out.println("Enter 2 for deposit money into account.");
			System.out.println("Enter 3 for withdrawl money from account.");
			System.out.println("Enter 4 for fund transfer into other account.");
			System.out.println("Enter 5 for printing account transactions.");
			System.out.println("Enter 6 for exit");
			int choice1 = sc.nextInt();
			switch(choice1)
			{
			case 1:
				bsi = new BankServiceImpl();
				System.out.println(bsi.showBalance(accountNo));
				break;
			case 2:
				System.out.println("Enter the account to deposit");
				Double amount=sc.nextDouble();
				bsi.deposit(accountNo, amount);
				System.out.println("Updated balance " + bsi.showBalance(accountNo));
				break;
			case 3:
				System.out.println("Enter the account to withdraw");
				Double amountWith = sc.nextDouble();
				bsi.withdraw(accountNo, amountWith);
				System.out.println("Updated balance " + bsi.showBalance(accountNo));
				break;
			case 4:
				System.out.println("Enter the Account No to which you want to transfer the amount");
				Long id2 = sc.nextLong();
				if(bsi.checkUniqueId(id2) && !accountNo.equals(id2))
				{
					System.out.println("Enter the amount to get transfered");
					Double amt = sc.nextDouble();
					System.out.println(bsi.fundTransfer(accountNo, id2, amt));
					System.out.println("Updated balance " + bsi.showBalance(accountNo));
				}
				else
				{
					System.out.println("Invalid");
				}
				break;
			case 5:
				bsi.printTransaction(accountNo);
				break;
			case 6:
				System.exit(0);
			}
			
		default:
			System.out.println("Invalid command");
			
		}
		
	}

}
