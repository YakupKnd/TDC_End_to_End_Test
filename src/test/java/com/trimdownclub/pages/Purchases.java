package com.trimdownclub.pages;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Purchases extends BasePage{
	protected String price;
	protected String productName;

	protected static BigDecimal totalPrice = new BigDecimal(0);
	protected static List<String> allProducts = new ArrayList<>();

	public abstract void purchase();

	public abstract void setIndividualPrice();

	public String getIndividualPrice(){
		System.out.println("price on funnel is: " + price);
		return this.price;
	}

	public abstract void setIndividualProductName();

	public String getIndividualProductName(){
		System.out.println("product name is: " + productName);
		return this.productName;
	}

	public void addToTotalPrice() {
		String priceAsDecimal = null;

		try {
			priceAsDecimal = price.replace("$", "");
		} catch (Exception e) {
		}

		totalPrice = totalPrice.add(new BigDecimal(priceAsDecimal));
	}

	public BigDecimal getTotalPrice(){
		System.out.println("total price is: " + totalPrice);
		return totalPrice;
	}

	public void addToAllProducts() {
		allProducts.add(productName);
	}

	public List<String> getAllProducts(){
		return allProducts;
	}

}
