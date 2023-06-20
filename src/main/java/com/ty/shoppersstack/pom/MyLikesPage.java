package com.ty.shoppersstack.pom;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.ty.shoppersstack.common.DriverAction;

public class MyLikesPage {

	private WebDriver driver;
	private DriverAction driverAction;

	@FindBy(xpath = "//div[.='My Likes']")
	private WebElement myLikesLink;

	@FindBy(xpath = "(//div[@class='profile_likesBlock__G8PwX']//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[1]")
	private WebElement deleteMyLikes;

	@FindBy(xpath = "//select[@id='Category']")
	private WebElement selectCategory;

	@FindBy(xpath = "//select[@name='Category Type']/option")
	private List<WebElement> selectSubCategory;

	@FindBy(xpath = "//button[@id='Submit']")
	private WebElement submitBtn;

	public MyLikesPage(WebDriver driver, DriverAction driverAction) {
		this.driver = driver;
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyLikes() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(myLikesLink, driver);
		Assert.assertEquals(actualElement, myLikesLink);
		driverAction.clickOn(myLikesLink);
	}

	public void selectCategory() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(selectCategory, driver);
		Assert.assertEquals(actualElement, selectCategory);
		driverAction.selectByValue(selectCategory, "men");
	}

	public void selectSubCategory() {
		List<String> values = Arrays.asList("Jacket", "Shirt");
		for (String value : values) {
			driverAction.multiSelectValues(selectSubCategory, value);
		}
	}

	public void clickOnSubmit() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(submitBtn, driver);
		Assert.assertEquals(actualElement, submitBtn);
		driverAction.clickOn(submitBtn);
	}

	public void clickOnDeleteLikes() {
		boolean found = false;
		try {
			while (deleteMyLikes.isDisplayed()) {
				driverAction.clickOn(deleteMyLikes);
				found = true;
				driverAction.delayBetweenSteps();
			}
		} catch (Exception e) {
			if (!found) {
				Reporter.log("There are no liked products", true);
			}
		}
	}
}
