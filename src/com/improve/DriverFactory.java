package com.improve;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.actions.SupportedBrowser;

public class DriverFactory {

	private static  WebDriver driver;
	private static Map<SupportedBrowser, WebDriver> driverMap;

	public static WebDriver getInstance(SupportedBrowser browser){
		return driverMap.get(browser);
	} 
	
	static {
		if (driver == null) {
			driverMap = new HashMap<>();
			driverMap.put(SupportedBrowser.FIREFOX, new FirefoxDriver());
			driverMap.put(SupportedBrowser.CHROME, new ChromeDriver());
			driverMap.put(SupportedBrowser.IE, new InternetExplorerDriver());
		}
	}

	/*
	 * Factory method for getting browsers
	 */
	// public static WebDriver getBrowser(String browserName) {
	// switch (browserName) {
	// case "Firefox":
	// driver = drivers.get("Firefox");
	// if (driver == null) {
	// driver = new FirefoxDriver();
	// drivers.put("Firefox", driver);
	// }
	// break;
	// case "IE":
	// driver = drivers.get("IE");
	// if (driver == null) {
	// System.setProperty("webdriver.ie.driver",
	// "C:\\Users\\abc\\Desktop\\Server\\IEDriverServer.exe");
	// driver = new InternetExplorerDriver();
	// drivers.put("IE", driver);
	// }
	// break;
	// case "Chrome":
	// driver = drivers.get("Chrome");
	// if (driver == null) {
	//// System.setProperty("webdriver.chrome.driver",
	//// "C:\\Users\\abc\\Desktop\\Server\\ChromeDriver.exe");
	// driver = new ChromeDriver();
	// drivers.put("Chrome", driver);
	// }
	// break;
	// }
	// return driver;
	// }
	//
	public enum DriverType {
		CHROME, FIREFOX, IE, SAFARI;
	}


	//// public void getName(){
	//// DriverType abc = DriverType.CHROME;
	//// System.out.println(abc);
	////
	////
	//// }
}
