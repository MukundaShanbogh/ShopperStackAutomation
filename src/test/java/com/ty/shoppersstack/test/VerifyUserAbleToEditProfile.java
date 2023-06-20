package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.AccountSettingPage;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.MyProfilePage;

public class VerifyUserAbleToEditProfile extends BaseTest {

	private HomePage homePage;
	private AccountSettingPage settingPage;
	private MyProfilePage profilePage;

	@Test
	public void verifyUserIsAbleToEditProfile() {

		initializeInstance();

		homePage.clickOnAccountSetting();
		settingPage.clickOnMyProfile();
		profilePage.clickOnEditProfile();
		profilePage.clearAndEnterFirstName();
		profilePage.clearAndEnterLastName();
		profilePage.clearAndEnterDob();
		profilePage.clearAndEnterPhoneNum();
		profilePage.selectCountry();
		profilePage.selectState();
		profilePage.selectCity();
		profilePage.clickOnSubmit();
		profilePage.clickOnOk();
	}

	public void initializeInstance() {
		homePage = new HomePage(getDriver(), getDriverAction());
		settingPage = new AccountSettingPage(getDriver(), getDriverAction());
		profilePage = new MyProfilePage(getDriver(), getDriverAction());
	}
}
