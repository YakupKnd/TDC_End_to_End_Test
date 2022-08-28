package com.trimdownclub.step_definitions;

import com.trimdownclub.pages.DiabetesFunnelPage;
import com.trimdownclub.pages.MeasurementsPage;
import io.cucumber.java.en.Given;

public class DiabetesStepDef {

	private DiabetesFunnelPage funnelPage = new DiabetesFunnelPage();
	private MeasurementsPage measurementsPage = new MeasurementsPage();

	@Given("The user goes through the whole diabetes funnel")
	public void the_user_goes_through_the_whole_diabetes_funnel() {
		funnelPage.chooseOptionFromFunnel();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		measurementsPage.setWeight();
		funnelPage.clickNext();

		measurementsPage.setHeightFt();
		measurementsPage.setHeightInch();
		funnelPage.clickNext();

		measurementsPage.setAge();
		funnelPage.clickNext();

		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.getMyCustomizeLowSugarPlan();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.chooseOptionFromFunnel();
		funnelPage.clickNext();

		funnelPage.endFunnel();

		funnelPage.clickCTAButton();

	}

}
