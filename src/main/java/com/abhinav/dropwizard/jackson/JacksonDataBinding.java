/**
 * Copyright (C) 2012-2013 InMobi Pvt. Ltd.
 * http://www.inmobi.com
 * http://www.inmobi.com/about-us/contact-us/
 * All rights reserved
 */

package com.abhinav.dropwizard.jackson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.apache.commons.codec.binary.Base64;


/**
 * @author abhinav.prakash
 */
public class JacksonDataBinding {


  public static void bindJsonToDataFromFile() throws JsonParseException, JsonMappingException, IOException {
    
    String fileName =
        "/Users/abhinav.prakash/adroit_repo/git_abv/examples/src/main/resources/jacksontest.json";

    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
    User user = mapper.readValue(new File(fileName), User.class);

    System.out.println("User is :" + user);

  }

  public static void bindJsonFromString() throws JsonParseException, JsonMappingException,
      IOException {
    
    String jsonString =
        "{\"name\" : { \"first\" : \"Joe\", \"last\" : \"Sixpack\" },\"gender\" : \"MALE\",\"verified\" : false}"; // ,\"userImage\" : \"Rm9vYmFyIQ==\"}";

    ObjectMapper mapper = new ObjectMapper();
    User user = mapper.readValue(jsonString, User.class);
    System.out.println("User is :" + user);

  }

