package com.trimdownclub.step_definitions;

import com.trimdownclub.pages.FunnelPage;
import com.trimdownclub.pages.MeasurementsPage;
import com.trimdownclub.utilities.BrowserUtils;
import io.cucumber.java.en.Given;

public class DiabetesStepDef {

	private FunnelPage funnelPage = new FunnelPage();
	private MeasurementsPage measurementsPage = new MeasurementsPage();

	@Given("The user goes through the whole diabetes funnel")
	public void the_user_goes_through_the_whole_diabetes_funnel() {
		funnelPage.chooseOptionFromFunnel();

		funnelPage.chooseOptionFromFunnel(2);
		BrowserUtils.wait(5);
//		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.chooseOptionFromFunnel();
		funnelPage.chooseOptionFromFunnel();
		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();
		measurementsPage.setAllFields();
		funnelPage.endFunnel();

	}

}
