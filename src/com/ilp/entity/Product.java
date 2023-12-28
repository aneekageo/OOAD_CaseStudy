package com.ilp.entity;
import java.util.ArrayList;

public abstract class Product {
	private String productCode;
	private String productName;
	ArrayList<Services> Service=new ArrayList<Services>();
	
	public ArrayList<Services> getService() {
		return Service;
	}

	public void setService(ArrayList<Services> service) {
		Service = service;
	}

	public Product(String productCode, String productName, ArrayList<Services> Service) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.Service = Service;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
