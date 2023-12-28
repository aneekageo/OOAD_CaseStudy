package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product {

public double getMinBalance() {
	return minBalance;
}

public void setMinBalance(double minBalance) {
	this.minBalance = minBalance;
}

private double minBalance;

public SavingsMaxAccount(String productCode, String productName, ArrayList<Services> Service, double minBalance) {
	super(productCode, productName, Service);
	this.minBalance = minBalance;
}


}
