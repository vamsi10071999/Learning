package Utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFactory {

	public static WebDriver driver;

	// Set Implicit Wait
	public static void setImplicitWait(long timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
	}

	// Get Explicit Wait
	public WebDriverWait getExplicitWait(long timeInSeconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
	}

	// Get Fluent Wait
	public Wait<WebDriver> getFluentWait(long timeoutInSeconds, long pollingInMillis) {
		return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingInMillis)).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class);
	}

	// Wait for Element to be Visible
	public WebElement waitForElementVisible(By locator, long timeInSeconds) {
		return getExplicitWait(timeInSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Wait for Element to be Clickable
	public WebElement waitForElementClickable(By locator, long timeInSeconds) {
		return getExplicitWait(timeInSeconds).until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Wait for Element to be Present
	public WebElement waitForElementPresent(By locator, long timeInSeconds) {
		return getExplicitWait(timeInSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Wait for Alert to be Present
	public Alert waitForAlertPresent(long timeInSeconds) {
		return getExplicitWait(timeInSeconds).until(ExpectedConditions.alertIsPresent());
	}

	// Wait for Title to be Present
	public boolean waitForTitleContains(String titleFragment, long timeInSeconds) {
		return getExplicitWait(timeInSeconds).until(ExpectedConditions.titleContains(titleFragment));
	}

	// Wait for URL to be Present
	public boolean waitForUrlContains(String urlFragment, long timeInSeconds) {
		return getExplicitWait(timeInSeconds).until(ExpectedConditions.urlContains(urlFragment));
	}

}
