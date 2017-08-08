package com.selenium.actions;

import com.base.HandleException;

public interface DropDownAndMultipleSelect {

	public String getSelectedValueFromDropDown(String element) throws HandleException;

	public void selectOptionFromDropDownByIndex(int value, String element) throws HandleException;

	public void selectOptionFromDropDownByVisiableText(String dropDownElement, String element) throws HandleException;

}
