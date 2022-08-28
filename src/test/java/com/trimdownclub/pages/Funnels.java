package com.trimdownclub.pages;

import com.trimdownclub.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class Funnels extends BasePage {

	//web elements
	@FindBy(css = "div#onetrust-banner-sdk button#onetrust-accept-btn-handler")
	protected WebElement acceptcookies;

	@FindBy(css = "div.control-line, div.control-circle")
	protected List<WebElement> allOptions;

	@FindBy(css = "h1[class*='title']")
	protected WebElement question;

	protected WebElement nextBtn;

	protected WebElement ctaBtn;



	public abstract void chooseOptionFromFunnel();

	public abstract void chooseOptionFromFunnel(int optionIndex);

	public abstract void chooseOptionFromFunnel(String value);

	public abstract void clickNext();

	public abstract void endFunnel();



	public void clickAcceptCookies(){
		try {
			BrowserUtils.waitForVisibility(acceptcookies,2);
			acceptcookies.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
