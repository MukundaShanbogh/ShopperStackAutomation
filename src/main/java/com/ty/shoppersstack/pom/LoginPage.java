package com.ty.shoppersstack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//*[@id='loginBtn']")
	private WebElement homePageLoginBtn;

	@FindBy(xpath = "//*[@id='Email']")
	private WebElement emailTextFiled;

	@FindBy(xpath = "//*[@id='Password']")
	private WebElement passwordTextFiled;

	@FindBy(xpath = "//span[.='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//span[text()='Create Account']")
	private WebElement createAccountBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomePageLoginBtn() {
		return homePageLoginBtn;
	}

	public WebElement getEmailTextFiled() {
		return emailTextFiled;
	}

	public WebElement getPasswordTextFiled() {
		return passwordTextFiled;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getCreateAccountBtn() {
		return createAccountBtn;
	}
}
