package com.trimdownclub.pages.funnels;

import com.trimdownclub.pages.BasePage;
import com.trimdownclub.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.List;

public abstract class Funnels extends BasePage {

	protected String priceFunnel;
	protected String productName;

	//accept cookies btn
	@FindBy(css = "div#onetrust-banner-sdk button#onetrust-accept-btn-handler")
	protected WebElement acceptcookies;

	//all available options in a quiz question
	@FindBy(css = "div.control-line, div.control-circle")
	protected List<WebElement> allOptions;

	//selector of quiz question
	@FindBy(css = "h1[class*='title']")
	protected WebElement question;


	//-------------------------------------------------\\


	//randomly select any option from the quiz
	public void selectOptionFromQuiz() {
		BrowserUtils.wait(1);
		int randomIndex = generateRandomIndexNo();
		WebElement option = optionToBeSelected(randomIndex);
		printQuestionAndAnswer(option);
		clickOption(option);
	}

	//select an option from the quiz with the index no
	public void selectOptionFromQuiz(int optionIndexNo) {
		BrowserUtils.wait(1);
		WebElement option = optionToBeSelected(optionIndexNo);
		printQuestionAndAnswer(option);
		clickOption(option);
	}

	//select an option from the quiz with the option name
	public void selectOptionFromQuiz(String optionName) {
		BrowserUtils.wait(1);
		WebElement option = optionToBeSelected(optionName);
		printQuestionAndAnswer(option);
		clickOption(option);
	}


	//-------------------------------------------------\\


	//abstract methods: sub-classes (Funnels) must override these methods
	public abstract WebElement optionToBeSelected(int randomOptionIndex);

	public abstract WebElement optionToBeSelected(String optionName);

	public abstract void clickNext();

	public abstract void endFunnel();

	public abstract void setPrice();

	public abstract String getPrice();

	public abstract void setProductName();

	public abstract String getProductName();

	//-------------------------------------------------\\


	//generate random index number for an option to be selected in a quiz question
	public int generateRandomIndexNo() {
		return BrowserUtils.generateRandomNumber(allOptions.size()) + 1;
	}

	//print out question and answer on the console
	public void printQuestionAndAnswer(WebElement option){
		System.out.println(question.getText());
		System.out.println(option.getText() + "\n");
	}

	//click specified option
	public void clickOption(WebElement option){
		BrowserUtils.clickWithWait(option, 3);
	}

	//accept cookies
	public void clickAcceptCookies() {
		try {
			BrowserUtils.waitForVisibility(acceptcookies, 2);
			acceptcookies.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
