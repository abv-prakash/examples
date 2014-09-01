/**
 * Copyright (C) 2012-2013 InMobi Pvt. Ltd.
 * http://www.inmobi.com
 * http://www.inmobi.com/about-us/contact-us/
 * All rights reserved
 */

package com.abhinav.examples;

import com.abhinav.examples.EventType.GoalType;



/**
 * 
 */
public class EnumTest {
  enum EventType {
    CLICK(1), GOAL(2);

    private final int value;

    EventType(final int value) {
      this.value = value;
    }



  }
  

  public static void testEnum(final GoalType type) {

    switch (type) {

      case INSTALL:
        break;

      case DOWNLOAD:



    }


  }


  /**
   * @param args
   */
  public static void main(final String[] args) {

    String val = EventType.CLICK.toString();
    System.out.println(val);

    System.out.println("enum values" + EventType.values());
  }
  
}



