package com.trimdownclub.pages;

import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.ConfigurationReader;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	private static int testCount = 1;
	private static String url;

	protected static String currentDate;
	protected static String email;


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

	public void skipVSL() {
		((JavascriptExecutor) Driver.get()).executeScript("javascript:jwplayer('video').seek(prompt('Time?', data.SCHEDULE.adbreak1.offset-2))");
		BrowserUtils.waitForAlert();
		Driver.get().switchTo().alert().accept();
	}

	public void stayOnThisPage() {
		try {
			WebElement stayOnThisPageBtn = Driver.get().findElement(By.cssSelector("a.stay"));
			stayOnThisPageBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
