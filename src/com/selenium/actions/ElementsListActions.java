package com.selenium.actions;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.base.HandleException;

public interface ElementsListActions {

	public List<WebElement> getElementList(String locator) throws HandleException;

	public String getElementTextFromElementList(String elementList, String locator) throws HandleException;

	public int getElementCountFromElementList(String elementList) throws HandleException;

	public int getElementIndex(String elementList, String elementName) throws HandleException;

	public void clickOnIndexInElementList(int location, String elementList) throws HandleException;

	public String getTextByIndexFromElementList(int index, String elementList) throws HandleException;
}