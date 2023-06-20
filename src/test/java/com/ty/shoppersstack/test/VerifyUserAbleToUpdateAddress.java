package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.AccountSettingPage;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.MyAddressPage;

public class VerifyUserAbleToUpdateAddress extends BaseTest {

	private HomePage homePage;
	private AccountSettingPage settingPage;
	private MyAddressPage addressPage;

	@Test
	public void verifyUserAbleToUpdateAddress() {

		initializeInstance();

		homePage.clickOnAccountSetting();
		settingPage.clickOnMyProfile();
		addressPage.clickOnMyAddress();
		addressPage.clickOnEditAddress();
		addressPage.clickAndEnterName();
		addressPage.clickAndEnterHouseInfo();
		addressPage.clickAndEnterStreetInfo();
		addressPage.clickAndEnterLandmark();
		addressPage.clickOnCountry();
		addressPage.selectCountry();
		addressPage.clickOnState();
		addressPage.selectState();
		addressPage.clickOnCity();
		addressPage.selectCity();
		addressPage.clickOnInfoIcon();
		addressPage.choosePinCode();
		addressPage.clickAndEnterPhoneNum();
		addressPage.clickOnUpdateAddress();

	}

	public void initializeInstance() {
		homePage = new HomePage(getDriver(), getDriverAction());
		settingPage = new AccountSettingPage(getDriver(), getDriverAction());
		addressPage = new MyAddressPage(getDriver(), getDriverAction());
	}
}
