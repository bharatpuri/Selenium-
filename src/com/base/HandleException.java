package com.base;

import org.apache.log4j.Logger;

/**
 * Handle the custom exceptions
 * 
 * @author bharatp Date: 29 June 2017
 */
public class HandleException extends Exception {
	
	final static Logger LOGGER = Logger.getLogger(CommonUtility.class.getName());
	private static final long serialVersionUID = 1L;

	public HandleException(String message) {
		super(message);
		LOGGER.debug(message);
	}
}
