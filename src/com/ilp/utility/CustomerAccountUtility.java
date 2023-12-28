package com.ilp.utility;

import java.util.ArrayList;

import java.util.Scanner;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.service.CustomerServices;
import com.ilp.service.ProductServices;

public class CustomerAccountUtility {

	public static void main(String[] args) {
		ArrayList<Services> serviceList = new ArrayList<Services>();
		ArrayList<Product> productList=new ArrayList<Product>();
		int loopChoice = 1;
		Customer customer = null;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("******Welcome To Bank************");
			System.out.println(" 1.Create Service \n 2.Create Product \n 3.Create Customer \n 4.Manage Accounts \n 5.Display Customer \n 6.Exit");
			int mainMenuChoice = scanner.nextInt();
			
			switch (mainMenuChoice) {
			case 1:
				serviceList = ProductServices.createServices(serviceList);
				break;
			case 2:
				productList = ProductServices.createProduct(productList, serviceList);
				break;
			case 3:
				customer=CustomerServices.createCustomer(productList);
				break;
			case 4:
				CustomerServices.manageCustomer(customer);
				break;
			case 5:CustomerServices.displayCustomerDetails(customer);
			break;
			case 6:System.out.println("Exited Successfully");
				break;
			}
			System.out.println("Do you want to return to main menu (yes=1,no = 0)");
			loopChoice = scanner.nextInt();

		} while (loopChoice == 1);
	}

}
