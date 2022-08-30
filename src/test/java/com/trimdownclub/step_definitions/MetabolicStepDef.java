package com.trimdownclub.step_definitions;

import com.trimdownclub.pages.funnels.MetabolicFunnelPage;
import com.trimdownclub.pages.funnels.helpers.MeasurementsPage;
import io.cucumber.java.en.Given;

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
		metabolicFunnelPage.selectQuizOption();
		metabolicFunnelPage.selectQuizOption();
		metabolicFunnelPage.selectQuizOption();
		metabolicFunnelPage.selectQuizOption();
		metabolicFunnelPage.selectQuizOption();
		metabolicFunnelPage.clickNext();
		metabolicFunnelPage.selectQuizOption();
		metabolicFunnelPage.selectQuizOption();
		metabolicFunnelPage.selectQuizOption();
		metabolicFunnelPage.selectQuizOption();
		metabolicFunnelPage.clickNext();
		measurementsPage.setAllFields();
		metabolicFunnelPage.endFunnel();
	}


}
