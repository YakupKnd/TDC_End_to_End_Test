package com.trimdownclub.pages.upsells;

import com.trimdownclub.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsellPage2 extends Upsells {

	@FindBy(css = "div#main2-title-text")
	private WebElement productNameWE;

	@FindBy(css = "#purple-button b")
	private WebElement priceWE;

	@FindBy(css = "a.buy_now_link")
	private WebElement addToMyOrderBtn;


	@Override
	public void purchaseFromUpsell(){
		BrowserUtils.waitForVisibility(addToMyOrderBtn,5);
		BrowserUtils.scrollToElement(addToMyOrderBtn);
		BrowserUtils.clickWithWait(addToMyOrderBtn,3);
	}

	@Override
	public void setPrice(){
		BrowserUtils.waitForVisibility(priceWE,3);
		BrowserUtils.scrollToElement(priceWE);
		this.price = priceWE.getText();
		System.out.println("price on upsell 2 is: " + price);
	}

	@Override
	public String getPrice(){
		System.out.println("price on upsell 2 is: " + price);
		return this.price;
	}

	@Override
	public void setProductName() {
		BrowserUtils.waitForVisibility(productNameWE,2);
		this.productName = productNameWE.getText();
		System.out.println("product name on upsell 2 is: " + productName);
	}

	@Override
	public String getProductName() {
		System.out.println("product name on upsell 2 is: " + productName);
		return this.productName;
	}
}
