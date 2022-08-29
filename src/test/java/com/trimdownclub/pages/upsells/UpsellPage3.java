package com.trimdownclub.pages.upsells;

import com.trimdownclub.pages.BasePage;
import com.trimdownclub.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsellPage3 extends Upsells {

	@FindBy(css = "span.boldNbig")
	private WebElement productNameWE;

	@FindBy(css = "div#smallorangeWrapper b:nth-of-type(2)")
	private WebElement priceUpsell3WE;

	@FindBy(css = "a.wc_1cu_custom_offer_accept")
	private WebElement upgradeMyOrderBtn;



	@Override
	public void purchaseFromUpsell(){
		BrowserUtils.waitForVisibility(upgradeMyOrderBtn,5);
		BrowserUtils.scrollToElement(upgradeMyOrderBtn);
		BrowserUtils.clickWithWait(upgradeMyOrderBtn,3);
	}

	@Override
	public void setPrice(){
		BrowserUtils.waitForVisibility(priceUpsell3WE,3);
		BrowserUtils.scrollToElement(priceUpsell3WE);
		this.price = priceUpsell3WE.getText();
		System.out.println("price on upsell 3 is: " + price);
	}

	@Override
	public String getPrice(){
		System.out.println("price on upsell 3 is: " + price);
		return this.price;
	}


	@Override
	public void setProductName() {
		BrowserUtils.waitForVisibility(productNameWE,2);
		this.productName = productNameWE.getText();
		System.out.println("product name on upsell 3 is: " + productName);
	}

	@Override
	public String getProductName() {
		System.out.println("product name on upsell 3 is: " + productName);
		return this.productName;
	}

}
