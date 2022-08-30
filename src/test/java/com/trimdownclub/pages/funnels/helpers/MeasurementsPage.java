package com.trimdownclub.pages.funnels.helpers;

import com.trimdownclub.pages.BasePage;
import com.trimdownclub.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MeasurementsPage extends BasePage {

	//fields
	private int age;
	private int heightFt;
	private int heightInch;
	private int weight;
	private int targetWeight;

	//locators
	@FindBy(css = "input[name='Age']")
	private WebElement ageField;

	@FindBy(css = "input[name='Heightft']")
	private WebElement heightFtField;

	@FindBy(css = "input[name='Heightinch']")
	private WebElement heightInchField;

	@FindBy(css = "input[name='Weight']")
	private WebElement weightField;

	@FindBy(css = "input[name='Target']")
	private WebElement targetWeightField;

	@FindBy(css = "input[type='submit']")
	private WebElement submitBtn;


	public void


	 setAllFields(){
		BrowserUtils.wait(1);
		setAge();
		setHeightFt();
		setHeightInch();
		setWeight();
		setTargetWeight();
		clickSubmitBtn();
	}

	//methods- setters and sendkeys
	public void setAge(){
		//generate random number between 20-40
		this.age = BrowserUtils.generateRandomNumber(20) + 20;
		System.out.println("age : " + age);
		BrowserUtils.sendKeysWithWait(ageField, this.age, 3);
		BrowserUtils.wait(0.5);
	}


	public void setHeightFt(){
		//generate random number between 5-7
		this.heightFt = BrowserUtils.generateRandomNumber(2) + 5;
		System.out.println("height feet : " + heightFt);
		BrowserUtils.sendKeysWithWait(heightFtField, this.heightFt, 3);
		BrowserUtils.wait(0.5);
	}

	public void setHeightInch(){
		//generate random number between 5-7
		this.heightInch = BrowserUtils.generateRandomNumber(2) + 5;
		System.out.println("height inch : " + heightInch);
		BrowserUtils.sendKeysWithWait(heightInchField, this.heightInch, 3);
		BrowserUtils.wait(0.5);
	}

	public void setWeight(){
		//generate random number between 300-500
		this.weight = BrowserUtils.generateRandomNumber(200) + 300;
		System.out.println("weight : " + weight);
		BrowserUtils.sendKeysWithWait(weightField, this.weight, 3);
		BrowserUtils.wait(0.5);
	}

	public void setTargetWeight(){
		//weight - 50
		this.targetWeight = weight - 50;
		System.out.println("target weight : " + targetWeight);
		BrowserUtils.sendKeysWithWait(targetWeightField, this.targetWeight, 3);
		BrowserUtils.wait(0.5);
	}

	public void clickSubmitBtn(){
		BrowserUtils.clickWithWait(submitBtn,3);
	}

	//methods- getters
	public int getAge() {
		return age;
	}

	public int getHeightFt() {
		return heightFt;
	}

	public int getHeightInch() {
		return heightInch;
	}

	public int getWeight() {
		return weight;
	}

	public int getTargetWeight() {
		return targetWeight;
	}

}
