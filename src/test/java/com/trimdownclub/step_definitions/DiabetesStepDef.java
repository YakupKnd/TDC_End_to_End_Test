package com.trimdownclub.step_definitions;

import com.trimdownclub.pages.ClickBankPage;
import com.trimdownclub.pages.TDCPage;
import com.trimdownclub.pages.ThankYouPage;
import com.trimdownclub.pages.upsells.UpsellPage1;
import com.trimdownclub.pages.upsells.UpsellPage2;
import com.trimdownclub.pages.upsells.UpsellPage3;
import com.trimdownclub.pages.funnels.DiabetesFunnelPage;
import com.trimdownclub.pages.funnels.MeasurementsPage;
import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DiabetesStepDef {

	private DiabetesFunnelPage diabetesFunnelPage = new DiabetesFunnelPage();
	private MeasurementsPage measurementsPage = new MeasurementsPage();
	private ClickBankPage clickBankPage = new ClickBankPage();
	private UpsellPage1 upsellPage1 = new UpsellPage1();
	private UpsellPage2 upsellPage2 = new UpsellPage2();
	private UpsellPage3 upsellPage3 = new UpsellPage3();
	private ThankYouPage thankYouPage = new ThankYouPage();
	private TDCPage tdcPage = new TDCPage();

	@Given("The user goes through the whole diabetes funnel")
	public void the_user_goes_through_the_whole_diabetes_funnel() {
		//are you male or female
		diabetesFunnelPage.selectOptionFromQuiz();

		//page 2
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 3
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 4
		measurementsPage.setWeight();
		diabetesFunnelPage.clickNext();

		//page 5
		measurementsPage.setHeightFt();
		measurementsPage.setHeightInch();
		diabetesFunnelPage.clickNext();

		//page 6
		measurementsPage.setAge();
		diabetesFunnelPage.clickNext();

		//page 7
		diabetesFunnelPage.clickNext();

		//page 8
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 9
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 10
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 11
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 12
		diabetesFunnelPage.clickNext();

		//page 13
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 15
		diabetesFunnelPage.getMyCustomizeLowSugarPlan();

		//page 16
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 17
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 18
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 19
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 20
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 21
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 22
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 23
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 24
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 25
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 26
		diabetesFunnelPage.selectOptionFromQuiz();
		diabetesFunnelPage.clickNext();

		//page 27
		diabetesFunnelPage.endFunnel();

		//page 28
		diabetesFunnelPage.setProductName();
		diabetesFunnelPage.setPrice();
		diabetesFunnelPage.calculateTotalPrice();
		diabetesFunnelPage.clickCTAButton();

	}

	@When("The user makes a purchase from ClickBank")
	public void the_user_makes_a_purchase_from_ClickBank() {
		//wait for url contains clickbank
		clickBankPage.waitForURL("clickbank");

		//fill out order form completely
		clickBankPage.setEmailField();
		clickBankPage.setCardHolderNameField();

		clickBankPage.setCardNumberField();
		clickBankPage.setExpMonthDropdown();
		clickBankPage.setExpYearDropdown();
		clickBankPage.setSecurityCodeField();

		clickBankPage.setCountryDropdown("Turkey");
		clickBankPage.setZipField("41000");

		//select dollar as a currency
		clickBankPage.setCurrencyDropdown(0);

		//get the price on the OF
		clickBankPage.setPrice();

		//click pay button
		clickBankPage.clickPayNowBtn();

		//verify the price is the same as in the funnel
		Assert.assertEquals(diabetesFunnelPage.getPrice(), clickBankPage.getPrice());
	}


	@When("The user purchases {string} from first upsell page")
	public void the_user_purchases_from_first_upsell_page(String productName) {
		//wait for upsell 1 loaded
		upsellPage1.waitForURL("https://www.introduce.trimdownclub.com");

		//skip the vsl
		upsellPage1.skipVSL();

		//get the price on the upsell 1
		upsellPage1.setPrice();
		upsellPage1.calculateTotalPrice();

		//get the product name on the upsell 1
		upsellPage1.setProductName();

		//Verify that product name
		Assert.assertTrue(upsellPage1.getProductName().contains(productName));

		//purchase from upsell 1
		upsellPage1.purchaseFromUpsell();
	}

	@When("The user purchases {string} from second upsell page")
	public void the_user_purchases_from_second_upsell_page(String productName) {
		//wait for upsell 2 loaded
		upsellPage2.waitForURL("https://www.introduce.trimdownclub.com/introduction/tdc-aa.html");

		//get the price on the upsell 2
		upsellPage2.setPrice();
		upsellPage2.calculateTotalPrice();

		//get the product name on the upsell 2
		upsellPage2.setProductName();

		//Verify that product name
		Assert.assertTrue(upsellPage2.getProductName().contains(productName));

		//purchase from upsell 2
		upsellPage2.purchaseFromUpsell();
	}

	@When("The user purchases {string} from third upsell page")
	public void the_user_purchases_from_third_upsell_page(String productName) {
		//wait for upsell 3 loaded
		upsellPage3.waitForURL("https://www.introduce.trimdownclub.com/introduction/tdc-bmis.html");

		//get the price on the upsell 3
		upsellPage3.setPrice();
		upsellPage3.calculateTotalPrice();

		//get the product name on the upsell 3
		upsellPage3.setProductName();

		//Verify that product name
		Assert.assertTrue(upsellPage3.getProductName().contains(productName));

		//purchase from upsell 3
		upsellPage3.purchaseFromUpsell();
	}

	@Then("Verify that the user has correct number of products")
	public void verify_that_the_user_has_correct_number_of_products() {
		//wait for thank you page loaded
		thankYouPage.waitForURL("https://ssl.clickbank.net/order/receipt.html");
		thankYouPage.clickGreenOkBtn();

		//put all the products we bought before in a list
		List<String> actualProducts = new ArrayList<>();
		actualProducts.add(diabetesFunnelPage.getProductName());
		actualProducts.add(upsellPage1.getProductName());
		actualProducts.add(upsellPage2.getProductName());
		actualProducts.add(upsellPage3.getProductName());

		//verify that we have exact number of products in the 'thank you' page as we purchased before
		Assert.assertEquals(actualProducts.size(), thankYouPage.getAllProductNames().size());
	}

	@Then("Verify that the user pays correct amount of money")
	public void verify_that_the_user_pays_correct_amount_of_money() {
		BigDecimal actualTotalPrice = thankYouPage.calculateTotalPrice();
		BigDecimal expectedTotalPrice = upsellPage3.getExpectedTotalPrice();

		System.out.println("total price on thank you page: " + actualTotalPrice);
		System.out.println("total price on previous pages: " + expectedTotalPrice);

		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
	}

	@Then("Verify that the user can access all the products")
	public void verify_that_the_user_can_access_all_the_products() {
		thankYouPage.clickAllAccessProdBtns();

		Set<String> windowHandles = Driver.get().getWindowHandles();
		ArrayList<String> allTabs = new ArrayList<>(windowHandles);

		for (int i = 1; i < allTabs.size(); i++) {
			Driver.get().switchTo().window(allTabs.get(i));
			tdcPage.loginToTDC();
			tdcPage.closeTDCVideo();
			tdcPage.verifyProducts();
		}

	}


	//*********************************************************************************
	//delete this method later  *******************************************************
	@Test
	public void test() {
		Driver.get().get("https://www.trimdownclub.com/wp-login.php");
		Driver.get().findElement(By.id("user_login")).sendKeys("test290820221357");
		Driver.get().findElement(By.id("user_pass")).sendKeys("123456789");
		Driver.get().findElement(By.id("wp-submit")).click();
//		tdcPage.closeTDCVideo();
		tdcPage.clickHeaderMenu("My Guides");
		tdcPage.verifyProducts();
	}


}
