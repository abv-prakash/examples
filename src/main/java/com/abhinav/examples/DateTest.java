package com.abhinav.examples ;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTest{
  
  
  public static enum TestEnum {
    
    TEST_ENUM ,
    
    
  }
  
  public static void main(String[] args){
    
    Date cur_date = new Date();
    System.out.println(cur_date);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
    String formatted_date = sdf.format(cur_date);
    System.out.println(formatted_date);
    Long epochtime = cur_date.getTime();
    System.out.println(epochtime);
    System.out.println(TestEnum.TEST_ENUM.toString());
  }
  
  
}



