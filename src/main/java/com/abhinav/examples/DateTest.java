package com.abhinav.examples ;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateTest{
  
  private final static int DAYS_TO_GOBACK = 10;
  
  public static enum TestEnum {
    
    TEST_ENUM ,
    
    
  }
  
  private static void testDate() {
    Date cur_date = new Date();
    System.out.println(cur_date);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
    String formatted_date = sdf.format(cur_date);
    System.out.println(formatted_date);
    Long epochtime = cur_date.getTime();
    System.out.println(epochtime);
    System.out.println(TestEnum.TEST_ENUM.toString());

  }

  private static String getExpiryStringDate(final int deltaDays) {
    int startDayDelta = 0;
    int daysToGoBack = DAYS_TO_GOBACK + startDayDelta + deltaDays;
    Calendar cal = Calendar.getInstance();
    // cal.roll(Calendar.DAY_OF_YEAR, -daysToGoBack);
    cal.add(Calendar.DAY_OF_YEAR, -daysToGoBack);
    Date date = cal.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    System.out.println("Click Clean up running for Date : " + sdf.format(date));
    return sdf.format(date);
  }

  public static void main(String[] args){
    
    System.out.println(getExpiryStringDate(2));

  }
  
  
}



