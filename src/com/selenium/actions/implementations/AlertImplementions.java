package com.selenium.actions.implementations;

import org.openqa.selenium.Alert;

import com.base.HandleException;
import com.selenium.actions.AlertActions;

public class AlertImplementions implements AlertActions {
	
	@Override
	public String getAlertText() throws HandleException {
		
		Alert simpleAlert;

		simpleAlert = Driver.getDriver().switchTo().alert();

		String alertText = simpleAlert.getText();

		return alertText;
	}

	@Override
	public void handleAlert(String action) {
		Alert simpleAlert;

		simpleAlert =  Driver.getDriver().switchTo().alert();

		if (action.equalsIgnoreCase("accept")) {
			simpleAlert.accept();
		} else
			simpleAlert.dismiss();
	}

}
