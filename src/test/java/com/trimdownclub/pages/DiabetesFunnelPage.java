package com.trimdownclub.pages;

import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiabetesFunnelPage extends Funnels  {

	@FindBy(css = "a.orange-flexible-btn.knd-ic-btn")
	private WebElement ctaBtn;

	@FindBy(css = "label.next.disabled")
	private WebElement nextBtn;

	@FindBy(css = "a.orange-flexible-btn.save-step13")
	private WebElement getMyCustomizedLowSugarPlanBtn;

	@FindBy(css = "a.bt.orange-flexible-btn.save-account")
	protected WebElement getLowSugarDietPlanBtn;

	//methods
	@Override
	public void chooseOptionFromFunnel() {
		BrowserUtils.wait(1);

		int optionIndexRandom = BrowserUtils.generateRandomNumber(allOptions.size()) + 1;

		String cssSelector =
							"div.row div.control-line:nth-of-type(" + optionIndexRandom + "), " +
							"div.control-circle:nth-of-type(" + optionIndexRandom + ")";

		WebElement option = Driver.get().findElement(By.cssSelector(cssSelector));

		System.out.println(question.getText());
		System.out.println(option.getText() + "\n");

		BrowserUtils.clickWithWait(option, 3);
	}

	@Override
	public void chooseOptionFromFunnel(int optionIndex) {
		BrowserUtils.wait(1);

		String cssSelector =
							"div.row div.control-line:nth-of-type(" + optionIndex + ") label, " +
							"div.control-circle-wrapper div.control-circle:nth-of-type(" + optionIndex + ")";

		WebElement option = Driver.get().findElement(By.cssSelector("div.row div.control-line:nth-of-type(" + optionIndex + ") label"));

		System.out.println(question.getText());
		System.out.println(option.getText() + "\n");

		BrowserUtils.clickWithWait(option, 3);
	}

	@Override
	public void chooseOptionFromFunnel(String value) {
		BrowserUtils.wait(1);

		String xPath = "//*[text()='" + value + "']/..";
		WebElement option = Driver.get().findElement(By.xpath(xPath));

		System.out.println(question.getText());
		System.out.println(option.getText() + "\n");

		BrowserUtils.clickWithWait(option, 3);
	}

	@Override
	public void clickNext(){
		BrowserUtils.scrollToElement(nextBtn);
		BrowserUtils.clickWithWait(nextBtn,3);
	}

	public void getMyCustomizeLowSugarPlan(){
		BrowserUtils.clickWithWait(getMyCustomizedLowSugarPlanBtn,10);
	}

	@Override
	public void endFunnel(){
		BrowserUtils.waitForURLContains("27",10);
		BrowserUtils.clickWithWait(getLowSugarDietPlanBtn,3);
	}

	public void clickCTAButton(){
		BrowserUtils.clickWithWait(ctaBtn,3);
	}


}
