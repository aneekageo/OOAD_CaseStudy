package com.ilp.service;

import java.util.ArrayList;

import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;

public class CustomerServices {

	public static Customer createCustomer(ArrayList<Product> productList) {
		int length = productList.size();
		ArrayList<Account> accountList = new ArrayList<Account>();
		Scanner scanner = new Scanner(System.in);
		Customer customer = null;
		if (length > 0) {
			System.out.println("Enter customer code:");
			String customerCode = scanner.nextLine();
			System.out.println("Enter customer name:");
			String customerName = scanner.nextLine();
			accountList = AccountService.createAccount(productList);
			customer = new Customer(customerCode, customerName, accountList);
			System.out.println(customer.getCustomerName() + " has created " + accountList.get(0).getaccountType());
			System.out.println("Your account is ACTIVE!!!");
			System.out.println("Your available services are:");
			ArrayList<Services> serviceList = accountList.get(0).getProduct().getService();
			for (Services service : serviceList) {
				System.out.println(service.getServiceName());
			}

			for (Account accountService : accountList) {
				System.out.println("Account list is : " + accountService.toString());
			}

		} else {
			System.out.println("Account cannot be created,create a product!!");
		}
		return customer;
	}

	public static void manageCustomer(Customer customer) {
		if (customer == null) {
			System.out.println("You do not have any accounts,create account!!");
			return;
		}
		ArrayList<Account> accountList = customer.getAccountList();
		System.out.println("Hey " + customer.getCustomerName() + " !");

		System.out.println("Your accounts are:");
		int i = 1;
		int ch;

		for (Account account : customer.getAccountList()) {
			System.out.println(i + "." + account.getAccountNo() + "-" + account.getaccountType());
		}
		do {
			System.out.println("Enter your preferred account to perform services:");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			Account preferredAccount = accountList.get(choice - 1);
			AccountService.manageAccount(preferredAccount);
			System.out.println("Do you want to perform more services?(yes=1,no = 0)");
			ch = scanner.nextInt();
		} while (ch == 0);
		return;
	}

	public static void displayCustomerDetails(Customer customer) {
		System.out.println("*************************Customer-Account Details****************");
		System.out.println("CustomerId\t\tCustomerName\t\tAccountType\t\tBalance");
		System.out.println("***************************************************************");
		ArrayList<Account> accountList = customer.getAccountList();
		ArrayList<Services> serviceList;
		for (Account account : accountList) {
			System.out.println(customer.getCustomerCode() + "\t\t" + customer.getCustomerName() + "  \t\t"
					+ account.getaccountType() + "  \t\t" + account.getbalance());
			serviceList = account.getProduct().getService();
			System.out.println("Your Services");
			for (Services service : serviceList) {
				System.out.println(service.getServiceName());
			}
		}

	}
}
