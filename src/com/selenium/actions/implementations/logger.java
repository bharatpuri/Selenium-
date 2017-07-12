package com.selenium.actions.implementations;

import org.apache.log4j.Logger;

public class logger {
	public static Logger getLogger(String name){
		final Logger logger = Logger.getLogger(name);
		return logger;
		
	}

}
