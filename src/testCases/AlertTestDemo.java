package testCases;

import org.testng.annotations.Test;

import com.base.CommonUtility;
import com.base.DataStoreInMap;
import com.base.HandleException;
import com.selenium.actions.AlertActions;
import com.selenium.actions.Browser;
import com.selenium.actions.ElementActions;
import com.selenium.actions.implementations.AlertImplementions;
import com.selenium.actions.implementations.BrowserImplementations;
import com.selenium.actions.implementations.Driver;
import com.selenium.actions.implementations.ElementActionsImplementions;

public class AlertTestDemo {
	Driver d = new Driver();
	Browser br = new BrowserImplementations();
	ElementActions ele = new ElementActionsImplementions();
	AlertActions alet = new AlertImplementions();
	
	DataStoreInMap locators = new DataStoreInMap();
  @Test
  public void f() throws HandleException, InterruptedException {
	  locators = CommonUtility.loadData("Pages", "LoginPage");
	  br.openBrowser();
	  Thread.sleep(10000);
	  //ele.clickOnElement(locators.getValue("alertButton"));
	  
	  String abc = alet.getAlertText();
	  System.out.println(abc);
	  alet.handleAlert("accept");
	  
	  
  }
}
