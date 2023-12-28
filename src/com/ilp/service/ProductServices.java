package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class ProductServices {

	public static ArrayList<Services> createServices(ArrayList<Services> serviceList) {
		int loopChoice = 1;
		String servCode;
		Double servRate;
		Scanner scanner = new Scanner(System.in);
		do {
			Services service = null;
			System.out.println(
					"Which Service you prefer?\n1.Cash Deposit \n2.ATM Withdrawl \n3.Online Banking\n4.Mobile Banking\n5.Cheque Deposit");
			int serviceChoice = scanner.nextInt();
			switch (serviceChoice) {
			case 1:
				System.out.println("Enter Service Code:");
				servCode = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter Rate:");
				servRate = scanner.nextDouble();
				service = new Services("Cash Deposit", servCode, servRate);
//		 System.out.println(service.getServiceName());
				serviceList.addLast(service);
				break;
			case 2:
				System.out.println("Enter Service Code:");
				servCode = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter Rate:");
				servRate = scanner.nextDouble();
				service = new Services("ATM Withdrawal", servCode, servRate);
				serviceList.add(service);
				break;
			case 3:
				System.out.println("Enter Service Code:");
				servCode = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter Rate:");
				servRate = scanner.nextDouble();
				service = new Services("Online Banking", servCode, servRate);
				serviceList.add(service);
				break;
			case 4:
				System.out.println("Enter Service Code:");
				servCode = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter Rate:");
				servRate = scanner.nextDouble();
				service = new Services("Mobile Banking", servCode, servRate);
				serviceList.add(service);
				break;
			case 5:
				System.out.println("Enter Service Code:");
				servCode = scanner.nextLine();
				scanner.nextLine();
				System.out.println("Enter Rate:");
				servRate = scanner.nextDouble();
				service = new Services("Cheque Deposit", servCode, servRate);
				serviceList.add(service);
				break;
			}
			System.out.println("Do you want to add more services?(Yes=1, No= 0)");
			loopChoice = scanner.nextInt();
		} while (loopChoice == 1);
		return serviceList;
	}

	public static ArrayList<Product> createProduct(ArrayList<Product> productList, ArrayList<Services> serviceList) {
		int loopChoice = 1;
		String productCode;
		int length = serviceList.size();
		ArrayList<Services> newServiceList = new ArrayList<Services>();
		Scanner scanner = new Scanner(System.in);
		if (length > 0) {
			do {
				System.out.println(
						"Which type of account?\n 1.Savings Max Account \t \t 2.Current Account \t \t 3.Loan Account");
				int productChoice = scanner.nextInt();
				switch (productChoice) {
				case 1:

					System.out.println("Enter Product code:");
					productCode = scanner.nextLine();
					newServiceList = addServices(serviceList);
					double minBalance = 1000;

					SavingsMaxAccount smaproduct = new SavingsMaxAccount(productCode, "Savings Max Account",
							newServiceList, minBalance);
					productList.add(smaproduct);
					break;
				case 2:
					System.out.println("Enter Product code:");
					productCode = scanner.nextLine();

					newServiceList = addServices(serviceList);
					CurrentAccount caproduct = new CurrentAccount(productCode, "Current Account", newServiceList);
					productList.add(caproduct);
					break;
				case 3:
					System.out.println("Enter Product code:");
					productCode = scanner.nextLine();

					newServiceList = addServices(serviceList);
					double chequeDeposit = 0.003;
					LoanAccount laproduct = new LoanAccount(productCode, "Loan Account", newServiceList, chequeDeposit);
					productList.add(laproduct);
					break;
				}

				System.out.println("Do you want to add more products?(Yes=1, No= 0)");
				loopChoice = scanner.nextInt();
			} while (loopChoice == 1);
			return productList;
		} else {
			System.out.println("No Services are available");
			return productList;
		}
	}

	private static ArrayList<Services> addServices(ArrayList<Services> serviceList) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Services> newServiceList = new ArrayList<Services>();

		int i = 0;
		for (Services service : serviceList) {
			i++;
			System.out.println(i + "." + service.getServiceName());
		}
		
		int loopChoice;
		do {
			System.out.println("Enter the service to add:");
			int serviceChoice = scanner.nextInt();
			newServiceList.add(serviceList.get(serviceChoice - 1));
			scanner.nextLine();
			System.out.println("Do you want to add more services?(Yes=1, No= 0)");
			loopChoice = scanner.nextInt();
		} while (loopChoice == 1);

		return newServiceList;
	}
}
