package com.selenium.actions;

import com.base.HandleException;

public interface Browser {
	public void openBrowser()throws HandleException;
	public void closeBrowser()throws HandleException;
	public void quiteBrowser()throws HandleException; 

}
