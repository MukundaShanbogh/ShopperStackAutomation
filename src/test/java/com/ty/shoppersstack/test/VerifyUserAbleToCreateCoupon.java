package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.VoucherPage;

public class VerifyUserAbleToCreateCoupon extends BaseTest {
	private HomePage homePage;
	private VoucherPage voucherPage;

	@Test
	public void verifyUserAbleToAddProductToCart() {
		initializeInstance();

		homePage.clickOnVoucher();
		voucherPage.switchToChildWindow();
		voucherPage.clickAndEnterEmail();
		voucherPage.clickAndEnterPassword();
		voucherPage.clickOnLogin();

		voucherPage.clickAndEnterEmailInCoupon();
		voucherPage.clickAndEnterFullName();
		voucherPage.clickAndEnterCost();
		voucherPage.clickAndEnterStatDate();
		voucherPage.clickAndEnterEndDate();
		voucherPage.clickOnApplication();
		voucherPage.selectApplication();
		voucherPage.clickAndEnterVoucherCount();
		voucherPage.clickOnGenerate();
		voucherPage.clickOnLogout();
		voucherPage.switchToParentWindow();
	}

	public void initializeInstance() {
		homePage = new HomePage(getDriver(), getDriverAction());
		voucherPage = new VoucherPage(getDriver(), getDriverAction());
	}
}
