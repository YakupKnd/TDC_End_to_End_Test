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

	@FindBy(xpath = "(//a[text()='My Guides'])[2]")
	private WebElement myGuidesBtn;

	@FindBy(xpath = "//h1[text()=' My Purchases']")
	private WebElement myPurchasesText;

	@FindBy(css = "div.post-12.page.type-page.status-publish h2")
	private List<WebElement> allProducts;

	public void loginToTDC() {
		waitForURL("https://www.trimdownclub.com/registration-step-1");
		BrowserUtils.sendKeysWithWait(usernameField, email.substring(0, email.indexOf("@")), 2);
		BrowserUtils.sendKeysWithWait(passwordField, "123456789", 2);
		BrowserUtils.clickWithWait(acceptTermsCheckbox, 2);
		BrowserUtils.clickWithWait(signUpBtn, 2);
		waitForURL("https://www.trimdownclub.com/mydashboard/");
	}

	public void closeTDCVideo() {
		BrowserUtils.clickWithWait(closeBtn, 3);
	}

	public void clickHeaderMenu(String menuName) {
		BrowserUtils.wait(2);
//		WebElement menuNameWE = Driver.get().findElement(By.xpath("(//a[text()='" + menuName + "'])[2]"));
//		BrowserUtils.clickWithWait(menuNameWE, 2);

		By locator = By.xpath("(//a[text()='" + menuName + "'])[2]");
		BrowserUtils.clickManyTimes(locator);
	}

	public List<String> getAllProductNames() {
		BrowserUtils.waitForVisibility(myPurchasesText, 5);

		for (int i = 0; i < allProducts.size(); i++) {
			System.out.println("product " + (i + 1) + " in 'My Guide' menu is: " + allProducts.get(i).getText());
		}

		return BrowserUtils.getTextAsList(allProducts);
	}

}
