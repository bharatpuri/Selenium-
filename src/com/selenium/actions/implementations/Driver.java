package com.selenium.actions.implementations;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.actions.SupportedBrowser;

public class Driver {
	private final static Logger logger = Logger.getLogger(Driver.class.getName());
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	@SuppressWarnings("static-access")
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public static WebDriver getBrowser(SupportedBrowser browserName) {
		switch (browserName) {
		case FIREFOX:
			if (driver == null) {
				driver = new FirefoxDriver();
				logger.info("New Mozila driver instantiated");
			}
			break;
		case IE:
			if (driver == null) {
				System.setProperty("webdriver.ie.driver", "C:\\Users\\abc\\Desktop\\Server\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				logger.info("New IE driver instantiated");
			}
			break;
		case CHROME:
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", "src/Labraries/chromedriver.exe");
				driver = new ChromeDriver();
				logger.info("New Chrome driver instantiated");
			}
			break;
		}
		return driver;
	}

}
