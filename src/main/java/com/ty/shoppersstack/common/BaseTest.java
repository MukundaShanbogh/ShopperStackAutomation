package com.ty.shoppersstack.common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ty.shoppersstack.pom.AccountSettingPage;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	private DriverAction driverAction;

	@BeforeMethod
	public void launchApp() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(CommonConstant.WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(CommonConstant.URL);
		driverAction = new DriverAction();
	}

	@BeforeMethod(dependsOnMethods = "launchApp")
	public void loginToApp() throws IOException {
		LoginPage loginPage = new LoginPage(driver);

		WebElement actualElement = driverAction.waitUntilElementIsClickable(loginPage.getHomePageLoginBtn(), driver);
		Assert.assertEquals(actualElement, loginPage.getHomePageLoginBtn());

		driverAction.clickOn(loginPage.getHomePageLoginBtn(), driver);
		ExcelLibrary el = new ExcelLibrary();
		String email = el.readExcel(CommonConstant.CREDENTIAL_SHEET, 1, 0);
		String password = el.readExcel(CommonConstant.CREDENTIAL_SHEET, 1, 1);

		driverAction.enterTextInto(loginPage.getEmailTextFiled(), email);
		driverAction.enterTextInto(loginPage.getPasswordTextFiled(), password);
		driverAction.clickOn(loginPage.getLoginBtn());
		driverAction.delayBetweenSteps();

		Assert.assertEquals(CommonConstant.SHOPPERS_STACK_TITLE, driver.getTitle());
	}

	@AfterMethod(dependsOnMethods = "logoutFromApp")
	public void closeApp() {
		driver.quit();
	}

	@AfterMethod
	public void logoutFromApp() {
		HomePage homePage = new HomePage(driver, driverAction);
		AccountSettingPage settingPage = new AccountSettingPage(getDriver(), getDriverAction());

		WebElement actualElement = driverAction.waitUntilElementIsClickable(homePage.getAccountSettingIcon(), driver);
		Assert.assertEquals(actualElement, homePage.getAccountSettingIcon());

		homePage.clickOnAccountSetting();
		settingPage.clickOnLogout();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public DriverAction getDriverAction() {
		return driverAction;
	}
}
