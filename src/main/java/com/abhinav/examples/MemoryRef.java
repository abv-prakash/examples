package com.abhinav.examples;

/**
 * @author abhinav.prakash
 * 
 */
public class MemoryRef
{

    private static Integer    var = 10;
    private static ParseImpid parseRef;

    public static void init()
    {
        parseRef = new ParseImpid();
    }

    private static void changeInt(Integer num)
    {
        System.out.println(num);
        num = 5;
        System.out.println(num);
    }

    private static void passObjRef(final ParseImpid classRef)
    {
        System.out.println(classRef);

    }

    public static void main(final String args[])
    {
        System.out.println(var);
        changeInt(var);
        System.out.println(var);
        init();
        System.out.println(parseRef);
        passObjRef(parseRef);

    }

}
