package com.selenium.actions;

import com.base.HandleException;

public interface AlertActions {
	
	public abstract String getAlertText() throws HandleException;

	public abstract void handleAlert(String action);

}
