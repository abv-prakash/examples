package com.abhinav.examples;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class logtest
{

    private static Logger       logger       = LoggerFactory.getLogger(logtest.class);
    private final static Logger logger_click = LoggerFactory.getLogger(Clicktest.class);
    private final static Logger logger_test  = LoggerFactory.getLogger("com.test.z");

    public static void main(final String args[])
    {

        PropertyConfigurator
                .configure("/Users/abhinav.prakash/adroit_repo/thrift/thrift-example/examples/conf/test.log4j.properties");
        System.out.println("hello");

        checkFileFilter();

        // logger.debug("logtest files :: hello testing the log");
        // logger.debug("logtest files :: this should be in 2nd line");
        //
        // new Clicktest().click(logger_click, logger_test);
        // new Beacontest().beacon();

    }

    public static void checkFileFilter()
    {
        String path = System.getProperty("user.home") + File.separator + "temp";
        System.out.println(path.toString());
        File dir = new File(path);
        final String pattern = "temp.log.+";

        File[] files = dir.listFiles(new FilenameFilter()
        {

            public boolean accept(final File arg0, final String arg1)
            {
                return arg1.matches(pattern);
            }
        });

        for (File file : files)
        {
            System.out.println(file.toString());
        }

    }

    public void clickrun()
    {

        new Clicktest().click(logger_click, logger_test);

    }

    public void beaconrun()
    {
        new Beacontest().beacon();
    }

}

class Clicktest
{

    public void click(final Logger logger_click, final Logger logger_test)
    {

        logger_click.debug("logtest files :: this is click");
        logger_test.debug("logtest files :: this is in random ");

    }

}

class Beacontest
{

    private final Logger logger = LoggerFactory.getLogger(Beacontest.class);

    public void beacon()
    {

        logger.debug("logtest files :: this is beacon ");
    }
}
