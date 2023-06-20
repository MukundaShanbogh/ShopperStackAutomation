package com.ty.shoppersstack.test;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.HomePage;

public class VerifyUserAbleToSearchProduct extends BaseTest {
	private HomePage homePage;

	@Test
	public void verifyUserAbleToViewOrderedProduct() {

		initializeInstances();

		homePage.clickOnSearch();
		homePage.clickOnSearchIcon();
	}

	public void initializeInstances() {
		homePage = new HomePage(getDriver(), getDriverAction());
	}
}