package com.test.base;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.test.util.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This page class is intended to have the base setup for UI automation framework 
 * consists of browser launch and capabilities setup for UI
 * base Selenium driver initializations
 * 
 * @return null
 */

public class BaseSetup {
	public static WebDriver driver;
	public static Properties prop = null;

	public static Utilities utilities = new Utilities();

	public static void baseConfigurationSetup() throws IOException
	{		
		prop= utilities.readPropertiesFile("TestData.properties");

		WebDriverManager.chromedriver().setup();
		Map<String,Object> preferences = new Hashtable<String,Object>();
		preferences.put("credentials_enable_service", false);
		preferences.put("profile.password_manager_enabled", false);
		preferences.put("safebrowsing.enabled", false);
		preferences.put("javascript.enabled", "true");
		ChromeOptions ch_options = new ChromeOptions();
		ch_options.setExperimentalOption("prefs", preferences);
		ch_options.addArguments("disable-infobars");
		ch_options.addArguments("safebrowsing-disable-download-protection");
		ch_options.addArguments("--disable-notifications");
		DesiredCapabilities chrome_capabilities = DesiredCapabilities.chrome();
		chrome_capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		chrome_capabilities.setCapability(ChromeOptions.CAPABILITY, ch_options);
		driver= new ChromeDriver();
		driver.manage().window().maximize();

	}

}
