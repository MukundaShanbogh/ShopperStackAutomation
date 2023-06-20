package com.ty.shoppersstack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ty.shoppersstack.common.DriverAction;

public class AddressPage {

	private DriverAction driverAction;
	private WebDriver driver;

	@FindBy(xpath = "//span[.='Add New Address']")
	private WebElement addNewAddressBtn;

	@FindBy(xpath = "//input[@id='Name']")
	private WebElement nameTextField;

	@FindBy(xpath = "//input[@id='House/Office Info']")
	private WebElement houseNoTextField;

	@FindBy(xpath = "//input[@id='Street Info']")
	private WebElement streetInfoTextField;

	@FindBy(xpath = "//input[@id='Landmark']")
	private WebElement landkmarkTextField;

	@FindBy(xpath = "//select[@id='Country']")
	private WebElement country;

	@FindBy(xpath = "//select[@id='State']")
	private WebElement state;

	@FindBy(xpath = "//select[@id='City']")
	private WebElement city;

	@FindBy(xpath = "//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-s6jlyw\"]")
	private WebElement deliverablePincodeInfo;

	@FindBy(xpath = "//tbody[@class='MuiTableBody-root css-1xnox0e']/tr[1]/td[2]")
	private WebElement deliverablePinCode;

	@FindBy(xpath = "//input[@id='Pincode']")
	private WebElement pincodeTextFiled;

	@FindBy(xpath = "//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-s6jlyw'][@data-testid='CloseIcon']")
	private WebElement closeDeliverablePinCode;

	@FindBy(xpath = "//input[@id='Phone Number']")
	private WebElement phoneNumberTextField;

	@FindBy(xpath = "//button[@id='addAddress']")
	private WebElement addAddressBtn;

	@FindBy(xpath = "//div[@class='selectaddress_addresscont__x7PpQ']/div[2]/div[1] ")
	private WebElement chooseAddressRadioBtn;

	@FindBy(xpath = "//button[.='Proceed']")
	private WebElement proceedBtn;

	public AddressPage(WebDriver driver, DriverAction driverAction) {
		this.driver = driver;
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNewAddress() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(addNewAddressBtn, driver);
		Assert.assertEquals(actualElement, addNewAddressBtn);
		driverAction.clickOn(addNewAddressBtn);
	}

	public void clickAndEnterName() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(nameTextField, driver);
		Assert.assertEquals(actualElement, nameTextField);
		driverAction.enterTextInto(nameTextField, "Dinesh Kumar");
	}

	public void clickAndEnterStreetInfo() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(streetInfoTextField, driver);
		Assert.assertEquals(actualElement, streetInfoTextField);
		driverAction.enterTextInto(streetInfoTextField, "12th Main");
	}

	public void clickAndEnterLandmark() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(landkmarkTextField, driver);
		Assert.assertEquals(actualElement, landkmarkTextField);
		driverAction.enterTextInto(landkmarkTextField, "Central Mall");
	}

	public void clickAndEnterHouseInfo() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(houseNoTextField, driver);
		Assert.assertEquals(actualElement, houseNoTextField);
		driverAction.enterTextInto(houseNoTextField, "833");
	}

	public void selectCountry() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(country, driver);
		Assert.assertEquals(actualElement, country);
		driverAction.selectByValue(country, "Canada");
	}

	public void selectState() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(state, driver);
		Assert.assertEquals(actualElement, state);
		driverAction.selectByValue(state, "Alberta");
	}

	public void selectCity() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(city, driver);
		Assert.assertEquals(actualElement, city);
		driverAction.selectByValue(city, "Blackfalds");
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

		actualElement = driverAction.waitUntilElementIsVisible(pincodeTextFiled, driver);
		Assert.assertEquals(actualElement, pincodeTextFiled);
		driverAction.enterTextInto(pincodeTextFiled, pincode);
	}

	public String getPinCode() {
		return deliverablePinCode.getText();
	}

	public void clickAndEnterPincode(String pincode) {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(pincodeTextFiled, driver);
		Assert.assertEquals(actualElement, pincodeTextFiled);
		driverAction.enterTextInto(pincodeTextFiled, pincode);
	}

	public void clickAndEnterPhoneNum() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(phoneNumberTextField, driver);
		Assert.assertEquals(actualElement, phoneNumberTextField);
		driverAction.enterTextInto(phoneNumberTextField, "9876543210");
	}

	public void clickOnAddAddress() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(addAddressBtn, driver);
		Assert.assertEquals(actualElement, addAddressBtn);
		driverAction.clickOn(addAddressBtn);
	}

	public void chooseAddress() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(chooseAddressRadioBtn, driver);
		Assert.assertEquals(actualElement, chooseAddressRadioBtn);
		driverAction.clickOn(chooseAddressRadioBtn);
	}

	public void clickOnProceed() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(proceedBtn, driver);
		Assert.assertEquals(actualElement, proceedBtn);
		driverAction.clickOn(proceedBtn);
	}
}
