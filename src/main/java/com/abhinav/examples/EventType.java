/**
 * Copyright (C) 2012-2013 InMobi Pvt. Ltd.
 * http://www.inmobi.com
 * http://www.inmobi.com/about-us/contact-us/
 * All rights reserved
 */

package com.abhinav.examples;

/**
 * 
 */
public enum EventType {
  
  DEFAULT(1);
  
  private final int value;
  EventType(final int val){
    this.value = val;
  }
  
  static public enum GoalType {
    DOWNLOAD, INSTALL;

  }

  static public enum ClickType {
    INITIAL, FINAL;
  }
  

}
