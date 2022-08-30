package com.trimdownclub.step_definitions;

import com.trimdownclub.pages.ClickBankPage;
import com.trimdownclub.pages.TDCPage;
import com.trimdownclub.pages.ThankYouPage;
import com.trimdownclub.pages.upsells.UpsellPage1;
import com.trimdownclub.pages.upsells.UpsellPage2;
import com.trimdownclub.pages.upsells.UpsellPage3;
import com.trimdownclub.pages.funnels.DiabetesFunnelPage;
import com.trimdownclub.pages.funnels.helpers.MeasurementsPage;
import com.trimdownclub.utilities.BrowserUtils;
import com.trimdownclub.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.math.BigDecimal;

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
		diabetesFunnelPage.selectQuizOption();

		//page 2
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 3
		diabetesFunnelPage.selectQuizOption();
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
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 9
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 10
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 11
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 12
		diabetesFunnelPage.clickNext();

		//page 13
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 15
		diabetesFunnelPage.getMyCustomizeLowSugarPlan();

		//page 16
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 17
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 18
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 19
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 20
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 21
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 22
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 23
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 24
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 25
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 26
		diabetesFunnelPage.selectQuizOption();
		diabetesFunnelPage.clickNext();

		//page 27
		diabetesFunnelPage.endFunnel();

		//page 28
		diabetesFunnelPage.setIndividualProductName();
		diabetesFunnelPage.setIndividualPrice();
		diabetesFunnelPage.addToAllProducts();
		diabetesFunnelPage.addToTotalPrice();
		diabetesFunnelPage.purchase();

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
		clickBankPage.purchase();

		//verify the price is the same as in the funnel
		String expectedPrice = diabetesFunnelPage.getIndividualPrice();
		String actualPrice = clickBankPage.getPrice();
		Assert.assertEquals(expectedPrice, actualPrice);
	}


	@When("The user purchases {string} from first upsell page")
	public void the_user_purchases_from_first_upsell_page(String productName) {
		//wait for upsell 1 loaded
		upsellPage1.waitForURL("https://www.introduce.trimdownclub.com");

		//skip the vsl
		upsellPage1.skipVSL();

		//get the price on the upsell 1
		upsellPage1.setIndividualPrice();

		//get the product name on the upsell 1
		upsellPage1.setIndividualProductName();

		//add the price to the total price
		upsellPage1.addToTotalPrice();

		//add product to total product list
		upsellPage1.addToAllProducts();

		//Verify that product name
		String actualProductName = upsellPage1.getIndividualProductName();
		String expectedProductName = productName;
		Assert.assertTrue(actualProductName.contains(expectedProductName));

		//purchase from upsell 1
		upsellPage1.purchase();
	}

	@When("The user purchases {string} from second upsell page")
	public void the_user_purchases_from_second_upsell_page(String productName) {
		//wait for upsell 2 loaded
		upsellPage2.waitForURL("https://www.introduce.trimdownclub.com/introduction/tdc-aa.html");

		//get the price on the upsell 2
		upsellPage2.setIndividualPrice();

		//get the product name on the upsell 2
		upsellPage2.setIndividualProductName();

		//add the price to the total price
		upsellPage2.addToTotalPrice();

		//add product to total product list
		upsellPage2.addToAllProducts();

		//Verify that product name
		String actualProductName = upsellPage2.getIndividualProductName();
		String expectedProductName = productName;
		Assert.assertTrue(actualProductName.contains(expectedProductName));

		//purchase from upsell 2
		upsellPage2.purchase();
	}

	@When("The user purchases {string} from third upsell page")
	public void the_user_purchases_from_third_upsell_page(String productName) {
		//wait for upsell 3 loaded
		upsellPage3.waitForURL("https://www.introduce.trimdownclub.com/introduction/tdc-bmis.html");

		//get the price on the upsell 3
		upsellPage3.setIndividualPrice();

		//get the product name on the upsell 3
		upsellPage3.setIndividualProductName();

		//add product to total product list
		upsellPage3.addToTotalPrice();

		//add product to total product list
		upsellPage3.addToAllProducts();

		//Verify that product name
		String actualProductName = upsellPage3.getIndividualProductName();
		String expectedProductName = productName;
		Assert.assertTrue(actualProductName.contains(expectedProductName));

		//purchase from upsell 3
		upsellPage3.purchase();
	}

	@Then("Verify that the user has correct number of products")
	public void verify_that_the_user_has_correct_number_of_products() {
		//wait for thank you page loaded
		thankYouPage.waitForURL("https://ssl.clickbank.net/order/receipt.html");
		thankYouPage.clickGreenOkBtn();
		thankYouPage.setAllProductNames();

		//verify that we have exact number of products in the 'thank you' page as we purchased before
		int expectedAmountOfProducts = upsellPage3.getAllProducts().size();
		int actualAmountOfProducts = thankYouPage.getAllProductNames().size();

		System.out.println("expected amount of product is: " + expectedAmountOfProducts);
		System.out.println("actual amount of product is: " + actualAmountOfProducts);

		Assert.assertEquals(expectedAmountOfProducts, actualAmountOfProducts);
	}

	@Then("Verify that the user pays correct amount of money")
	public void verify_that_the_user_pays_correct_amount_of_money() {
		BigDecimal actualTotalPrice = thankYouPage.getActualTotalPrice();
		BigDecimal expectedTotalPrice = upsellPage3.getTotalPrice();

		System.out.println("expected total price is: " + expectedTotalPrice);
		System.out.println("actual total price is: " + actualTotalPrice);

		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
	}

	@Then("Verify that the user can access all the products")
	public void verify_that_the_user_can_access_all_the_products() {
		thankYouPage.goToDigitalProducts();
		BrowserUtils.wait(3);
		BrowserUtils.switchToWindow(1);
		tdcPage.loginToTDC();
		tdcPage.closeTDCVideo();
		tdcPage.clickHeaderMenu("My Guides");

		//verify that we have exact number of products in the 'My Guides' page as we purchased before
		int expectedAmountOfProducts = thankYouPage.getAllProductNames().size();
		int actualAmountOfProducts = tdcPage.getAllProductNames().size();

		System.out.println("expected amount of product is: " + expectedAmountOfProducts);
		System.out.println("actual amount of product is: " + actualAmountOfProducts);

		Assert.assertEquals(expectedAmountOfProducts, actualAmountOfProducts);

	}


	//*********************************************************************************
	//delete this method later  *******************************************************
	@Test
	public void test() {
		Driver.get().get("https://www.trimdownclub.com/wp-login.php");
		Driver.get().findElement(By.id("user_login")).sendKeys("test290820221357");
		Driver.get().findElement(By.id("user_pass")).sendKeys("123456789");
		Driver.get().findElement(By.id("wp-submit")).click();
		tdcPage.clickHeaderMenu("My Guides");

		//verify that we have exact number of products in the 'My Guides' page as we purchased before
		int expectedAmountOfProducts = thankYouPage.getAllProductNames().size();
		int actualAmountOfProducts = tdcPage.getAllProductNames().size();

		System.out.println("expected amount of product is: " + expectedAmountOfProducts);
		System.out.println("actual amount of product is: " + actualAmountOfProducts);

		Assert.assertEquals(expectedAmountOfProducts, actualAmountOfProducts);
	}


}
