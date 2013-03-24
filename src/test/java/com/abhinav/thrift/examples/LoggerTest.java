package com.abhinav.thrift.examples;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abhinav.examples.logtest;


public class LoggerTest
{

    private static Logger logger = LoggerFactory.getLogger(logtest.class);

    @Test
    public void test()
    {

        PropertyConfigurator
                .configure("/Users/abhinav.prakash/adroit_repo/thrift/thrift-example/examples/conf/test.log4j.properties");
        System.out.print("hello");

        logger.info("logtest files :: hello testing the log");
        logger.info("logtest files :: this should be in 2nd line");

        new Clicktest().click();
        new Beacontest().beacon();

    }

    public void clickrun()
    {

        new Clicktest().click();

    }

    public void beaconrun()
    {
        new Beacontest().beacon();
    }

}

class Clicktest
{

    private final Logger logger      = LoggerFactory.getLogger(Clicktest.class);
    private final Logger logger_test = LoggerFactory.getLogger("com.test.z");

    public void click()
    {

        logger.info("logtest files :: this is click");
        logger_test.info("logtest files :: this is in random ");

    }

}

class Beacontest
{

    private final Logger logger = LoggerFactory.getLogger(Beacontest.class);

    public void beacon()
    {

        logger.info("logtest files :: this is beacon ");
    }
}
