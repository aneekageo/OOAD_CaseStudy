package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {

	public double getChequeDeposit() {
		return chequeDeposit;
	}

	public void setChequeDeposit(double chequeDeposit) {
		this.chequeDeposit = chequeDeposit;
	}

	private double chequeDeposit;

	public LoanAccount(String productCode, String productName, ArrayList<Services> Service, double chequeDeposit) {
		super(productCode, productName, Service);
		this.chequeDeposit = chequeDeposit;
	}

}
