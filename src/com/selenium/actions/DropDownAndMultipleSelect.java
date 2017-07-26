package com.selenium.actions;

public interface DropDownAndMultipleSelect {

	public String getSelectedValueFromDropDown(String element);

	public void selectOptionFromDropDownByIndex(int value, String element);

	public void selectOptionFromDropDownByVisiableText(String dropDownElement, String element);

}
