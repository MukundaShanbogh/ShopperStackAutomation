package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.CartPage;
import com.ty.shoppersstack.pom.HomePage;

public class VerifyUserAbleToAddProductToCart extends BaseTest {
	private HomePage homePage;
	private CartPage cartPage;

	@Test
	public void verifyUserAbleToAddProductToCart() {
		initializeInstance();

		homePage.moveToWomenSection();
		homePage.clickOnTshirt();
		homePage.clickOnAddToCart();
		homePage.clickOnCartIcon();
		cartPage.increaseQuantity();
		cartPage.decreaseQuantity();
		cartPage.removeFromCart();
		cartPage.clickOnPopUp();
	}

	public void initializeInstance() {
		homePage = new HomePage(getDriver(), getDriverAction());
		cartPage = new CartPage(getDriver(), getDriverAction());
	}
}
