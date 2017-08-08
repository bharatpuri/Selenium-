package com.selenium.wait;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.HandleException;
import com.selenium.browser.Browser;

public class SeleniumWait {
	
	/**
	 * This method will wait until 120 seconds
	 * 
	 * @return
	 * @throws HandleException
	 */
	public static WebDriverWait waitForElement() {
		return new WebDriverWait(Browser.getDriver(), 120);
	}

}
