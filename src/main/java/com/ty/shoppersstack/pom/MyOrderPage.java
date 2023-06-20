package com.ty.shoppersstack.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ty.shoppersstack.common.DriverAction;

public class MyOrderPage {
	private DriverAction driverAction;
	private WebDriver driver;

	@FindBy(xpath = "//button[text()='Cancel Order']")
	private List<WebElement> listOfOrdersToBeCancelled;

	@FindBy(xpath = "//h3[text()='PLACED']")
	private List<WebElement> listOfPlacedOrders;

	@FindBy(xpath = "(//button[.='Yes'])[1]")
	private WebElement cancelOrderConfirmationBtn;

	public MyOrderPage(WebDriver driver, DriverAction driverAction) {
		this.driver = driver;
		this.driverAction = driverAction;
		PageFactory.initElements(driver, this);
	}

	public void cancelOrder() {
		for (int i = 0; i < listOfPlacedOrders.size(); i++) {
			driverAction.clickOn(listOfOrdersToBeCancelled.get(i), driver);
			driverAction.clickOn(cancelOrderConfirmationBtn, driver);
		}
	}
}
