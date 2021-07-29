package com.grp10.log4j;

import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
      
    	PropertyConfigurator.configure("resources/log4j.properties");
    	logger.info("APP INITIATED THE LOGGER");
		logger.warn("APP WARNING MESSAGE!");
    }
}
