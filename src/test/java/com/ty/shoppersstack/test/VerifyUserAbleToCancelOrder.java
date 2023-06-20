package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.AccountSettingPage;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.MyOrderPage;

public class VerifyUserAbleToCancelOrder extends BaseTest {

	private HomePage homePage;
	private AccountSettingPage settingPage;
	private MyOrderPage orderPage;

	@Test
	public void verifyUserAbleToCancelOrder() {

		initializeInstance();

		homePage.clickOnAccountSetting();
		settingPage.clickOnMyOrders();
		orderPage.cancelOrder();
	}

	public void initializeInstance() {
		homePage = new HomePage(getDriver(), getDriverAction());
		settingPage = new AccountSettingPage(getDriver(), getDriverAction());
		orderPage = new MyOrderPage(getDriver(), getDriverAction());
	}
}
