package com.selenium.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.base.CommonUtility;
import com.base.DataStoreInMap;
import com.base.HandleException;

public abstract class Browsers {

	protected static WebDriver driver;
	private final static Logger LOGGER = Logger.getLogger(Browsers.class.getName());

	public final void openBrowser() throws HandleException {

		DataStoreInMap configData = new DataStoreInMap();
		configData = CommonUtility.loadDataInMap("", "config");
		String webURL = configData.getValue("testsiteBaseURl");

		getBrowser().get(webURL);
		LOGGER.info("Implicit wait applied on the driver for 60 seconds");
		getDriver().manage().window().maximize();
		LOGGER.info("Maximixe the window");
		LOGGER.info("Web application launched: " + webURL);

	}

	public abstract WebDriver getBrowser() throws HandleException;

	public void closeBrowser() throws HandleException {
		if (driver != null) {
			driver.close();
			LOGGER.info("Close the browser open by selenium webdriver");
		} else
			throw new HandleException("Failed while closing the browser");

	}

	public void quiteBrowser() throws HandleException {
		if (driver != null) {
			driver.quit();
			LOGGER.info("Quite all the browsers open by selenium webdriver");
		} else {
			throw new HandleException("Failed while quiting the browser");
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}

	// public static void setDriver(WebDriver driver) {
	// Browsers.driver = driver;
	// }
}
