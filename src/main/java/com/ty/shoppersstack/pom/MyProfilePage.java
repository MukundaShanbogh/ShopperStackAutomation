package com.ty.shoppersstack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ty.shoppersstack.common.DriverAction;

public class MyProfilePage {

	private DriverAction driverAction;
	private WebDriver driver;

	@FindBy(xpath = "//button[contains(.,'Edit Profile')]")
	private WebElement editProfile;

	@FindBy(xpath = "//input[@id='First Name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='Last Name']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='mm/dd/yyyy']")
	private WebElement dob;

	@FindBy(xpath = "//input[@id='Phone Number']")
	private WebElement phoneNum;

	@FindBy(xpath = "//select[@id='Country']")
	private WebElement country;

	@FindBy(xpath = "//select[@id='State']")
	private WebElement state;

	@FindBy(xpath = "//select[@id='City']")
	private WebElement city;

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement submitBtn;

	public MyProfilePage(WebDriver driver, DriverAction driverAction) {
		this.driver = driver;
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void clickOnEditProfile() {
		driverAction.clickOn(editProfile);
	}

	public void clearAndEnterFirstName() {
		driverAction.clearTextFrom(firstName);
		driverAction.enterTextInto(firstName, "Dinesh");
	}

	public void clearAndEnterLastName() {
		driverAction.clearTextFrom(lastName);
		driverAction.enterTextInto(lastName, "Kumar");
	}

	public void clearAndEnterDob() {
		driverAction.clearTextFrom(dob);
		driverAction.enterTextInto(dob, "02/01/1998");
	}

	public void clearAndEnterPhoneNum() {
		driverAction.clearTextFrom(phoneNum);
		driverAction.enterTextInto(phoneNum, "9876543210");
	}

	public void selectCountry() {
		driverAction.selectByValue(country, "Canada");
	}

	public void selectState() {
		driverAction.selectByValue(state, "Alberta");
	}

	public void selectCity() {
		driverAction.selectByValue(city, "Blackfalds");
	}

	public void clickOnSubmit() {
		driverAction.clickOn(submitBtn);
	}

	public void clickOnOk() {
		driverAction.clickOnOkAlertPopup(driver);
	}
}
