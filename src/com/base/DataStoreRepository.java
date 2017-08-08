package com.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * This class consist of method which are common to all framework
 * 
 * @author bharatp : 14/04/2017
 *
 */
public class DataStoreRepository {
	private String folderName;
	private String fileName;

	public DataStoreRepository(String folderNmae, String fileName) {
		this.folderName = folderNmae;
		this.fileName = fileName;
	}

	final static Logger LOGGER = Logger.getLogger(DataStoreRepository.class.getName());

	/**
	 * This method will load the data from selected property file
	 * 
	 * @param folderName
	 * @param fileName
	 * @return property data
	 * @throws HandleException
	 * @throws FileNotFoundException
	 */
	private Properties loadData(String folderName, String fileName) throws HandleException {
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
	private void populateMap(IDataStoreInMap dataStoreInMap)throws HandleException {
		Properties data = loadData(folderName, fileName);

		Set<String> propertyNames = data.stringPropertyNames();
		for (String Property : propertyNames) {
			dataStoreInMap.put(Property, data.getProperty(Property));
		}
	}

	public IDataStoreInMap CreateDataStoreForFile() throws HandleException{
			DataStoreInMap dataStore = new DataStoreInMap();
			populateMap(dataStore);
			return dataStore;
			
	}	
}
