package com.trimdownclub.pages;


import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.ConfigurationReader;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ClickBankPage extends BasePage {

	private String cardHolderName;
	private Select select;
	private String priceClickBank;

	@FindBy(id = "submitButton")
	private WebElement payNowbtn;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "cardholderName")
	private WebElement cardHolderNameField;

	@FindBy(css = "input#data")
	private WebElement cardNumberField;

	@FindBy(id = "expMonth")
	private WebElement expMonthDropdown;

	@FindBy(id = "expYear")
	private WebElement expYearDropdown;

	@FindBy(id = "securityCode")
	private WebElement securityCodeField;

	@FindBy(id = "billingCountry")
	private WebElement countryDropdown;

	@FindBy(id = "billingZip")
	private WebElement zipField;

	@FindBy(id = "currency")
	private WebElement currencyDropdown;

	@FindBy(css = "#billStatement td.text-right.ng-binding")
	private WebElement priceClickBankWE;

	@FindBy(id = "acceptTerms")
	private WebElement acceptTermsCheckbox;


	//----------------------------------------------------------------//

	public void setEmailField() {
		BrowserUtils.wait(0.3);

		this.email = generateEmail();
		System.out.println("email is: " + this.email);
		BrowserUtils.sendKeysWithWait(emailField, email,3);
	}

	public void setCardHolderNameField() {
		BrowserUtils.wait(0.3);

		this.cardHolderName = generateCardHolder();
		System.out.println("cardolderName is: " + this.cardHolderName);
		BrowserUtils.sendKeysWithWait(cardHolderNameField, cardHolderName,3);
	}

	public void setCardNumberField() {
		BrowserUtils.wait(0.3);

		String cardNumber = ConfigurationReader.get("cc_number");
		Driver.get().switchTo().frame(0);
		BrowserUtils.sendKeysWithWait(cardNumberField, cardNumber,3);
		Driver.get().switchTo().defaultContent();
	}

	public void setExpMonthDropdown() {
		BrowserUtils.wait(0.3);

		String expMonth = ConfigurationReader.get("cc_expiration_month");
		select = new Select(expMonthDropdown);
		select.selectByVisibleText(expMonth);
	}

	public void setExpYearDropdown() {
		BrowserUtils.wait(0.3);

		String expYear = ConfigurationReader.get("cc_expiration_year");
		select = new Select(expYearDropdown);
		select.selectByVisibleText(expYear);
	}

	public void setSecurityCodeField() {
		BrowserUtils.wait(0.3);

		String securityCode = ConfigurationReader.get("cc_security_code");
		BrowserUtils.sendKeysWithWait(securityCodeField, securityCode,3);
	}

	public void setCountryDropdown(String country) {
		BrowserUtils.wait(0.3);

		select = new Select(countryDropdown);
		select.selectByVisibleText(country);
	}

	public void setZipField(String zipCode) {
		BrowserUtils.wait(0.3);

		BrowserUtils.sendKeysWithWait(zipField, zipCode,3);
	}

	public void setCurrencyDropdown(int index) {
		BrowserUtils.wait(0.3);

		select = new Select(currencyDropdown);
		select.selectByIndex(index);
	}

	public void setAcceptTermsCheckbox() {
		BrowserUtils.wait(0.3);

		BrowserUtils.clickWithWait(acceptTermsCheckbox,2);
	}

	public void purchase(){
		BrowserUtils.wait(0.3);

		BrowserUtils.clickWithWait(acceptTermsCheckbox,2);
		BrowserUtils.clickWithWait(payNowbtn,2);
	}

	public void setPrice(){
		BrowserUtils.waitForText(priceClickBankWE,"$");
		this.priceClickBank = priceClickBankWE.getText();
	}

	public String getPrice(){
		System.out.println("price on clickbank is: " + priceClickBank);
		return this.priceClickBank;
	}

	public String generateEmail(){
		return "test" + currentDate + "@test.com";
	}

	public String generateCardHolder(){
		return "test " + currentDate + " test";
	}

}
