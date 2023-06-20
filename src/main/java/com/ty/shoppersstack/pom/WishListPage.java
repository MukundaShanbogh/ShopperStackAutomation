package com.ty.shoppersstack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.ty.shoppersstack.common.CommonConstant;
import com.ty.shoppersstack.common.DriverAction;

public class WishListPage {
	private DriverAction driverAction;
	private WebDriver driver;

	@FindBy(xpath = "//img[@alt='Short']")
	private WebElement wishListItem;

	@FindBy(xpath = "//div[@class='wishlist_actionBtns__+OeUi']/button[1]")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//button[.='remove from wishlist?']")
	private WebElement removeFromWishListBtn;

	public WishListPage(WebDriver driver, DriverAction driverAction) {
		this.driverAction = driverAction;
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getWishListItem() {
		return wishListItem;
	}

	public void dragAndDropToCart() {
		HomePage homePage = new HomePage(driver, driverAction);
		driverAction.dragAndDrop(wishListItem, homePage.getCartIcon(), driver);
	}

	public void addToCart() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(addToCartBtn, driver);
		Assert.assertEquals(actualElement, addToCartBtn);
		if (addToCartBtn.getText().equalsIgnoreCase(CommonConstant.ADD_TO_CART))
			driverAction.clickOn(addToCartBtn);
	}

	public void removeFromWishList() {
		WebElement actualElement = driverAction.waitUntilElementIsClickable(removeFromWishListBtn, driver);
		Assert.assertEquals(actualElement, removeFromWishListBtn);
		driverAction.clickOn(removeFromWishListBtn);
		driverAction.clickOnOkAlertPopup(driver);
	}

	public void verifyProductAdded() {
		WebElement actualElement = driverAction.waitUntilElementIsVisible(removeFromWishListBtn, driver);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualElement, removeFromWishListBtn);
	}
}
