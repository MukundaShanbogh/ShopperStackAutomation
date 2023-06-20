package com.ty.shoppersstack.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ty.shoppersstack.common.DriverAction;

public class MyAddressPage {

	private DriverAction driverAction;
	private WebDriver driver;

	@FindBy(xpath = "//div[.='My Addresses']")
	private WebElement myAddressLink;

	@FindBy(xpath = "//A[@href='/editaddress/16424']/BUTTON[@type='button']")
	private WebElement editBtn;

	@FindBy(xpath = "//DIV[@class='addressListContainer']/DIV[1]/DIV[2]/DIV/BUTTON[@type='button']")
	private WebElement deleteBtn;

	@FindBy(xpath = "(//button[text()='Yes'])[1]")
	private WebElement deleteConfirmation;

	@FindBy(xpath = "//input[@id='Name']")
	private WebElement nameTextField;

	@FindBy(xpath = "//input[@id='House/Office Info']")
	private WebElement houseNoTextField;

	@FindBy(xpath = "//input[@id='Street Info']")
	private WebElement streetInfoTextField;

	@FindBy(xpath = "//input[@id='Landmark']")
	private WebElement landkmarkTextField;

	@FindBy(xpath = "//div[@id='Country']")
	private WebElement country;

	@FindBy(xpath = "//div[@id='State']")
	private WebElement state;

	@FindBy(xpath = "//div[@id='City']")
	private WebElement city;

	@FindBy(xpath = "//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-s6jlyw\"]")
	private WebElement deliverablePincodeInfo;

	@FindBy(xpath = "/html/body/div[3]/div[3]/section/div/table/tbody/tr[7]/td[2]")
	private WebElement deliverablePinCode;

	@FindBy(xpath = "//input[@id='Pincode']")
	private WebElement pincodeTextFiled;

	@FindBy(xpath = "//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-s6jlyw'][@data-testid='CloseIcon']")
	private WebElement closeDeliverablePinCode;

	@FindBy(xpath = "//input[@id='Phone Number']")
	private WebElement phoneNumberTextField;

	@FindBy(xpath = "//button[@id='Update Address']")
	private WebElement updateAddressBtn;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	private List<WebElement> listOfCountries;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	private List<WebElement> listOfStates;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	private List<WebElement> listOfCities;

	public MyAddressPage(WebDriver driver, DriverAction driverAction) {
		this.driver = driver;
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyAddress() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(myAddressLink, driver);
		Assert.assertEquals(actualElement, myAddressLink);
		driverAction.clickOn(myAddressLink);
	}

	public void clickOnEditAddress() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(editBtn, driver);
		Assert.assertEquals(actualElement, editBtn);
		driverAction.clickOn(editBtn);
	}

	public void clickAndEnterName() {
		driverAction.clearTextFrom(nameTextField);
		WebElement actualElement = driverAction.waitUntilElementIsVisible(nameTextField, driver);
		Assert.assertEquals(actualElement, nameTextField);
		driverAction.enterTextInto(nameTextField, "Imtiyaz Ahmed");
	}

	public void clickAndEnterStreetInfo() {
		driverAction.clearTextFrom(streetInfoTextField);
		WebElement actualElement = driverAction.waitUntilElementIsVisible(streetInfoTextField, driver);
		Assert.assertEquals(actualElement, streetInfoTextField);
		driverAction.enterTextInto(streetInfoTextField, "20th Main");
	}

	public void clickAndEnterLandmark() {
		driverAction.clearTextFrom(landkmarkTextField);
		WebElement actualElement = driverAction.waitUntilElementIsVisible(landkmarkTextField, driver);
		Assert.assertEquals(actualElement, landkmarkTextField);
		driverAction.enterTextInto(landkmarkTextField, "Nimra Masjid");
	}

	public void clickAndEnterHouseInfo() {
		driverAction.clearTextFrom(houseNoTextField);
		WebElement actualElement = driverAction.waitUntilElementIsVisible(houseNoTextField, driver);
		Assert.assertEquals(actualElement, houseNoTextField);
		driverAction.enterTextInto(houseNoTextField, "403");
	}

	public void clickOnCountry() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(country, driver);
		Assert.assertEquals(actualElement, country);
		driverAction.clickOn(actualElement);
	}

	public void clickOnState() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(state, driver);
		Assert.assertEquals(actualElement, state);
		driverAction.clickOn(actualElement);
	}

	public void clickOnCity() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(city, driver);
		Assert.assertEquals(actualElement, city);
		driverAction.clickOn(actualElement);
	}

	public void clickOnInfoIcon() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(deliverablePincodeInfo, driver);
		Assert.assertEquals(actualElement, deliverablePincodeInfo);
		driverAction.clickOn(deliverablePincodeInfo);
	}

	public void choosePinCode() {
		String pincode = deliverablePinCode.getText();

		WebElement actualElement = driverAction.waitUntilElementIsClickable(closeDeliverablePinCode, driver);
		Assert.assertEquals(actualElement, closeDeliverablePinCode);
		driverAction.clickOn(closeDeliverablePinCode);

		driverAction.clearTextFrom(pincodeTextFiled);
		actualElement = driverAction.waitUntilElementIsVisible(pincodeTextFiled, driver);
		Assert.assertEquals(actualElement, pincodeTextFiled);
		driverAction.enterTextInto(pincodeTextFiled, pincode);
	}

	public void clickAndEnterPhoneNum() {
		driverAction.clearTextFrom(phoneNumberTextField);
		WebElement actualElement = driverAction.waitUntilElementIsVisible(phoneNumberTextField, driver);
		Assert.assertEquals(actualElement, phoneNumberTextField);
		driverAction.enterTextInto(phoneNumberTextField, "9986988436");
	}

	public void clickOnUpdateAddress() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(updateAddressBtn, driver);
		Assert.assertEquals(actualElement, updateAddressBtn);
		driverAction.clickOn(updateAddressBtn);
	}

	public void selectCountry() {
		driverAction.singleSelectValues(listOfCountries, "India");
	}

	public void selectState() {
		driverAction.singleSelectValues(listOfStates, "Karnataka");
	}

	public void selectCity() {
		driverAction.singleSelectValues(listOfCities, "Bengaluru");
	}

	public void clickOnDelete() {
		driverAction.clickOn(deleteBtn);
	}

	public void clickOnDeleteConfirmation() {
		driverAction.clickOn(deleteConfirmation);
		driverAction.clickOnOkAlertPopup(driver);
	}
}
