package com.test.module;

import org.openqa.selenium.By;

public interface LegoCartPageLocators {

	
	public static By cartPageProductNameEle = By.xpath("//span[parent::span[@data-test='product-title']]");
	public static By cartPageProductPriceEle = By.xpath("//span[parent::div[@class='ProductPricestyles__Wrapper-vmt0i4-1 iMtoGE']]");
	public static By cartPageProductPriceRightEle = By.xpath("//span[parent::span[preceding-sibling::span[text()='Valor del pedido de (1) artículos']]]");
}
