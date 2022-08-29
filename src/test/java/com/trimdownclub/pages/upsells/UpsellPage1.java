package com.trimdownclub.pages.upsells;

import com.trimdownclub.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

public class UpsellPage1 extends  Upsells{

	@FindBy(css = "#brown-strip-top p")
	private WebElement productNameWE;

	@FindBy(css = "#purple-button b")
	private WebElement priceWE;

	@FindBy(css = "a.buy_now_link")
	private WebElement upgradeMyOrderBtn;


	public void purchaseFromUpsell(){
		BrowserUtils.waitForVisibility(upgradeMyOrderBtn,5);
		BrowserUtils.scrollToElement(upgradeMyOrderBtn);
		BrowserUtils.clickWithWait(upgradeMyOrderBtn,3);
	}

	public void setPrice(){
		BrowserUtils.waitForVisibility(priceWE,3);
		BrowserUtils.scrollToElement(priceWE);
		this.price = priceWE.getText();
		System.out.println("price on upsell 1 is: " + price);
	}

	public String getPrice(){
		System.out.println("price on upsell 1 is: " + price);
		return this.price;
	}


	@Override
	public void setProductName() {
		BrowserUtils.waitForVisibility(productNameWE,2);
		this.productName = productNameWE.getText();
		System.out.println("product name on upsell 1 is: " + productName);
	}

	@Override
	public String getProductName() {
		System.out.println("product name on upsell 1 is: " + productName);
		return this.productName;
	}

}
