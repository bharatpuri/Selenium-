package com.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * This class consist of method which are common to all framework
 * 
 * @author bharatp : 14/04/2017
 *
 */
public class CommonUtility {

	final static Logger LOGGER = Logger.getLogger(CommonUtility.class.getName());

	/**
	 * This method will check the file is exist in selected directory or not
	 * 
	 * @param filePath
	 * @return true or false
	 */
	public static boolean isFileExit(String filePath) {
		filePath = "resource/" + filePath;
		File files = new File(filePath);
		return files.exists();
	}

	/**
	 * This method will load the data from selected property file
	 * 
	 * @param folderName
	 * @param fileName
	 * @return property data
	 * @throws HandleException
	 * @throws FileNotFoundException 
	 */
	public static Properties loadData(String folderName, String fileName) throws HandleException {
		InputStream resourceStream;
		Properties props = new Properties();
		String resourceName;

		if (null != folderName && folderName.isEmpty()) {
			resourceName = fileName + ".properties";
		} else {
			resourceName = folderName + "/" + fileName + ".properties";
		}
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		resourceStream = loader.getResourceAsStream(resourceName);
		if (resourceStream != null) {
			try {
				props.load(resourceStream);
				LOGGER.info("Property file is loaded successfully: " + resourceName);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					resourceStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			throw new HandleException("Filed file not found: " + resourceName);
		}
		return props;
	}

	/**
	 * This method will store the data in MAP
	 * 
	 * @param folderName
	 * @param fileName
	 * @return
	 * @throws HandleException
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public static DataStoreInMap loadDataInMap(String folderName, String fileName) throws HandleException {
		DataStoreInMap mapData = new DataStoreInMap();
		Properties data = loadData(folderName, fileName);
		
		Set<String> propertyNames = data.stringPropertyNames();
		for (String Property : propertyNames) {
			mapData.put(Property, data.getProperty(Property));
		}
		return mapData;
	}

	/**
	 * This method will wait for provided seconds
	 * 
	 * @throws InterruptedException
	 */
	public static void waitSeconds(int seconds) throws InterruptedException {
		TimeUnit.SECONDS.sleep(seconds);

	}

}
