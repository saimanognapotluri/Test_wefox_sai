package com.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.BaseSetup;
/**
* This class has all the utilities used for the project
* These utility classes can be used by other page classes
* 
* @return null
*/
public class SeleniumUtilities extends BaseSetup{
	

	/**
	* This method is intended to check if an element is present on the web page
	* @param By class
	* @return boolean value
	*/	
	public static boolean isElementPresent(By by)
	{
		boolean present = false;
		try {
			present= driver.findElements(by).size()>0;
		} catch (NoSuchElementException e) {
			present = false;
		}
		return present;
	}

	/**
	* This method is intended to wait for the page to completely load
	* @param timeout
	* @return
	*/	
	@SuppressWarnings("null")
	public static void waitForPageToLoad(long timeout) {
		WebDriverWait wait = null;
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) (((JavascriptExecutor) driver)
						.executeScript("return (document.readyState=='complete')"));
			}
		});
	}

	/**
	* This method is intended to wait for the page JQuery elements to completely load
	* @param timeout
	* @return
	*/	
	@SuppressWarnings("null")
	public static void waitForJQueryToLoad(long timeout) {
		WebDriverWait wait = null;
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) (((JavascriptExecutor) driver)
						.executeScript("return jQuery.active"));
			}
		});
	}
	
	public void scrollToEnd()
	{
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void javacriptClick(WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	     executor.executeScript("arguments[0].click();", element);
	}
	
}
