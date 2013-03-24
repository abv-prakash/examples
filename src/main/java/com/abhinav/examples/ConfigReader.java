package com.abhinav.examples;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


/**
 * @author abhinav.prakash
 * 
 */
public class ConfigReader
{

    public static void main(final String args[])
    {
        Properties prop = new Properties();
        try
        {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("test.properties"));
            String errorKey = prop.get("db.site.query").toString();
            System.out.println(errorKey);
            List<String> error_keys = Arrays.asList(errorKey.toLowerCase().split(","));
            System.out.println(error_keys);
            if (error_keys.contains("key_busy"))
            {
                System.out.println("List has keybusy");
            }

            String errorMirror = prop.getProperty("error_mirror");
            System.out.println(errorMirror);

        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
