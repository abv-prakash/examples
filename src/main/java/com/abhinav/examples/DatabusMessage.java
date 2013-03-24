package com.abhinav.examples;

import java.io.File;


public class DatabusMessage
{

    public static void main(final String[] args)
    {

        try
        {

            String test = "test";
            byte[] testArray = test.getBytes();

            // Message message = new Message(testArray);
            String path = System.getProperty("user.home") + File.separator + "testMessage";

            File file = new File(path);
            Boolean flag = file.mkdirs();
            System.out.println(flag);

            // Files.createParentDirs(file);

            // FileUtils.forceMkdir(new File(path));

            try
            {
                Thread.sleep(6000);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // FileOutputStream fs = new FileOutputStream(path);
            // fs.write(testArray);
            //
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}