package com.ty.shoppersstack.pom;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ty.shoppersstack.common.Card;
import com.ty.shoppersstack.common.DriverAction;

public class HelpPage {
	private DriverAction driverAction;
	private WebDriver driver;
	private Card card;

	@FindBy(xpath = "//button[text()='Credit Card']")
	private WebElement creditCardTab;

	@FindBy(xpath = "//button[text()='Net Banking']")
	private WebElement netbankingTab;

	@FindBy(xpath = "//select[@id='demo-simple-select']")
	private WebElement selectBankDropDown;

	@FindBy(xpath = "//div[@class='help_cardContent__NaBh5']")
	private WebElement allCardInfo;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[@class='help_cardContainer__4RKYP']//div[@class='help_Card__kE2BX']//div//*")
	private List<WebElement> cardsDetails;

	public HelpPage(WebDriver driver, DriverAction driverAction) {
		this.driver = driver;
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCreditCard() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(creditCardTab, driver);
		Assert.assertEquals(actualElement, creditCardTab);
		driverAction.clickOn(creditCardTab);
	}

	public void clickOnNetBanking() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(netbankingTab, driver);
		Assert.assertEquals(actualElement, netbankingTab);
		driverAction.clickOn(netbankingTab);
	}

	public void addBankIfNotAdded(String bankName) {
		String xpath = "//div[@class='" + allCardInfo.getAttribute("class") + "']";
		String newXpath = xpath + "//p[6][text()='" + bankName + "']";
		WebElement cardInfo = null;
		try {
			cardInfo = driver.findElement(By.xpath(newXpath));
		} catch (Exception e) {
		}

		if (Objects.isNull(cardInfo)) {
			// select bank from dropdown
			driverAction.clickOn(selectBankDropDown);
			driverAction.selectByValue(selectBankDropDown, bankName);
			driverAction.clickOn(submitBtn);
		}
	}

	public void captureCardDetails(String bankName) {
		String bank = "Issued By : " + bankName + " Bank";
		card = new Card();

		for (int i = 6; i < cardsDetails.size(); i += 8) {
			if (cardsDetails.get(i).getText().equalsIgnoreCase(bank)) {
				String str = cardsDetails.get(--i).getText();
				card.setIssuedBy(bankName);

				card.setBalance(str.substring(str.indexOf(":") + 1).trim());

				str = cardsDetails.get(--i).getText();
				card.setExpiry(str.substring(str.indexOf(":") + 1).trim());

				str = cardsDetails.get(--i).getText();
				card.setPin(str.substring(str.indexOf(":") + 1).trim());

				str = cardsDetails.get(--i).getText();
				card.setCvv(str.substring(str.indexOf(":") + 1).trim());

				str = cardsDetails.get(--i).getText();
				card.setCardNum(str.substring(str.indexOf(":") + 1).trim());

				str = cardsDetails.get(--i).getText();
				card.setNameOnCard(str.substring(str.indexOf(":") + 1).trim());
				break;
			}
		}
	}

	public Card getCard() {
		return card;
	}
}
