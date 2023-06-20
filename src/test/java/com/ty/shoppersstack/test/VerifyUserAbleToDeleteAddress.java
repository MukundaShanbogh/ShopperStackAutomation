package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.AccountSettingPage;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.MyAddressPage;

public class VerifyUserAbleToDeleteAddress extends BaseTest {

	private HomePage homePage;
	private AccountSettingPage settingPage;
	private MyAddressPage addressPage;

	@Test
	public void verifyUserAbleToUpdateAddress() {

		initializeInstance();

		homePage.clickOnAccountSetting();
		settingPage.clickOnMyProfile();
		addressPage.clickOnMyAddress();
		addressPage.clickOnDelete();
		addressPage.clickOnDeleteConfirmation();

	}

	public void initializeInstance() {
		homePage = new HomePage(getDriver(), getDriverAction());
		settingPage = new AccountSettingPage(getDriver(), getDriverAction());
		addressPage = new MyAddressPage(getDriver(), getDriverAction());
	}
}
