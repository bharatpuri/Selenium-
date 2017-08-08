package com.selenium.actions.implementations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.base.HandleException;
import com.selenium.actions.ElementsListActions;
import com.selenium.browser.Browser;
import com.selenium.wait.SeleniumWait;

public class ElementListActionsImplementations implements ElementsListActions {

	List<WebElement> elementsList = null;

	@Override
	public List<WebElement> getElementList(String locator) throws HandleException {

		String loctor_type = locator.split("=")[0].replace("\"", "");
		String locator_value = locator.split("=", 2)[1].replace("\"", "");

		switch (loctor_type) {
		case "id": // Search the element with Id property
			if (SeleniumWait.waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.id(locator_value)))
					.isDisplayed()) {
				elementsList = Browser.getDriver().findElements(By.id(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "name": // Search the element with Name property
			if (SeleniumWait.waitForElement()
					.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator_value))).isDisplayed()) {
				elementsList = Browser.getDriver().findElements(By.name(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "cssSelector": // Search the element with cssSelector property
			if (SeleniumWait.waitForElement()
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator_value)))
					.isDisplayed()) {
				elementsList = Browser.getDriver().findElements(By.cssSelector(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "xpath": // Search the element with xpath property
			if (SeleniumWait.waitForElement()
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator_value))).isDisplayed()) {
				elementsList = Browser.getDriver().findElements(By.xpath(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "className": // Search the element with className property
			if (SeleniumWait.waitForElement()
					.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator_value))).isDisplayed()) {
				elementsList = Browser.getDriver().findElements(By.className(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "linkText": // Search the element with linkText property
			if (SeleniumWait.waitForElement()
					.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator_value))).isDisplayed()) {
				elementsList = Browser.getDriver().findElements(By.linkText(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "partialLinkText":// Search the element with partialLinkText
								// property
			if (SeleniumWait.waitForElement()
					.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator_value)))
					.isDisplayed()) {
				elementsList = Browser.getDriver().findElements(By.partialLinkText(locator_value));
			} else
				throw new HandleException("No element list found on web page by " + locator_value);
			break;
		case "tagName": // Search the element with tagName property
			if (SeleniumWait.waitForElement()
					.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator_value))).isDisplayed()) {
				elementsList = Browser.getDriver().findElements(By.tagName(locator_value));
			} else
				throw new HandleException("Failed invalid locator type: " + locator_value);
			break;
		default:// //Throw exception if any invalid WebElement list is found
			throw new HandleException("Failed to read the data from file");
		}
		return elementsList;
	}

	@Override
	public String getElementTextFromElementList(String elementList, String locator) throws HandleException {
		elementsList = getElementList(elementList);
		String actualString = "";
		for (WebElement elemt : elementsList) {
			if (elemt.getText().equalsIgnoreCase(locator)) {
				actualString = elemt.getText();
				break;
			}
		}
		return actualString;
	}

	@Override
	public int getElementCountFromElementList(String elementList) throws HandleException {
		int count = 0;
		elementsList = getElementList(elementList);
		count = elementsList.size();
		return count;
	}

	@Override
	public int getElementIndex(String elementList, String elementName) throws HandleException {
		elementsList = getElementList(elementList);
		int count = 0;
		for (WebElement element : elementsList) {
			count++;
			if ((element.getText()).equalsIgnoreCase(elementName)) {
				break;
			}
		}
		return count;
	}

	@Override
	public void clickOnIndexInElementList(int location, String elementList) throws HandleException {
		elementsList = getElementList(elementList);
		elementsList.get(location).click();

	}

	@Override
	public String getTextByIndexFromElementList(int index, String elementList) throws HandleException {
		elementsList = getElementList(elementList);
		String elementText = elementsList.get(index).getText();
		return elementText;
	}

}
