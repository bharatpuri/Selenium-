package com.base;

public interface IDataStoreInMap {
	
	String getValue(String key) throws HandleException;

	public void put(String key, String value);
}
