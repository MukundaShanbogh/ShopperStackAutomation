package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.AddressPage;
import com.ty.shoppersstack.pom.CartPage;
import com.ty.shoppersstack.pom.HelpPage;
import com.ty.shoppersstack.pom.HomePage;
import com.ty.shoppersstack.pom.PaymentPage;

public class VerifyUserAbleToPlaceOrderFromCreditCard extends BaseTest {
	private HomePage homePage;
	private CartPage cartPage;
	private AddressPage addressPage;
	private PaymentPage paymentPage;
	private HelpPage helpPage;

	@Test
	public void verifyUserAbleToPlaceOrderFromCreditCard() {

		initializeInstances();
		homePage.clickOnHelpCenter();
		homePage.switchToChildWindow();
		helpPage.clickOnCreditCard();
		helpPage.addBankIfNotAdded("TBI");
		helpPage.captureCardDetails("TDFC");
		homePage.switchToParentWindow();
		homePage.moveToWomenSection();
		homePage.clickOnTshirt();
		homePage.clickOnAddToCart();
		homePage.clickOnCartIcon();
		cartPage.clickOnBuyNow();
		addressPage.chooseAddress();
		addressPage.clickOnProceed();

		paymentPage.loadCardDetails(helpPage.getCard());
		paymentPage.clickOnAddCard();
		paymentPage.clickAndEnterName();
		paymentPage.clickAndEnterCardNum();
		paymentPage.clickAndEnterPin();
		paymentPage.clickAndEnterExpiryMonth();
		paymentPage.clickAndEnterExpiryYear();
		paymentPage.clickAndEnterCvv();
		paymentPage.clickOnCardType();
		paymentPage.clickOnAdd();
		paymentPage.clickSavedCard();
		paymentPage.reEnterPin();
		paymentPage.clickOnSubmit();
		paymentPage.clickOnProceed();

	}

	public void initializeInstances() {
		homePage = new HomePage(getDriver(), getDriverAction());
		cartPage = new CartPage(getDriver(), getDriverAction());
		addressPage = new AddressPage(getDriver(), getDriverAction());
		paymentPage = new PaymentPage(getDriver(), getDriverAction());
		helpPage = new HelpPage(getDriver(), getDriverAction());
	}
}
