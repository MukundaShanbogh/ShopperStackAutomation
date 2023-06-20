package com.ty.shoppersstack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ty.shoppersstack.common.DriverAction;

public class ProductDescriptionPage {

	private WebDriver driver;
	private DriverAction driverAction;

	@FindBy(xpath = "//span[.='buy now']")
	private WebElement buyNowBtn;

	public ProductDescriptionPage(WebDriver driver, DriverAction driverAction) {
		this.driver = driver;
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void clickOnBuyNow() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(buyNowBtn, driver);
		Assert.assertEquals(actualElement, buyNowBtn);
		driverAction.clickOn(buyNowBtn);
	}
}
