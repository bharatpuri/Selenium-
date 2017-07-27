package com.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.base.HandleException;

public class IE extends Browsers {

	@Override
	public WebDriver getBrowser() throws HandleException {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\abc\\Desktop\\Server\\IEDriverServer.exe");
		return new InternetExplorerDriver();
	}

}
