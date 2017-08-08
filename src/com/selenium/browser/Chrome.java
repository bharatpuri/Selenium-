package com.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.HandleException;

public class Chrome extends Browser {
	@Override
	public WebDriver getBrowser() throws HandleException {
		System.setProperty("webdriver.chrome.driver", "src/Labraries/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;//new ChromeDriver();
	}
	

}