  public static void bindJsonFromBase64CompressedData() throws JsonParseException,
      JsonMappingException, IOException {

    String jsonString =
        "{\"name\" : { \"first\" : \"Joe\", \"last\" : \"Sixpack\" },\"gender\" : \"MALE\",\"verified\" : false,\"userImage\" : \"Rm9vYmFyIQ==\"}";
    System.out.println("JsonString bytearray lenght:" + jsonString.getBytes().length);

    ByteArrayOutputStream brStream = new ByteArrayOutputStream(jsonString.length());
    GZIPOutputStream gzStream = new GZIPOutputStream(brStream);
    gzStream.write(jsonString.getBytes());
    gzStream.close();
    System.out.println("Compressed  String:" + brStream.toByteArray());
    System.out.println("Compressed gzip bytearray lenght:" + brStream.size());
    String compressedString = Base64.encodeBase64String(brStream.toByteArray());
    System.out.println("Compressed encoded String:" + compressedString);
    System.out.println("Compressed JsonString bytearray lenght:"
        + compressedString.getBytes().length);
    
    try {
      String decompressedString = decompressBase64String(compressedString);
      ObjectMapper mapper = new ObjectMapper();
      User user = mapper.readValue(decompressedString, User.class);
      System.out.println("After decompressing - User is :" + user);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static String decompressBase64String(final String compressedString) throws Exception {
    try {
      final int BUFFER_SIZE = 512;
      final InputStream byteInputStream = new ByteArrayInputStream(compressedString.getBytes());
      final Base64InputStream b64InputStream = new Base64InputStream(byteInputStream);
      final GZIPInputStream gzipInputStream = new GZIPInputStream(b64InputStream);

      final StringBuilder decompressedString = new StringBuilder();
      byte[] data = new byte[BUFFER_SIZE];
      int bytesRead;
      while ((bytesRead = gzipInputStream.read(data)) != -1) {
        decompressedString.append(new String(data, 0, bytesRead));
      }
      gzipInputStream.close();
      byteInputStream.close();
      return decompressedString.toString();
    } catch (Exception e) {
      throw new Exception("Exception: Corruption in payload compression/encoding");
    }
  }

  public static void bindJsonFromBase64CompressedDataArray() throws JsonParseException,
      JsonMappingException, IOException {

    String jsonString =
        "[{\"name\" : { \"first\" : \"Joe\", \"last\" : \"Sixpack\" },\"gender\" : \"MALE\",\"verified\" : false,\"userImage\" : \"Rm9vYmFyIQ==\"},{\"name\" : { \"first\" : \"Jane\", \"last\" : \"pack\" },\"gender\" : \"FEMALE\",\"verified\" : false,\"userImage\" : \"Rm9vYmFyIQ==\"}]";
    System.out.println("JsonString bytearray lenght:" + jsonString.getBytes().length);

    ByteArrayOutputStream brStream = new ByteArrayOutputStream(jsonString.length());
    GZIPOutputStream gzStream = new GZIPOutputStream(brStream);
    gzStream.write(jsonString.getBytes());
    gzStream.close();
    System.out.println("Compressed  String:" + brStream.toByteArray());
    System.out.println("Compressed gzip bytearray lenght:" + brStream.size());
    String compressedString = Base64.encodeBase64String(brStream.toByteArray());
    System.out.println("Compressed encoded String:" + compressedString);
    System.out.println("Compressed JsonString bytearray lenght:"
        + compressedString.getBytes().length);

    try {
      String decompressedString = decompressBase64String(compressedString);
      ObjectMapper mapper = new ObjectMapper();
      JsonParser jsonParser = new JsonFactory().createJsonParser(decompressedString);
      JsonToken jsonStartToken = jsonParser.nextToken(); // return START_ARRAY token
      System.out.println("Json Starting token:" + jsonStartToken);
      Iterator<User> it = mapper.readValues(jsonParser, User.class);

      while (it.hasNext()) {
        System.out.println("After decompressing - User is :" + it.next());
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void bindJsonFromStringArrays() throws JsonParseException, JsonMappingException,
      IOException {

    String jsonString =
        "[{\"name\" : { \"first\" : \"Joe\", \"last\" : \"Sixpack\" },\"gender\" : \"MALE\",\"verified\" : false,\"userImage\" : \"Rm9vYmFyIQ==\"},{\"name\" : { \"first\" : \"Jane\", \"last\" : \"pack\" },\"gender\" : \"FEMALE\",\"verified\" : false,\"userImage\" : \"Rm9vYmFyIQ==\"}]";

    ObjectMapper mapper = new ObjectMapper();
    JsonParser jsonParser = new JsonFactory().createJsonParser(jsonString);
    jsonParser.nextToken(); // // will return JsonToken.START_OBJECT (verify?)
    // User[] users = mapper.readValue(jsonString, User[].class); // gives error
    // System.out.println("Users[] are :" + users);
    Iterator<User> it = mapper.readValues(jsonParser, User.class);

    while (it.hasNext()) {

      System.out.println("Users are :" + it.next());

    }

  }

  public static void bindJsonFromFileArrays() throws JsonParseException, JsonMappingException,
      IOException {

    String fileName =
        "/Users/abhinav.prakash/adroit_repo/git_abv/examples/src/main/resources/jacksontestArray.json";

    ObjectMapper mapper = new ObjectMapper();
    JsonParser jsonParser = new JsonFactory().createJsonParser(new File(fileName));
    // User[] users = mapper.readValue(jsonString, User[].class);
    Iterator<User> it = mapper.readValues(jsonParser, User.class);

    while (it.hasNext()) {

      System.out.println("Users are :" + it.next());

    }

  }

  public static void bindJsonFromArrays() throws JsonParseException, JsonMappingException,
      IOException {

    String jsonString =
        "[{\"name\" : { \"first\" : \"Joe\", \"last\" : \"Sixpack\" },\"gender\" : \"MALE\",\"verified\" : false,\"userImage\" : \"Rm9vYmFyIQ==\"},{\"name\" : { \"first\" : \"Jane\", \"last\" : \"pack\" },\"gender\" : \"FEMALE\",\"verified\" : false,\"userImage\" : \"Rm9vYmFyIQ==\"}]";

    ObjectMapper mapper = new ObjectMapper();
    JsonParser jsonParser = new JsonFactory().createJsonParser(jsonString);
    // Users users = mapper.readValue(jsonString, Users.class);
    // Map<String, Object> jsonMap = mapper.readValue(jsonString, Map.class);
    // System.out.println("Users are :" + users);

    JsonFactory jsonFactory = new JsonFactory();
    jsonParser.nextToken();

    while (jsonParser.nextToken() == JsonToken.START_OBJECT) {
      User user = mapper.readValue(jsonParser, User.class);
      System.out.println("User :" + user);
    }


  }


  public static void main(String... args) {

    try {
      // bindJsonToDataFromFile();
      // bindJsonFromString();
      // bindJsonFromBase64CompressedData();
      // System.out.println("***** Multiple array of objects in one object from String ****");
      // bindJsonFromStringArrays();
      // System.out.println("***** Multiple array of objects in one object from FIle ****");
      // bindJsonFromFileArrays();
      // bindJsonFromArrays();
      bindJsonFromBase64CompressedDataArray();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
