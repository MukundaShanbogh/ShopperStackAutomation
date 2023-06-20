package com.ty.shoppersstack.pom;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ty.shoppersstack.common.CommonConstant;
import com.ty.shoppersstack.common.DriverAction;
import com.ty.shoppersstack.common.ExcelLibrary;

public class CreateProfilePage {
	private DriverAction driverAction;
	private WebDriver driver;

	@FindBy(xpath = "//input[@id='First Name']")
	private WebElement firstNameTextFiled;

	@FindBy(xpath = "//input[@id='Last Name']")
	private WebElement lastNameTextFiled;

	@FindBy(xpath = "//input[@id='Male']")
	private WebElement genderRadioBtn;

	@FindBy(xpath = "//input[@id='Phone Number']")
	private WebElement phoneNumTextFiled;

	@FindBy(xpath = "//input[@id='Email Address']")
	private WebElement emailAddressTextFiled;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextFiled;

	@FindBy(xpath = "//input[@id='Confirm Password']")
	private WebElement confirmTextFiled;

	@FindBy(xpath = "//input[@id='Terms and Conditions']")
	private WebElement tAndcCheckBox;

	@FindBy(xpath = "//button[@id='btnDisabled']")
	private WebElement registerBtn;

	public CreateProfilePage(WebDriver driver, DriverAction driverAction) {
		this.driver = driver;
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void createProfile(LoginPage loginPage) {
		ExcelLibrary excelLibrary = new ExcelLibrary();
		try {
			Sheet s = excelLibrary.getSheet(CommonConstant.PROFILE_SHEET);

			for (int i = 1; i <= s.getLastRowNum(); i++) {
				Row r = s.getRow(i);
				for (int j = 0; j < r.getLastCellNum(); j++) {
					if (j == 0) {
						driverAction.enterTextInto(firstNameTextFiled, r.getCell(j).getStringCellValue());
					} else if (j == 1) {
						driverAction.enterTextInto(lastNameTextFiled, r.getCell(j).getStringCellValue());
					} else if (j == 2) {
						driverAction.clickOn(genderRadioBtn);
					} else if (j == 3) {
						driverAction.enterTextInto(phoneNumTextFiled, r.getCell(j).getStringCellValue());
					} else if (j == 4) {
						driverAction.enterTextInto(emailAddressTextFiled, r.getCell(j).getStringCellValue());
					} else if (j == 5) {
						driverAction.enterTextInto(passwordTextFiled, r.getCell(j).getStringCellValue());
					} else if (j == 6) {
						driverAction.enterTextInto(confirmTextFiled, r.getCell(j).getStringCellValue());
					}
				}

				driverAction.clickOn(tAndcCheckBox);
				driverAction.clickOn(registerBtn);
				driverAction.delayBetweenSteps();
				driverAction.clickOn(loginPage.getHomePageLoginBtn());
				driverAction.clickOn(loginPage.getCreateAccountBtn());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
