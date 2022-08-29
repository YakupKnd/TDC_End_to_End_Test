package com.trimdownclub.pages;

import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.ConfigurationReader;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

	private static int testCount = 1;
	private static String url;
	protected static String currentDate;
	protected static String email;
	protected static BigDecimal expectedTotalPrice = new BigDecimal(0);
	protected static List<String> actualProducts = new ArrayList<>();



	public BasePage() {
		currentDate = BrowserUtils.getCurrentDateAndTime();
		PageFactory.initElements(Driver.get(), this);
	}

	public void goToURL(String funnelName) {
		setURL(funnelName);
		setURLParameters(funnelName);
		Driver.get().get(url);
		waitForURL("https://dynamicsurvey.trimdownclub.com/");
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
		url += "?tid=" + funnelName + "_" + currentDate + "_test" + testCount
				+ "&ADID=" + funnelName + "_" + currentDate + "_test" + testCount++;
	}


	public void waitForURL(String urlPart){
		BrowserUtils.waitForURLContains(urlPart,5);
	}

	public BigDecimal getExpectedTotalPrice(){
		return expectedTotalPrice;
	}

	public List<String> getActualProducts(){
		return actualProducts;
	}

}
