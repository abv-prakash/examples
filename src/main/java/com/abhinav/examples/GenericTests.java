/**
 * Copyright (C) 2012-2013 InMobi Pvt. Ltd.
 * http://www.inmobi.com
 * http://www.inmobi.com/about-us/contact-us/
 * All rights reserved
 */

package com.abhinav.examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class GenericTests {
  
  public enum TestEnum {
    E1, E2
  };
  

  public static <T> T getValueFromMap(final Map<String, T> map, final String key,
      final Class<T> valueClass) {
    T value = map.get(key);
    if (value == null) {
      try {
        value = valueClass.newInstance();
      } catch (InstantiationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      map.put(key, value);
    }
    return value;
  }
  
  
  public static <T> Map<T, String> getMap(final String value, final Class<T> type) {
    Map<T, String> map = new HashMap<T, String>();

    if (type.equals(TestEnum.class)) {
      map.put((T) TestEnum.E1, value);
    }

    return null;

  }


  public static void main(final String... args) {
    
    Map<String, List> myMap = new HashMap<String, List>();
    List<String> value = getValueFromMap(myMap, "aKey", List.class);

    Map<TestEnum, String> map = getMap("hello", TestEnum.class);

  }

}
