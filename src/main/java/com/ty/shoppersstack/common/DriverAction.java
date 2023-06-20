package com.ty.shoppersstack.common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverAction {
	private JavascriptExecutor js;

	public void enterTextInto(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		delayBetweenSteps();
	}

	public void clearTextFrom(WebElement element) {
		try {
			element.sendKeys(Keys.CONTROL, "a");
			element.sendKeys(Keys.DELETE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		delayBetweenSteps();
	}

	public void clickOn(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		delayBetweenSteps();
	}

	public void clickOn(WebElement element, WebDriver driver) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		delayBetweenSteps();
	}

	public void delayBetweenSteps() {
		try {
			Thread.sleep(CommonConstant.WAIT_TIME_IN_MS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public WebElement waitUntilElementIsVisible(WebElement webElement, WebDriver driver) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, CommonConstant.WAIT_TIME);
			element = wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public WebElement waitUntilElementIsClickable(WebElement webElement, WebDriver driver) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, CommonConstant.WAIT_TIME);
			element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public void selectByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		delayBetweenSteps();
	}

	public void clickOnOkAlertPopup(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		delayBetweenSteps();
	}

	public void dragAndDrop(WebElement source, WebElement destination, WebDriver driver) {
		try {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(source, destination).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		delayBetweenSteps();
	}

	public void scrollByPixels(WebElement element, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		try {
			if (element.isDisplayed()) {
				clickOn(element);
			}
		} catch (Exception e) {
			js.executeScript("window.scrollBy(0,100)");
			e.printStackTrace();
		}
	}

	public boolean scrollToElement(WebElement element, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			delayBetweenSteps();
			return element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void rightClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		delayBetweenSteps();
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_ENTER);
			delayBetweenSteps();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToChildWindow(List<String> listOfAllWindows, String parentWindow, WebDriver driver) {
		try {
			for (String windowHandle : listOfAllWindows) {
				if (!parentWindow.equals(windowHandle)) {
					driver.switchTo().window(windowHandle);
					delayBetweenSteps();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToParentWindow(List<String> listOfAllWindows, String childWindow, WebDriver driver) {
		try {
			for (String windowHandle : listOfAllWindows) {
				if (!childWindow.equals(windowHandle)) {
					driver.switchTo().window(windowHandle);
					delayBetweenSteps();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void multiSelectValues(List<WebElement> elements, String value) {
		try {
			for (WebElement element : elements) {
				if (element.getText().equalsIgnoreCase(value)) {
					clickOn(element);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void singleSelectValues(List<WebElement> elements, String value) {
		try {
			for (WebElement element : elements) {
				if (element.getText().equalsIgnoreCase(value)) {
					clickOn(element);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollDownVertically(WebDriver driver) {
		js = (JavascriptExecutor) driver;

		try {
			for (int i = 1; i <= 5; i++) {
				delayBetweenSteps();
				js.executeScript("window.scrollBy(0,1000)");// to move top to bottom
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollUpVertically(WebDriver driver) {
		js = (JavascriptExecutor) driver;

		try {
			for (int i = 1; i <= 5; i++) {
				delayBetweenSteps();
				js.executeScript("window.scrollBy(0,-1000)");// to move top to bottom
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}