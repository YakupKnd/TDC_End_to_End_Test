package com.trimdownclub.pages.funnels;

import com.trimdownclub.pages.funnels.helpers.Funnels;
import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiabetesFunnelPage extends Funnels {

	@FindBy(css = "a.orange-flexible-btn.knd-ic-btn")
	private WebElement ctaBtn;

	@FindBy(css = "label.next.disabled")
	private WebElement nextBtn;

	@FindBy(css = "a.orange-flexible-btn.save-step13")
	private WebElement getMyCustomizedLowSugarPlanBtn;

	@FindBy(css = "a.bt.orange-flexible-btn.save-account")
	protected WebElement getLowSugarDietPlanBtn;

	@FindBy(css = "span.price-after")
	private WebElement priceFunnelWE;



	@Override
	public WebElement optionToBeSelected(int randomOptionIndex){
		String cssSelector =
				"div.row div.control-line:nth-of-type(" + randomOptionIndex + "), " +
						"div.control-circle:nth-of-type(" + randomOptionIndex + ")";

		return  Driver.get().findElement(By.cssSelector(cssSelector));
	}

	@Override
	public WebElement optionToBeSelected(String optionName){
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
		BrowserUtils.waitForURLContains("27",10);
		BrowserUtils.clickWithWait(getLowSugarDietPlanBtn,5);
	}

	@Override
	public void setIndividualPrice() {
		BrowserUtils.waitForVisibility(priceFunnelWE,3);
		this.price = priceFunnelWE.getText();
	}


	@Override
	public String getIndividualPrice(){
		System.out.println("price on funnel is: " + price);
		return this.price;
	}

	@Override
	public void setIndividualProductName(){
		this.productName = "Trim Down Club Program";
	}

	@Override
	public String getIndividualProductName(){
		return this.productName;
	}

	@Override
	public void purchase(){
		BrowserUtils.clickWithWait(ctaBtn,3);
	}

	public void getMyCustomizeLowSugarPlan(){
		BrowserUtils.clickWithWait(getMyCustomizedLowSugarPlanBtn,20);
	}

}
