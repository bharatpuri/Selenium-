package com.selenium.actions;

import java.io.IOException;

import com.base.HandleException;

public interface Browser {
	public void openBrowser()throws HandleException, IOException;
	public void closeBrowser()throws HandleException;
	public void quiteBrowser()throws HandleException; 

}
