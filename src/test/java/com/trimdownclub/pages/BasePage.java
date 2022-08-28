package com.trimdownclub.pages;

import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.ConfigurationReader;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	private static int testCount = 1;
	private String url;

	public BasePage() {
		PageFactory.initElements(Driver.get(), this);
	}

	public void goToURL(String funnelName) {
		setURL(funnelName);
		setURLParameters(funnelName);
		Driver.get().get(url);
		BrowserUtils.waitForURLContains("https://dynamicsurvey.trimdownclub.com/", 5);
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



}
