package com.selenium.browser;

import com.base.CommonUtility;
import com.base.DataStoreInMap;
import com.base.HandleException;

public class Test {

	public static void main(String[] args) throws HandleException {
		// Browsers b = new Chrome();
		// b.openBrowser();
		// b.closeBrowser();
		DataStoreInMap data = new DataStoreInMap();

		data = CommonUtility.loadDataInMap("", "config");

		System.out.println(data.getValue("testsiteBaseURl"));

	}

}
