package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.VoucherPage;

public class VerifyUserAbleToSearchCoupon extends BaseTest {
	private HomePage homePage;
	private VoucherPage voucherPage;

	@Test
	public void verifyUserAbleToSearchCoupon() {
		initializeInstance();

		homePage.clickOnVoucher();
		voucherPage.switchToChildWindow();
		voucherPage.clickAndEnterEmail();
		voucherPage.clickAndEnterPassword();
		voucherPage.clickOnLogin();

		voucherPage.clickOnViewCoupon();
		voucherPage.clickAndEnterSearch();
		voucherPage.clickOnSearch();
		voucherPage.couponList();
		voucherPage.clickOnLogout();
		voucherPage.switchToParentWindow();
	}

	public void initializeInstance() {
		homePage = new HomePage(getDriver(), getDriverAction());
		voucherPage = new VoucherPage(getDriver(), getDriverAction());
	}
}
