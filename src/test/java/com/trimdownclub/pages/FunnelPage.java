package com.trimdownclub.pages;

import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FunnelPage extends BasePage {

	//web elements
	@FindBy(css = "div.control-line, div.control-circle")
	private List<WebElement> allOptions;

	@FindBy(css = "label.next.disabled")
	private WebElement nextBtn;

	@FindBy(css = "a.next.get_keto_diet_link")
	private WebElement foodsShouldAvoidBtn;


	//methods
	public void chooseOptionFromFunnel() {
		BrowserUtils.wait(1);

		int optionIndexRandom = BrowserUtils.generateRandomNumber(allOptions.size()) + 1;
		System.out.println("random number is: " + optionIndexRandom);

		String cssSelector =
							"div.row div.control-line:nth-of-type(" + optionIndexRandom + "), " +
							"div.control-circle-wrapper div.control-circle:nth-of-type(" + optionIndexRandom + ")";

		WebElement option = Driver.get().findElement(By.cssSelector(cssSelector));
		BrowserUtils.clickWithWait(option, 3);
	}

	public void chooseOptionFromFunnel(int optionIndex) {
		BrowserUtils.wait(1);

		String cssSelector =
							"div.row div.control-line:nth-of-type(" + optionIndex + ") label, " +
							"div.control-circle-wrapper div.control-circle:nth-of-type(" + optionIndex + ")";

		WebElement option = Driver.get().findElement(By.cssSelector("div.row div.control-line:nth-of-type(" + optionIndex + ") label"));
		BrowserUtils.clickWithWait(option, 3);


		//delete this
		clickNext();
	}

	public void chooseOptionFromFunnel(String value) {
		BrowserUtils.wait(1);

		String xPath = "//*[text()='" + value + "']/..";
		WebElement option = Driver.get().findElement(By.xpath(xPath));
		BrowserUtils.clickWithWait(option, 3);
	}

	public void clickNext(){
		BrowserUtils.scrollToElement(nextBtn);
		nextBtn.click();
//		BrowserUtils.clickWithWait(nextBtn,3);
	}

	public void endFunnel(){
		BrowserUtils.waitForURLContains("13",10);
		BrowserUtils.clickWithWait(foodsShouldAvoidBtn,3);
	}

}
