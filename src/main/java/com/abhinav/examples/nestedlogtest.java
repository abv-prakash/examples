package com.abhinav.examples ;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class nestedlogtest {
 
   private static Logger logger = LoggerFactory.getLogger(nestedlogtest.class);
   
   static class Clicktest {  
     
     public static Logger logger = LoggerFactory.getLogger(nestedlogtest.class.getName() + ".Clicktest");
     private static Logger logger_test = LoggerFactory.getLogger("com.test.z");
     private final int clicks = 10;
     private final int testcount = 20;
     
     public void click(){
       
       
       logger.debug("this is click : {} and testcount {}" , clicks, testcount);
       logger_test.info("this is hard coded logger ");
       
       new logtest().clickrun();
       
       
     }
     
   }
   
   static class Beacontest{
     
     public static Logger logger = LoggerFactory.getLogger(nestedlogtest.class.getName() + ".Beacontest");
     public void beacon(){
       
       logger.debug("this is beacon");
       
       new logtest().beaconrun();
     }
   }

  
  public static void main(String args[]){
    
    PropertyConfigurator.configure("/Users/abhinav.prakash/adroit_repo/thrift/thrift-example/examples/conf/test.log4j.properties");
    System.out.print("hello");
    
   logger.debug("hello testing the log");
   logger.debug("this should be in 2nd line");
   
     new Clicktest().click();
     new Beacontest().beacon();
     
  }
  
}
  
  
  

  
