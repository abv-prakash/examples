package com.abhinav;

import java.util.HashMap;
import java.util.Map;


public class exampleTest
{

    public static void testMap()
    {
        Map<String, Integer> testMap = new HashMap<String, Integer>();

        testMap.put("one", 1);
        testMap.put("two", 2);

        Object one = testMap.get("one");
        System.out.println("One is " + one.toString());

        Map<Integer, String> values = new HashMap<Integer, String>();

        try
        {

            values.put(1, "hello");

            String str = values.get(2);

            // System.out.println(values.get(2).toString()) ;

            // List<String> nullList = null;
            //
            // for (String s : nullList)
            // {
            // System.out.println(s);
            // }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void testStringReplace()
    {

        String lp = "http://helloworld";
        String lpnew = "https://helloworld";

        String lp2 = "helloworld123";

        String flp = (lp.startsWith("http://") ? lp.replace("http://", "") : lp);
        String flpnew = (lpnew.startsWith("https://") ? lpnew.replace("https://", "") : lpnew);

        String flp2 = (lp2.startsWith("https") ? lp2.replace("https", "") : lp2);

        System.out.println(flp + "   " + flpnew + "   " + flp2);

    }

    public static void main(final String[] args)
    {
        testStringReplace();

    }

}
