package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.AccountSettingPage;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.MyLikesPage;

public class VerifyUserAbleToDeleteLikedProduct extends BaseTest {
	private HomePage homePage;
	private AccountSettingPage settingPage;
	private MyLikesPage likesPage;

	@Test
	public void verifyUserAbleToDeleteLikedProduct() {

		initializeInstances();

		homePage.clickOnAccountSetting();
		settingPage.clickOnMyProfile();
		likesPage.clickOnMyLikes();
		likesPage.clickOnDeleteLikes();
	}

	public void initializeInstances() {
		homePage = new HomePage(getDriver(), getDriverAction());
		settingPage = new AccountSettingPage(getDriver(), getDriverAction());
		likesPage = new MyLikesPage(getDriver(), getDriverAction());
	}
}