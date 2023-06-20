package com.ty.shoppersstack.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ty.shoppersstack.common.DriverAction;

public class HomePage {

	private DriverAction driverAction;
	private WebDriver driver;
	@FindBy(xpath = "//span[@class='BaseBadge-root MuiBadge-root css-1rzb3uu']")
	private WebElement accountSettingIcon;

	@FindBy(xpath = "//DIV[@class='featuredProducts_cardContainer__H+2m8']/DIV[1]/DIV[3]/DIV[2]/*[local-name()='svg']")
	private WebElement firstAvailableProductWishListIcon;

	@FindBy(xpath = "//a[@id='cart']")
	private WebElement cartIcon;

	@FindBy(xpath = "//a[.='Help Center']")
	private WebElement helpCenterLink;

	@FindBy(xpath = "//a[@href='https://voucher.shoppersstack.com']")
	private WebElement voucherLink;

	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchTextFiled;

	@FindBy(xpath = "//*[@id='searchBtn']")
	private WebElement searchIcon;

	@FindBy(xpath = "//a[@id='women']")
	private WebElement women;

	@FindBy(xpath = "//a[@href='/sub-category/women-tshirt']")
	private WebElement tShirt;

	@FindBy(xpath = "(//button[.='add to cart'])[1]")
	private WebElement addToCart;

	public HomePage(WebDriver driver, DriverAction driverAction) {
		this.driverAction = driverAction;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAccountSetting() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(accountSettingIcon, driver);
		Assert.assertEquals(actualElement, accountSettingIcon);
		driverAction.clickOn(accountSettingIcon, driver);
	}

	public void clickOnSearch() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(searchTextFiled, driver);
		Assert.assertEquals(actualElement, searchTextFiled);
		driverAction.enterTextInto(searchTextFiled, "electronics");
	}

	public void clickOnSearchIcon() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(searchIcon, driver);
		Assert.assertEquals(actualElement, searchIcon);
		driverAction.clickOn(actualElement);
		driverAction.scrollDownVertically(driver);
		driverAction.scrollUpVertically(driver);
	}

	public void clickOnWishListIcon() {
		driverAction.clickOn(firstAvailableProductWishListIcon);
	}

	public void clickOnCartIcon() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(cartIcon, driver);
		Assert.assertEquals(actualElement, cartIcon);
		driverAction.clickOn(cartIcon);
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getAccountSettingIcon() {
		return accountSettingIcon;
	}

	public void clickOnHelpCenter() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(helpCenterLink, driver);
		Assert.assertEquals(actualElement, helpCenterLink);
		driverAction.rightClick(helpCenterLink, driver);
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

	public void moveToWomenSection() {
		Actions actions = new Actions(driver);
		actions.moveToElement(women).perform();
	}

	public void clickOnTshirt() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(tShirt, driver);
		Assert.assertEquals(actualElement, tShirt);
		driverAction.clickOn(tShirt, driver);
	}

	public void clickOnAddToCart() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(addToCart, driver);
		Assert.assertEquals(actualElement, addToCart);
		driverAction.clickOn(addToCart, driver);
	}

	public void clickOnVoucher() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(voucherLink, driver);
		Assert.assertEquals(actualElement, voucherLink);
		driverAction.clickOn(voucherLink);
	}
}
