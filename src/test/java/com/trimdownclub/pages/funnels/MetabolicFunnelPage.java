package com.trimdownclub.pages.funnels;

import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

public class MetabolicFunnelPage extends Funnels {

	//web elements
	@FindBy(css = "input[type='submit']")
	private WebElement nextBtn;

	@FindBy(css = "a.next.get_keto_diet_link")
	private WebElement foodsShouldAvoidBtn;


	@Override
	public WebElement optionToBeSelected(int randomOptionIndex) {
		String cssSelector =
				"div.row div.control-line:nth-of-type(" + randomOptionIndex + "), " +
						"div.control-circle-wrapper div.control-circle:nth-of-type(" + randomOptionIndex + ")";

		return Driver.get().findElement(By.cssSelector(cssSelector));
	}

	@Override
	public WebElement optionToBeSelected(String optionName) {
		String xPath = "//*[text()='" + optionName + "']/..";

		return Driver.get().findElement(By.xpath(xPath));
	}

	@Override
	public void clickNext(){
		BrowserUtils.scrollToElement(nextBtn);
		BrowserUtils.clickWithWait(nextBtn,3);
	}

	@Override
	public void endFunnel(){
		BrowserUtils.waitForURLContains("13",10);
		BrowserUtils.clickWithWait(foodsShouldAvoidBtn,3);
	}

	@Override
	public void setPrice() {

	}

	@Override
	public String getPrice() {
		return null;
	}

	public BigDecimal getPriceAsBigDecimal() {
		String priceFunnelAsDecimal = null;

		try {
			priceFunnelAsDecimal = priceFunnel.replace("$", "");
		} catch (Exception e) {
		}

		return new BigDecimal(priceFunnelAsDecimal);
	}

	@Override
	public void setProductName() {

	}

	@Override
	public String getProductName() {
		return null;
	}
}
