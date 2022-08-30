package com.trimdownclub.pages.upsells;

import com.trimdownclub.pages.BasePage;
import com.trimdownclub.pages.Purchases;
import com.trimdownclub.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsellPage2 extends Purchases {

	@FindBy(css = "div#main2-title-text")
	private WebElement productNameWE;

	@FindBy(css = "#purple-button b")
	private WebElement priceWE;

	@FindBy(css = "a.buy_now_link")
	private WebElement addToMyOrderBtn;


	@Override
	public void purchase(){
		BrowserUtils.waitForVisibility(addToMyOrderBtn,5);
		BrowserUtils.scrollToElement(addToMyOrderBtn);
		BrowserUtils.clickWithWait(addToMyOrderBtn,3);
	}

	@Override
	public void setIndividualPrice(){
		BrowserUtils.waitForVisibility(priceWE,3);
		BrowserUtils.scrollToElement(priceWE);
		this.price = priceWE.getText();
		System.out.println("price on upsell 2 is: " + price);
	}

	@Override
	public String getIndividualPrice(){
		System.out.println("price on upsell 2 is: " + price);
		return this.price;
	}

	@Override
	public void setIndividualProductName() {
		BrowserUtils.waitForVisibility(productNameWE,2);
		this.productName = productNameWE.getText();
	}

	@Override
	public String getIndividualProductName() {
		System.out.println("product name on upsell 2 is: " + productName);
		return this.productName;
	}
}
