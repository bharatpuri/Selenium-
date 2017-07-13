package com.selenium.actions.implementations;

import com.base.CommonUtility;
import com.base.DataStoreInMap;
import com.base.HandleException;

public class Demo {

	public static void main(String[] args) throws HandleException {
//		int String = 30;
//		System.out.println(String);
		//int a = 0785;//invalid bz number start with octal 
//		char a = 'a';
//		System.out.println("hello\\hello");
//		
//		int[] a = new int[-2];
//		System.out.println(a);
		DataStoreInMap  data;
//		data = CommonUtility.storeDataInMap("TestDatan", "LoginDatan");
//		System.out.println(data.getValue("userName"));
		data = CommonUtility.storeDataInMap("TestDatan","LoginData");
		System.out.println(data.getValue("userName"));
	}
}