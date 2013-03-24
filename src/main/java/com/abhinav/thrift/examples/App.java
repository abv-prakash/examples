package com.abhinav.thrift.examples;

import java.io.*;
import java.util.Calendar;

import java.util.*;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;

import org.apache.thrift.transport.TTransport;
import sun.misc.BASE64Decoder;

//import com.inmobi.types.adserving.AdRR;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
    public static void main( String[] args ) throws FileNotFoundException,IOException,TException
    {
    	
    	try {
    	File file = new File(args[0]);
    	
    	FileInputStream fin = null;
        FileWriter writer = null;
    
    	fin = new FileInputStream(file);
      
        byte[] fileBytes = new byte[fin.available()];
        int fileSize = fin.read(fileBytes);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decodedBytes = decoder.decodeBuffer(fileBytes.toString());
  //      AdRR adrr = new AdRR();
    //    deserializer.deserialize(adrr, decodedBytes);
    //    System.out.println(adrr.impressions);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
        
    }
}
