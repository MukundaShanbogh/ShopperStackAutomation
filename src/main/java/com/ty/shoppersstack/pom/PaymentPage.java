package com.ty.shoppersstack.pom;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ty.shoppersstack.common.Card;
import com.ty.shoppersstack.common.DriverAction;

public class PaymentPage {

	private DriverAction driverAction;
	private WebDriver driver;
	private Card card;

	@FindBy(xpath = "//span[contains(.,'Cash On Delivery')]")
	private WebElement codRadioBtn;

	@FindBy(xpath = "//span[text()='Net Banking']")
	private WebElement netBanking;

	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement proceedBtn;

	@FindBy(xpath = "//button[text()='Add Card']")
	private WebElement addCardBtn;

	@FindBy(xpath = "//div[@class='payment_upperBlock__HWt63']/div[1]/div/input")
	private WebElement nameOnCardTextFiled;

	@FindBy(xpath = "//div[@class='payment_upperBlock__HWt63']/div[2]/div/input")
	private WebElement cardNumTextFiled;

	@FindBy(xpath = "//div[@class='payment_upperBlock__HWt63']/div[3]/div/input")
	private WebElement pinTextFiled;

	@FindBy(xpath = "//div[@class='payment_lowerBlock__1xZJi']/div[1]/div/input")
	private WebElement expiryMonthTextFiled;

	@FindBy(xpath = "//div[@class='payment_lowerBlock__1xZJi']/div[2]/div/input")
	private WebElement expiryYearTextFiled;

	@FindBy(xpath = "//div[@class='payment_lowerBlock__1xZJi']/div[3]/div/input")
	private WebElement cvvTextFiled;

	@FindBy(xpath = "//input[@value='CREDIT']")
	private WebElement cardTypeRadioBtn;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addBtn;

	@FindBy(xpath = "//div[@class='payment_cardInfo__bgFzN']//p[2][text()='Imtiyaz']")
	private WebElement savedCard;

	@FindBy(xpath = "//input[@id='PIN']")
	private WebElement reEnterPinTextField;

	@FindBy(xpath = "//button[@id='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//span[text()='TCICI']")
	private WebElement tciciRadioBtn;

	public PaymentPage(WebDriver driver, DriverAction driverAction) {
		this.driverAction = driverAction;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCOD() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(codRadioBtn, driver);
		Assert.assertEquals(actualElement, codRadioBtn);
		driverAction.clickOn(codRadioBtn);
	}

	public void clickOnProceed() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(proceedBtn, driver);
		Assert.assertEquals(actualElement, proceedBtn);
		driverAction.clickOn(proceedBtn);
	}

	public void clickOnAddCard() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(addCardBtn, driver);
		Assert.assertEquals(actualElement, addCardBtn);
		driverAction.clickOn(addCardBtn);
	}

	public void clickAndEnterName() {
		if (Objects.nonNull(card)) {
			driverAction.enterTextInto(nameOnCardTextFiled, card.getNameOnCard());
		}
	}

	public void clickAndEnterCardNum() {
		if (Objects.nonNull(card)) {
			driverAction.enterTextInto(cardNumTextFiled, card.getCardNum());
		}
	}

	public void clickAndEnterPin() {
		if (Objects.nonNull(card)) {
			driverAction.enterTextInto(pinTextFiled, card.getPin());
		}
	}

	public void clickAndEnterExpiryMonth() {
		if (Objects.nonNull(card)) {
			String monthYear = card.getExpiry();
			driverAction.enterTextInto(expiryMonthTextFiled, monthYear.substring(0, monthYear.indexOf("/")));
		}
	}

	public void clickAndEnterExpiryYear() {
		if (Objects.nonNull(card)) {
			String monthYear = card.getExpiry();
			driverAction.enterTextInto(expiryYearTextFiled, monthYear.substring(monthYear.indexOf("/") + 1));
		}
	}

	public void clickAndEnterCvv() {
		if (Objects.nonNull(card)) {
			driverAction.enterTextInto(cvvTextFiled, card.getCvv());
		}
	}

	public void clickOnCardType() {
		driverAction.clickOn(cardTypeRadioBtn);
	}

	public void clickOnAdd() {
		driverAction.clickOn(addBtn);
	}

	public void clickSavedCard() {
		driverAction.clickOn(savedCard);
	}

	public void reEnterPin() {
		if (Objects.nonNull(card))
			driverAction.enterTextInto(reEnterPinTextField, card.getPin());
	}

	public void clickOnSubmit() {
		driverAction.clickOn(submitBtn);
		driverAction.delayBetweenSteps();
	}

	public void loadCardDetails(Card card) {
		this.card = card;
	}

	public void clickOnNetbaking() {
		driverAction.clickOn(netBanking);
	}
}
