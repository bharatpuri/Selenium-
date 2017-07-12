package testCases;

import org.testng.annotations.Test;

import com.base.CommonUtility;
import com.base.DataStoreInMap;
import com.base.HandleException;
import com.selenium.actions.Browser;
import com.selenium.actions.ElementActions;
import com.selenium.actions.implementations.BrowserImplementations;
import com.selenium.actions.implementations.Driver;
import com.selenium.actions.implementations.ElementActionsImplementions;

public class Login {

	Driver d = new Driver();
	ElementActions ele = new ElementActionsImplementions();
	Browser br = new BrowserImplementations();

	DataStoreInMap testData ;
	DataStoreInMap locators;

	public Login() throws HandleException {
		testData = CommonUtility.loadData("Test Data", "LoginData");
		locators = CommonUtility.loadData("Pages", "LoginPage");
	}

	@Test
	public void adminLogin() throws HandleException {
		br.openBrowser();
		ele.sendKeysToElement(testData.getValue("userName"), locators.getValue("userName"));
		ele.sendKeysToElement(testData.getValue("password"), locators.getValue("password"));
		ele.clickOnElement(locators.getValue("logiInButton"));
	}

}
