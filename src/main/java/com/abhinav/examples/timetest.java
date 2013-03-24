package com.abhinav.examples;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class timetest {
	
  final static Logger logger = LoggerFactory.getLogger(timetest.class);
	
	public static void main(String args[]){
	  
	  PropertyConfigurator.configure("/Users/abhinav.prakash/adroit_repo/thrift/thrift-example/examples/conf/test.log4j.properties");
	
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd-HH");//dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);
    System.out.println(strDate);
    System.out.println("in finally");
    
    
    try {
    logger.debug("hello testing the log");
    System.out.println("logged"); 
    } catch(Exception e) {
       
      e.printStackTrace();
      System.out.println("Message is : "+ e.getMessage());
      
    } finally {
      System.out.println("in finally");
    }
	
	}
}
