/**
 * Copyright (C) 2012-2013 InMobi Pvt. Ltd.
 * http://www.inmobi.com
 * http://www.inmobi.com/about-us/contact-us/
 * All rights reserved
 */

package com.abhinav.dropwizard.jackson;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author abhinav.prakash
 */
public class JacksonInnerClassBinding {


  public static void bindInnerClass() throws JsonParseException, JsonMappingException, IOException {

    String jsonString = "{\"name\":\"john\", \"class\":2}";

    ObjectMapper mapper = new ObjectMapper();
    Student student = mapper.readValue(jsonString, Student.class);
    System.out.println("Student is :" + student);

  }


  public static void main(String[] args) {

    try {
      bindInnerClass();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public static class Student {
    
    @JsonProperty("name")
    String name;
    
    @JsonProperty("class")
    Integer standard;

    @Override
    public String toString() {
      return "Name:" + this.name + "Standard:" + this.standard;
    }

  }

}
