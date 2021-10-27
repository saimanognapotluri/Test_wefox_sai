package com.test.module;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.base.BaseSetup;

import junit.framework.Assert;

/**
* This page class has all the methods/utilities portal landing page
* these utility classes can be used by fixture/ Step Definition classes to complete the test case flow
* Fixture/ Step Definition class path: (<current project directory>/src/test/java/StepDefinitions)
* 
* @return null
*/
public class LegoScenarioUtility extends BaseSetup implements LegoProductsPageLocators, LegoCartPageLocators{
	List<WebElement> productList = new ArrayList<WebElement>();

	public LegoScenarioUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void LegoNavigate(String homepage) throws InterruptedException
	{
		driver.get(homepage);
		utilities.implicitWait();
		driver.findElement(mainPageContinueBtn).click();
		utilities.implicitWait();
		driver.findElement(acceptTermsBtn).click();
	}

	public void applyFilters() {

		driver.findElement(harrypotterProductPageNavigator).click();
		
		//filter price below 20 €		
		driver.findElement(filterPriceBelow20).click();
		
		//filter keychains
		driver.findElement(filterKeychains).click();
		
		//filter age (Expected 3 to 5 years but not found on the UI). Apply filter 6+ years
		driver.findElement(filterAge).click();
	}

	public void verifyProductNumberOfResults() {

		//checking for number of products displayed
		
		productList = driver.findElements(pricesOfProductDisplayed);
		int NumberofProductDisplayed = productList.size();
		System.out.println("Number of products displayed on the page "+NumberofProductDisplayed);
		
	}

	public void checkProductDetails() {

		// checking prices of the products displayed - below 20 €
		int i=1;
		for(WebElement list: productList)
		{
			
			System.out.println("price of the product "+i+" -- "+list.getText());
			i++;
		}
		
	}

	public void addToCartVerifyAndCheckout() {

		//getting first product name
		WebElement firstProductNameElement = driver.findElement(firstProductName);
		String firstProductName= firstProductNameElement.getText();
		System.out.println("Name of the first product "+firstProductName);
		
		//getting first product price
		
		WebElement firstProductPriceElement = driver.findElement(firstProductPrice);
		String firstProductPrice= firstProductPriceElement.getText();
		System.out.println("Price of the first product "+firstProductPrice);
		firstProductPrice = firstProductPrice.replace("Price", "").trim();
		//adding the product to cart
		driver.findElement(firstProductAddToCart).click();
		
		//continue to cart
		utilities.implicitWait();
		driver.findElement(proceedToCartBtn).click();
		
		utilities.implicitWait();
		//Verify added product details on the cart page
		String cartPageProductname = driver.findElement(cartPageProductNameEle).getText();
		String cartPageProductPrice = driver.findElement(cartPageProductPriceEle).getText();
		cartPageProductPrice = cartPageProductPrice.replace("Price", "").trim();
		String cartPageProductPriceRight = driver.findElement(cartPageProductPriceRightEle).getText();
		cartPageProductPriceRight = cartPageProductPriceRight.replace("Price", "").trim();
		System.out.println("Right price "+cartPageProductPriceRight);
		
		Assert.assertEquals("assert failed", cartPageProductname, firstProductName);
		
		System.out.println("cart price "+cartPageProductPrice);
		System.out.println("First price "+firstProductPrice);
		Assert.assertEquals("assert failed", cartPageProductPrice, firstProductPrice);
		
		
	}	
	
	
	
}
