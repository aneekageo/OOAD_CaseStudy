package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;

public class AccountService {
	public static ArrayList<Account> createAccount(ArrayList<Product> productList) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		ArrayList<Account> accountList = new ArrayList<Account>();
		do {
		System.out.println("Enter Account Number:");
		String accNumber = scanner.nextLine();
		System.out.println("Enter Account Type:");
		String accType = scanner.nextLine();
		int i = 0;
		for (Product product : productList) {
			i++;
			System.out.println(i + "." + product.getProductName());
		}
		System.out.println("Enter which product:");
		int productIndex = scanner.nextInt();

		int flag = 1;
		Product product = productList.get(productIndex - 1);
		Double balance = 0.0;
		do {
			System.out.println("Enter Balance:");
			balance = scanner.nextDouble();

			if (product instanceof SavingsMaxAccount) {
				SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) product;
				Double minbalance = savingsMaxAccount.getMinBalance();
				if (balance < minbalance) {
					System.out.println("Insufficient Balance");
					flag = 0;
				}
				else {
					flag=1;
				}

			}
		} while (flag == 0);
		Account account = new Account(accNumber, accType, balance, product);
		accountList.add(account);
		System.out.println("Do you want to add more accounts?(1 for yes/0 for no)");
		choice=scanner.nextInt();
		}while(choice==1);
		return accountList;
	}

	public static void manageAccount(Account preferredAccount) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1.Deposit Amount \n2.Withdraw Amount \n3.View Balance");
			int serviceChoice = scanner.nextInt();
			switch (serviceChoice) {
			case 1:
				depositAmount(preferredAccount);
				break;
			case 2:
				withdrawAmount(preferredAccount);
				break;
			case 3:
				viewBalance(preferredAccount);
				break;
			}
			System.out.println("Do you want to perform more services??(1 for YES/0 for NO)");
			choice = scanner.nextInt();
		} while (choice == 1);

	}

	private static void depositAmount(Account account) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Product newProduct = account.getProduct();
		if (newProduct instanceof LoanAccount) {
			System.out.println("How do you want to deposit?\n1.Cash Deposit\n2.Cheque Deposit");
			int depositChoice = scanner.nextInt();
			System.out.println("Enter amount to be deposited:");
			double depositAmount = scanner.nextDouble();
			double balance;
			switch (depositChoice) {
			case 1:
				balance = depositAmount + account.getbalance();
				account.setbalance(balance);

			case 2:
				balance = (depositAmount - (0.003 * depositAmount) + account.getbalance());
				account.setbalance(balance);
			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Your current account balance:Rs." + account.getbalance());
		} else {
			System.out.println("Enter amount to be deposited:");
			int depositAmount = scanner.nextInt();
			double balance = depositAmount + account.getbalance();
			account.setbalance(balance);
			System.out.println("Your current account balance:Rs." + account.getbalance());
		}
	}

	private static void withdrawAmount(Account account) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter amount to be withdrawn:");
		int withdrawAmount = scanner.nextInt();
		double newBalance = account.getbalance() - withdrawAmount;
		account.setbalance(newBalance);
		Product newProduct = account.getProduct();
		if (newProduct instanceof SavingsMaxAccount) {
			if (newBalance < 1000) {
				System.out.println(
						"Sorry,a minimum of Rs.1000 is to be maintained in account! \n!!Withdrawal UNSUCCESSFUL!!");
			} else {
				System.out.println("!!Withdrawal SUCCESSFUL!!");
				System.out.println("New balance is:" + newBalance);
			}
		} else {
			System.out.println("New balance is:" + newBalance);
		}
	}

	private static void viewBalance(Account account) {
		// TODO Auto-generated method stub
		System.out.println("Account number:" + account.getAccountNo() + "\nAccount Type:" + account.getaccountType());
		System.out.println("Your current balance is:" + account.getbalance());
	}

}
