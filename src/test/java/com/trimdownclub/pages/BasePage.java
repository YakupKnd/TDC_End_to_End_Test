package com.trimdownclub.pages;

import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.ConfigurationReader;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	@FindBy(css = "div#onetrust-banner-sdk button#onetrust-accept-btn-handler")
	private WebElement acceptcookies;

	private static int testCount = 1;
	private String url;

	public BasePage() {
		PageFactory.initElements(Driver.get(), this);
	}

	public void gotoFunnelURL(String funnelName) {
		setURL(funnelName);
		setURLParameters(funnelName);
		Driver.get().get(url);
		waitForURLContains("https://dynamicsurvey.trimdownclub.com/");
	}

	public void setURL(String funnelName){
		switch (funnelName.toLowerCase()) {
			case "metabolic":
				url = ConfigurationReader.get("metabolic_url");
				break;

			case "diabetes":
				url = ConfigurationReader.get("diabetes_url");
				break;

			default:
				System.out.println("No such funnel");
				break;
		}
	}

	public void setURLParameters(String funnelName) {
		String currentDate = BrowserUtils.getCurrentDateAndTime();

		url += "?tid=" + funnelName + "_" + currentDate + "_test" + testCount
				+ "&ADID=" + funnelName + "_" + currentDate + "_test" + testCount++;
	}

	public void waitForURLContains(String partialURL){
		BrowserUtils.waitForURLContains(partialURL, 5);
	}

	public String getCurrentURL() {
		return Driver.get().getCurrentUrl();
	}

	public void clickAcceptCookies(){
		try {
			BrowserUtils.waitForVisibility(acceptcookies,2);
			acceptcookies.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
