package com.selenium.actions.implementations;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.HandleException;
import com.selenium.actions.DropDownAndMultipleSelect;
import com.selenium.actions.ElementActions;

public class DropDwonAndMultiSelectImplementations implements DropDownAndMultipleSelect {
	private List<WebElement> allElements;
	private WebElement webElement;
	
	
	ElementActions elementActions = new ElementActionsImplementions();
	@Override
	public String getSelectedValueFromDropDown(String element) throws HandleException {
		webElement = elementActions.getElement(element);
		Select select = new Select(webElement);
		WebElement ele = select.getFirstSelectedOption();
		return ele.getText();
	}

	@Override
	public void selectOptionFromDropDownByIndex(int value, String element) throws HandleException {
		webElement = elementActions.getElement(element);
		Select select = new Select(webElement);
		select.selectByIndex(value);
	}

	@Override
	public void selectOptionFromDropDownByVisiableText(String dropDownElement, String element) throws HandleException {
		webElement = elementActions.getElement(element);
		Select select = new Select(webElement);
		select.selectByVisibleText(element);
		
	}

}
