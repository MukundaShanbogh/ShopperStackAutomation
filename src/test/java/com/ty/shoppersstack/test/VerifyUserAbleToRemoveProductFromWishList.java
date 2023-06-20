package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.AccountSettingPage;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.WishListPage;

public class VerifyUserAbleToRemoveProductFromWishList extends BaseTest {
	private HomePage homePage;
	private WishListPage wishListPage;
	private AccountSettingPage settingPage;

	@Test
	public void verifyUserAbleToAddProductToCart() {
		initializeInstance();
		homePage.clickOnWishListIcon();
		homePage.clickOnAccountSetting();
		settingPage.clickOnWishList();
		wishListPage.verifyProductAdded();
	}

	public void initializeInstance() {
		homePage = new HomePage(getDriver(), getDriverAction());
		settingPage = new AccountSettingPage(getDriver(), getDriverAction());
		wishListPage = new WishListPage(getDriver(), getDriverAction());
	}
}
