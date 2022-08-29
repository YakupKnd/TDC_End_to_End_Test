package com.trimdownclub.pages;

import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public class TDCPage extends BasePage {

	@FindBy(css = "input#user_login")
	private WebElement usernameField;

	@FindBy(css = "input#pass1")
	private WebElement passwordField;

	@FindBy(css = "div.ffCheckbox")
	private WebElement acceptTermsCheckbox;

	@FindBy(css = "div.ffButtonWrapper a")
	private WebElement signUpBtn;

	@FindBy(css = "button.close-btn")
	private WebElement closeBtn;

	@FindBy(xpath = "//h1[text()=' My Purchases']")
	private WebElement myPurchasesText;

	@FindBy(css = "div.post-12.page.type-page.status-publish h2")
	private List<WebElement> allProducts;


//	public void loginToTDC() {
//		waitForURL("https://www.trimdownclub.com/registration-step-1");
//		BrowserUtils.sendKeysWithWait(usernameField, "test290820221357", 2);
//		BrowserUtils.sendKeysWithWait(passwordField, "123456789", 2);
//		BrowserUtils.clickWithWait(acceptTermsCheckbox, 2);
//		BrowserUtils.clickWithWait(signUpBtn, 2);
//		waitForURL("https://www.trimdownclub.com/mydashboard/");
//	}

	public void loginToTDC() {
		waitForURL("https://www.trimdownclub.com/registration-step-1");
		BrowserUtils.sendKeysWithWait(usernameField, email.substring(0, email.indexOf("@")), 2);
		BrowserUtils.sendKeysWithWait(passwordField, "123456789", 2);
		BrowserUtils.clickWithWait(acceptTermsCheckbox, 2);
		BrowserUtils.clickWithWait(signUpBtn, 2);
		waitForURL("https://www.trimdownclub.com/mydashboard/");
	}

	public void closeTDCVideo(){
		BrowserUtils.clickWithWait(closeBtn,3);
	}

	public void clickHeaderMenu(String menuName){
		WebElement menuNameWE = Driver.get().findElement(By.xpath("(//a[text()='" + menuName + "'])[2]"));
		BrowserUtils.clickWithWait(menuNameWE,2);
	}

	public void verifyProducts(){
		BrowserUtils.waitForVisibility(myPurchasesText,5);
		System.out.println("number of total products is: " + allProducts.size());
		for (int i = 0; i < allProducts.size(); i++) {
			System.out.println("product is: " + allProducts.get(i).getText());
		}

	}

}
