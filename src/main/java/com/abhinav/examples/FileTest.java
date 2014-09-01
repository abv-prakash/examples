package com.abhinav.examples;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;


/**
 * @author abhinav.prakash
 * 
 */
public class FileTest
{

    /**
     * @param args
     */
    public static void main(final String[] args)
    {
        longTest();
        File file = new File("/Users/abhinav.prakash/click/listfile.csv");

        Set<String> set = new HashSet<String>();
        set.add("abc");
        set.add("123");
        set.add("hello");

        try
        {

            System.out.println("absolute path :" + file.getAbsolutePath());
            System.out.println(file.getParentFile() + "\n" + file.getParent() + "\n" + file.getCanonicalPath());

            if (!file.getParentFile().exists())
            {
        System.out.println("file parent dir not exists");
                FileUtils.forceMkdir(file.getParentFile());
      } else if (file.exists()) {
        System.out.println("file exists");
            }

      File destFile = new File("/Users/abhinav.prakash/click/listfile.csv" + ".2013-09-23");

      System.out.println("File modified time:" + file.lastModified());

      for (int i = 1; i < 100; i++) {
      if (!destFile.exists() && file.length() != 0) {
        FileUtils.moveFile(file, destFile);
        file.createNewFile();
      } else {
        System.out.println("Dest File modified time:" + destFile.lastModified());
      }

      }

      System.out.println("Current sys time" + System.currentTimeMillis());
      System.out.println("Current Calendar sys time" + Calendar.getInstance().getTime());

      // if (System.currentTimeMillis() - file.lastModified() > 3600000) {
      // System.out.println("true it works");
      // }
      //
      // if (file.createNewFile())
      // {
      // System.out.println("file created");
      // }
      // System.out.println("File length:" + file.length());
      // // FileUtils.touch(file);

            // FileUtils.writeLines(file, set);

        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void longTest()
    {
        Float fl = (Float.valueOf(1803444f / (1024f * 1024f)));
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(df.format(fl));
    }
}
