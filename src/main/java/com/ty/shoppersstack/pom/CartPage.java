package com.ty.shoppersstack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ty.shoppersstack.common.DriverAction;

public class CartPage {
	private DriverAction driverAction;
	private WebDriver driver;

	@FindBy(xpath = "//span[.='Buy Now']")
	private WebElement buyNowBtn;

	@FindBy(xpath = "//div[@class='cart_productDetails__pKWBd']")
	private WebElement cartItem;

	@FindBy(xpath = "//*[@id='increase']")
	private WebElement plusIcon;

	@FindBy(xpath = "//*[@id='decrease']")
	private WebElement minusIcon;

	@FindBy(xpath = "//button[text()='Remove from cart']")
	private WebElement removeFromCartBtn;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesPopUp;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelPopUp;

	public CartPage(WebDriver driver, DriverAction driverAction) {
		this.driverAction = driverAction;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnBuyNow() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(buyNowBtn, driver);
		Assert.assertEquals(actualElement, buyNowBtn);
		driverAction.clickOn(buyNowBtn);
	}

	public void clickOnCartItem() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(cartItem, driver);
		Assert.assertEquals(actualElement, cartItem);
		driverAction.clickOn(cartItem);
	}

	public void increaseQuantity() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(plusIcon, driver);
		Assert.assertEquals(actualElement, plusIcon);
		for (int i = 1; i <= 3; i++) {
			driverAction.clickOn(plusIcon);
			driverAction.delayBetweenSteps();
		}
	}

	public void decreaseQuantity() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(minusIcon, driver);
		Assert.assertEquals(actualElement, minusIcon);
		for (int i = 1; i <= 3; i++) {
			driverAction.clickOn(minusIcon);
			driverAction.delayBetweenSteps();
		}
	}

	public void removeFromCart() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(removeFromCartBtn, driver);
		Assert.assertEquals(actualElement, removeFromCartBtn);
		driverAction.clickOn(removeFromCartBtn);
	}

	public void clickOnPopUp() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(yesPopUp, driver);
		Assert.assertEquals(actualElement, yesPopUp);
		driverAction.clickOn(yesPopUp);
	}
}
