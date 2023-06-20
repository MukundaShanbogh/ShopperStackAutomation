package com.ty.shoppersstack.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.ty.shoppersstack.common.DriverAction;

public class VoucherPage {

	private WebDriver driver;
	private DriverAction driverAction;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTextFiled;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTextFiled;

	@FindBy(xpath = "//button[text()='login']")
	private WebElement loginBtn;

	@FindBy(xpath = " //form[@class='dashboard_formBlock__GP3eQ MuiBox-root css-0']/div[1]/div/input")
	private WebElement couponEmailTextFiled;

	@FindBy(xpath = " //form[@class='dashboard_formBlock__GP3eQ MuiBox-root css-0']/div[2]/div/input")
	private WebElement fullnameTextField;

	@FindBy(xpath = " //form[@class='dashboard_formBlock__GP3eQ MuiBox-root css-0']/div[3]/div/input")
	private WebElement costTextFiled;

	@FindBy(xpath = "//input[@id='startDate']")
	private WebElement startDate;

	@FindBy(xpath = "//input[@id='endDate']")
	private WebElement expiryDate;

	@FindBy(xpath = "//div[@id='demo-simple-select']")
	private WebElement applicationNameDropDown;

	@FindBy(xpath = "//li[text()='ShoppingKart']")
	private WebElement applicationName;

	@FindBy(xpath = "//input[@placeholder='Number of vouchers to generate']")
	private WebElement voucherCountTextFiled;

	@FindBy(xpath = "//button[text()='Generate']")
	private WebElement generateBtn;

	@FindBy(xpath = "//button[text()='logout']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//a[@href='/view-coupons']")
	private WebElement viewCouponLink;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextFiled;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchBtn;

	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div")
	private List<WebElement> couponList;

	public VoucherPage(WebDriver driver, DriverAction driverAction) {
		this.driver = driver;
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void clickAndEnterEmail() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(emailTextFiled, driver);
		Assert.assertEquals(actualElement, emailTextFiled);
		driverAction.enterTextInto(emailTextFiled, "imtiyaz1787@gmail.com");
	}

	public void clickAndEnterPassword() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(passwordTextFiled, driver);
		Assert.assertEquals(actualElement, passwordTextFiled);
		driverAction.enterTextInto(passwordTextFiled, "Imtiyaz@123");
	}

	public void clickOnLogin() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(loginBtn, driver);
		Assert.assertEquals(actualElement, loginBtn);
		driverAction.clickOn(loginBtn);
		driverAction.delayBetweenSteps();
	}

	public void clickAndEnterEmailInCoupon() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(couponEmailTextFiled, driver);
		Assert.assertEquals(actualElement, couponEmailTextFiled);
		driverAction.enterTextInto(couponEmailTextFiled, "imtiyaz1787@gmail.com");
	}

	public void clickAndEnterFullName() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(fullnameTextField, driver);
		Assert.assertEquals(actualElement, fullnameTextField);
		driverAction.enterTextInto(fullnameTextField, "Ralido");
	}

	public void clickAndEnterCost() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(costTextFiled, driver);
		Assert.assertEquals(actualElement, costTextFiled);
		driverAction.enterTextInto(costTextFiled, "5000.00");
	}

	public void clickAndEnterStatDate() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(startDate, driver);
		Assert.assertEquals(actualElement, startDate);
		driverAction.enterTextInto(startDate, "13062023	");
		driverAction.enterTextInto(startDate, "0000");
	}

	public void clickAndEnterEndDate() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(expiryDate, driver);
		Assert.assertEquals(actualElement, expiryDate);
		driverAction.enterTextInto(expiryDate, "13082023	");
		driverAction.enterTextInto(expiryDate, "0000");
	}

	public void clickOnApplication() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(applicationNameDropDown, driver);
		Assert.assertEquals(actualElement, applicationNameDropDown);
		driverAction.clickOn(applicationNameDropDown);
	}

	public void selectApplication() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(applicationName, driver);
		Assert.assertEquals(actualElement, applicationName);
		driverAction.clickOn(applicationName);
	}

	public void clickAndEnterVoucherCount() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(voucherCountTextFiled, driver);
		Assert.assertEquals(actualElement, voucherCountTextFiled);
		driverAction.enterTextInto(voucherCountTextFiled, "5");
	}

	public void clickOnGenerate() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(generateBtn, driver);
		Assert.assertEquals(actualElement, generateBtn);
		driverAction.clickOn(generateBtn);
		driverAction.delayBetweenSteps();
	}

	public void switchToChildWindow() {
		List<String> listOfAllWindows = new ArrayList<String>(driver.getWindowHandles());
		String parentWindow = driver.getWindowHandle();
		driverAction.switchToChildWindow(listOfAllWindows, parentWindow, driver);
	}

	public void switchToParentWindow() {
		List<String> listOfAllWindows = new ArrayList<String>(driver.getWindowHandles());
		String childWindow = driver.getWindowHandle();
		driverAction.switchToParentWindow(listOfAllWindows, childWindow, driver);
	}

	public void clickOnLogout() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(logoutBtn, driver);
		Assert.assertEquals(actualElement, logoutBtn);
		driverAction.clickOn(logoutBtn);
	}

	public void clickOnViewCoupon() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(viewCouponLink, driver);
		Assert.assertEquals(actualElement, viewCouponLink);
		driverAction.clickOn(viewCouponLink);
	}

	public void clickAndEnterSearch() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(searchTextFiled, driver);
		Assert.assertEquals(actualElement, searchTextFiled);
		driverAction.enterTextInto(searchTextFiled, "imtiyaz1787@gmail.com");
	}

	public void clickOnSearch() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(searchBtn, driver);
		Assert.assertEquals(actualElement, searchBtn);
		driverAction.clickOn(searchBtn);
		driverAction.delayBetweenSteps();
	}

	public void couponList() {
		for (WebElement element : couponList) {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(element.getText().contains("imtiyaz1787@gmail.com"), true);
			softAssert.assertAll();
			Reporter.log("Coupon Found", true);
			break;
		}
	}
}
