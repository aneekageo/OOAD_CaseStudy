package com.ilp.entity;

public class Account {

	private String accountNo;
	private String accountType;
	private double balance;
	private Product product;
	
	public Account(String accountNo, String accountType, double balance, Product product) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.balance = balance;
		this.setProduct(product);
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", balance=" + balance
				+ ", product=" + product + "]";
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getaccountType() {
		return accountType;
	}

	public void setaccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getbalance() {
		return balance;
	}

	public void setbalance(double balance) {
		this.balance = balance;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
