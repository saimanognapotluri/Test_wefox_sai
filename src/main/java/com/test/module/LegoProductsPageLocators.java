package com.test.module;

import org.openqa.selenium.By;

public interface LegoProductsPageLocators {

	
	public static By mainPageContinueBtn = By.xpath("//*[text()='Continuar']");
	public static By acceptTermsBtn = By.xpath("//*[text()='Aceptar todo']");
	public static By harrypotterProductPageNavigator = By.xpath("//a[@class='Linksstyles__RouterLinkButton-sc-684acv-2 dUKOWG HeroBannerstyles__StyledLink-sc-14u9ljd-10 bHKZKM']");
	public static By filterPriceBelow20 = By.xpath("(//div[following-sibling::span[contains(text(),'20')]])[1]");
	public static By filterKeychains = By.xpath("//div[following-sibling::span[contains(text(),'Llaveros')]]");
	public static By filterAge = By.xpath("//div[following-sibling::span[contains(text(),'6+')]]");
	public static By pricesOfProductDisplayed = By.xpath("//span[child::span[text()='Price']]");
	public static By firstProductName = By.xpath("(//span[parent::h2[parent::a[@data-test='product-leaf-title-link']]])[1]");
	public static By firstProductAddToCart = By.xpath("(//*[text()='Añadir a la Bolsa'])[1]");
	public static By firstProductPrice = By.xpath("(//span[child::span[text()='Price']])[1]");
	public static By proceedToCartBtn = By.xpath("//*[text()='Ver mi bolsa']");

	
}
