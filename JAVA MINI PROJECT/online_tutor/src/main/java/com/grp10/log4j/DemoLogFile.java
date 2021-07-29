package com.grp10.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class DemoLogFile {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger("DemoLogFile.class");
		//DEFAULT APPENDER AND LAYOUT	
		BasicConfigurator.configure();
		logger.info("INITIATED THE LOGGER");
		logger.warn("WARNING MESSAGE!");
	}

}
