package com.ty.shoppersstack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ty.shoppersstack.common.DriverAction;

public class AccountSettingPage {

	private DriverAction driverAction;

	@FindBy(xpath = "//li[.='My Profile']")
	private WebElement myProfile;

	@FindBy(xpath = "//li[.='Wish List']")
	private WebElement wishList;

	@FindBy(xpath = "//li[.='My Orders']")
	private WebElement myOrders;

	@FindBy(xpath = "//li[.='My Wallet']")
	private WebElement myWallet;

	@FindBy(xpath = "//li[.='My Likes']")
	private WebElement myLikes;

	@FindBy(xpath = "//li[.='Logout']")
	private WebElement logout;

	public AccountSettingPage(WebDriver driver, DriverAction driverAction) {
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyProfile() {
		driverAction.clickOn(myProfile);
	}

	public void clickOnLogout() {
		driverAction.clickOn(logout);
	}

	public void clickOnWishList() {
		driverAction.clickOn(wishList);
	}

	public void clickOnMyOrders() {
		driverAction.clickOn(myOrders);
	}
}
