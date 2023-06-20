package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.AccountSettingPage;
import com.ty.shoppersstack.pom.AddressPage;
import com.ty.shoppersstack.pom.CartPage;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.PaymentPage;
import com.ty.shoppersstack.pom.WishListPage;

public class VerifyUserAbleToPlaceOrder extends BaseTest {
	private HomePage homePage;
	private AccountSettingPage settingPage;
	private WishListPage wishListPage;
	private CartPage cartPage;
	private AddressPage addressPage;
	private PaymentPage paymentPage;

	@Test
	public void verifyUserIsAbleToPlaceOrder() {

		initializeInstances();
		
		// add product to wishlist
		homePage.clickOnWishListIcon();
		homePage.clickOnAccountSetting();
		settingPage.clickOnWishList();
		wishListPage.addToCart();

		// continue & place an order
		homePage.clickOnCartIcon();
		cartPage.clickOnBuyNow();
		addressPage.clickOnAddNewAddress();
		addressPage.clickAndEnterName();
		addressPage.clickAndEnterHouseInfo();
		addressPage.clickAndEnterStreetInfo();
		addressPage.clickAndEnterLandmark();
		addressPage.selectCountry();
		addressPage.selectState();
		addressPage.selectCity();
		addressPage.clickOnInfoIcon();
		addressPage.choosePinCode();
		addressPage.clickAndEnterPhoneNum();
		addressPage.clickOnAddAddress();
		addressPage.chooseAddress();
		addressPage.clickOnProceed();

		paymentPage.clickOnCOD();
		paymentPage.clickOnProceed();
	}

	public void initializeInstances() {
		homePage = new HomePage(getDriver(), getDriverAction());
		settingPage = new AccountSettingPage(getDriver(), getDriverAction());
		wishListPage = new WishListPage(getDriver(), getDriverAction());
		cartPage = new CartPage(getDriver(), getDriverAction());
		addressPage = new AddressPage(getDriver(), getDriverAction());
		paymentPage = new PaymentPage(getDriver(), getDriverAction());
	}
}
