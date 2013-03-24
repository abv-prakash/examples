package com.abhinav.examples;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;


public class ResourceTest
{

    private final InputStream is, propFile;
    private final Properties  prop = new Properties();

    public ResourceTest()
    {

        is = getClass().getResourceAsStream("/testfile.txt");
        System.out.println("in constructor");

        propFile = getClass().getResourceAsStream("/test.properties");
        // propFile = getClass().getResourceAsStream(
        // "/Users/abhinav.prakash/adroit_repo/thrift/thrift-example/examples/src/main/resources/test.properties");

    }

    public static void main(final String arg[])
    {

        // InputStream inputStream =
        // Thread.currentThread().getContextClassLoader().getResourceAsStream("/testfile.txt");

        ResourceTest rt = new ResourceTest();

        try
        {
            System.out.println("propFile : " + rt.propFile);
            // rt.prop.load(rt.propFile); // from class path
            rt.prop
                    .load(new FileInputStream(
                            "/Users/abhinav.prakash/adroit_repo/thrift/thrift-example/examples/src/main/resources/test.properties")); // from
                                                                                                                                      // absolute
                                                                                                                                      // path
            System.out.println("is : " + rt.is);
            System.out.println("String : " + rt.convertStreamToString(rt.is));
            rt.readProperties(rt.prop);

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    public void readProperties(final Properties prop)
    {

        System.out.println(prop.getProperty("host"));
        System.out.println(prop.getProperty("port"));
        System.out.println(prop.getProperty("name"));

    }

    public String convertStreamToString(final InputStream is) throws IOException
    {
        if (is != null)
        {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try
            {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1)
                {
                    System.out.println("n is : " + n);
                    writer.write(buffer, 0, n);
                }
            }
            finally
            {
                is.close();
            }
            return writer.toString();
        }
        else
        {
            return "";
        }
    }

}