package com.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.base.HandleException;

public class Firefox extends Browser {

	@Override
	public WebDriver getBrowser() throws HandleException {
		return new FirefoxDriver();
		
	}

}
