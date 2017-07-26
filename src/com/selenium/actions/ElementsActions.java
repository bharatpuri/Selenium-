package com.selenium.actions;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface ElementsActions {

	public List<WebElement> getElementList(String locator);

	public String getElementTextFromElementList(String elementList, String locator);

	public int getElementCountFromElementList(String elementList);

	public int getElementIndex(String elementList, String elementName);

	public void clickOnIndexInElementList(int location, String elementList);

	public String getTextByIndexFromElementList(int index, String elementList);
}