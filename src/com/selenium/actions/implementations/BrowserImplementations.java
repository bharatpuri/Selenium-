package com.selenium.actions.implementations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.base.CommonUtility;
import com.base.DataStoreInMap;
import com.base.HandleException;
import com.selenium.actions.Browser;
import com.selenium.actions.SupportedBrowser;

/**
 * This class implements Browser interface
 * 
 * @author bharatp Date 30 June 2017
 */
public class BrowserImplementations implements Browser {

	private final static Logger LOGGER = Logger.getLogger(BrowserImplementations.class.getName());

	Driver driver = new Driver();

	/*
	 * This function will open the browser (non-Javadoc)
	 * 
	 * @see com.selenium.actions.Browser#openBrowser()
	 */
	@Override
	public void openBrowser() throws HandleException, IOException {

		DataStoreInMap configData = new DataStoreInMap();
		configData = CommonUtility.storeDataInMap("Config", "config");
		String webURL = configData.getValue("testsiteBaseURl");

		Driver.getBrowser(SupportedBrowser.CHROME).get(webURL);
		Driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LOGGER.info("Implicit wait applied on the driver for 60 seconds");
		Driver.getDriver().manage().window().maximize();
		LOGGER.info("Maximixe the window");
		LOGGER.info("Web application launched: " + webURL);

	}

	/*
	 * This function will quite the all browsers open by selenium
	 * webdriver(non-Javadoc)
	 * 
	 * @see com.selenium.actions.Browser#quiteBrowser()
	 */
	@Override
	public void quiteBrowser() throws HandleException {

		if (Driver.getDriver() != null) {
			Driver.getDriver().close();
			Driver.getDriver().quit();
			driver.setDriver(null);
			LOGGER.info("Close all the browser open by selenium webdriver");
		} else {
			throw new HandleException("Failed while quiting the browser");
		}
	}

	/*
	 * This function will close the current open browser by selenium
	 * webdriver(non-Javadoc)
	 * 
	 * @see com.selenium.actions.Browser#closeBrowser()
	 */
	@Override
	public void closeBrowser() throws HandleException {
		if (Driver.getDriver() != null) {
			Driver.getDriver().close();
			driver.setDriver(null);
			LOGGER.info("Close all the browser open by selenium webdriver");
		} else
			throw new HandleException("Failed while closing the browser");

	}
}
