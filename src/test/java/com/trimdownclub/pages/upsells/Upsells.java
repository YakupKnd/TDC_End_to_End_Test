package com.trimdownclub.pages.upsells;

import com.trimdownclub.pages.BasePage;
import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public abstract class Upsells extends BasePage {

	protected String price;
	protected String productName;


	public abstract void purchaseFromUpsell();

	public abstract void setPrice();

	public abstract String getPrice();

	public abstract void setProductName();

	public abstract String getProductName();

	public void calculateTotalPrice() {
		String priceFunnelAsDecimal = null;

		try {
			priceFunnelAsDecimal = price.replace("$", "");
		} catch (Exception e) {
		}

		expectedTotalPrice = expectedTotalPrice.add(new BigDecimal(priceFunnelAsDecimal));
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
