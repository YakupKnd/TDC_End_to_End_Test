package com.trimdownclub.pages;

import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ThankYouPage extends BasePage {

	private BigDecimal totalPrice;
	private List<String> allProducts;

	@FindBy(css = "input#acceptBtn")
	private WebElement greenOkBtn;

	@FindBy(css = "input[value='Access Digital Product']")
	private List<WebElement> allAccessDigitalProductButtons;

	@FindBy(css = "div.pricingInfo p[id^='productPrice']")
	private List<WebElement> allProductPricesWE;

	@FindBy(css = "h3[id^='productTitle']")
	private List<WebElement> allProductNamesWE;


	public void clickGreenOkBtn() {
		BrowserUtils.clickWithWait(greenOkBtn, 2);
	}

	public List<String> getAllProductNames() {
		return this.allProducts;
	}

	public void setAllProductNames(){
		this.allProducts = BrowserUtils.getTextAsList(allProductNamesWE);
	}

	public void setActualTotalPrice() {
		totalPrice = new BigDecimal("0");

		for (int i = 0; i < allProductPricesWE.size(); i++) {
			totalPrice = totalPrice.add(new BigDecimal(allProductPricesWE.get(i).getText().replace("$", "")));
		}
	}

	public BigDecimal getActualTotalPrice() {
		setActualTotalPrice();
		return totalPrice;
	}

	public void goToDigitalProducts() {
		allAccessDigitalProductButtons.get(0).click();
	}

}
