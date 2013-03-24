package com.abhinav.examples ;

import java.util.SortedSet;



public class Sets {
  
  
  
  
  
  public void getWordsCount(SortedSet<String> dict) {

    for (char ch = 'a'; ch <= 'z' ;) {
      String from = String.valueOf(ch++) ;
      String to = String.valueOf(ch) ;
      Integer WordsCount = dict.subSet(from, to).size(); 
      System.out.println("Words Starting from:" + from + "to :" + to + "are" + WordsCount) ;
    }
    
    
    
  }
  
  
  
  
}