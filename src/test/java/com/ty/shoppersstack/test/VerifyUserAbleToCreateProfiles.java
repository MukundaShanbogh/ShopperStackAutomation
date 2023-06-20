package com.ty.shoppersstack.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ty.shoppersstack.common.BaseTest;
import com.ty.shoppersstack.pom.CreateProfilePage;
import com.ty.shoppersstack.pom.LoginPage;

public class VerifyUserAbleToCreateProfiles extends BaseTest {
	private CreateProfilePage profilePage;
	private LoginPage loginPage;

	@Test
	public void verifyUserAbleToCreateProfiles() {
		initializeInstance();

		getDriverAction().clickOn(loginPage.getHomePageLoginBtn());
		getDriverAction().clickOn(loginPage.getCreateAccountBtn());
		profilePage.createProfile(loginPage);
	}

	public void initializeInstance() {
		profilePage = new CreateProfilePage(getDriver(), getDriverAction());
		loginPage = new LoginPage(getDriver());
	}

	@Override
	public void loginToApp() throws IOException {
		// Do nothing
	}

	@Override
	public void closeApp() {
		super.closeApp();
	}

	@Override
	public void logoutFromApp() {

	}
}
