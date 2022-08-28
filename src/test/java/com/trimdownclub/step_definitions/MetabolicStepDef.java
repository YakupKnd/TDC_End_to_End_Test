package com.trimdownclub.step_definitions;

import com.trimdownclub.pages.MetabolicFunnelPage;
import com.trimdownclub.pages.MeasurementsPage;
import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MetabolicStepDef {

	private MetabolicFunnelPage metabolicFunnelPage = new MetabolicFunnelPage();
	private MeasurementsPage measurementsPage = new MeasurementsPage();


	@Given("The user is on the {string} page")
	public void the_user_is_on_the_page(String funnelName) {
		metabolicFunnelPage.goToURL(funnelName);
	}

	@Given("The user goes through the whole metabolic funnel")
	public void the_user_goes_through_the_whole_metabolic_funnel() {
		//funnelPage.clickAcceptCookies();
		metabolicFunnelPage.chooseOptionFromFunnel();
		metabolicFunnelPage.chooseOptionFromFunnel();
		metabolicFunnelPage.chooseOptionFromFunnel();
		metabolicFunnelPage.chooseOptionFromFunnel();
		metabolicFunnelPage.chooseOptionFromFunnel();
		metabolicFunnelPage.clickNext();
		metabolicFunnelPage.chooseOptionFromFunnel();
		metabolicFunnelPage.chooseOptionFromFunnel();
		metabolicFunnelPage.chooseOptionFromFunnel();
		metabolicFunnelPage.chooseOptionFromFunnel();
		metabolicFunnelPage.clickNext();
		measurementsPage.setAllFields();
		metabolicFunnelPage.endFunnel();
	}





	@Given("TestMeasurements")
	public void TestMeasurements1(){
		Driver.get().get("https://dynamicsurvey.trimdownclub.com/mt/v173/11/");
		BrowserUtils.wait(1);
		measurementsPage.setAllFields();
		metabolicFunnelPage.endFunnel();

	}

	@Given("TestSkipVSL")
	public void TestSkipVSL1(){
		Driver.get().get("https://dynamicsurvey.trimdownclub.com/mt/v212/1/?v=1&media=matabolic_exp_4122");
		BrowserUtils.wait(1);
		WebElement playBtn = Driver.get().findElement(By.cssSelector("div.jw-icon.jw-icon-display.jw-button-color.jw-reset"));
		BrowserUtils.clickWithWait(playBtn,5);

		//javascript:jwplayer('video').seek(prompt("Time?", data.SCHEDULE.adbreak1.offset-2))
		(  (JavascriptExecutor) Driver.get() ).executeScript("javascript:jwplayer('video').seek(prompt('Time?', data.SCHEDULE.adbreak1.offset-2))");
		Driver.get().switchTo().alert().accept();
	}

}
