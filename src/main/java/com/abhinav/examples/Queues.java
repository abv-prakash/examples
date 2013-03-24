package com.abhinav.examples ;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



public class Queues {
  
  
  
  
  public static void countDownTimer(int time) {
    
    Queue<Integer> queue = new LinkedList<Integer>() ;
    
    try {
    
    for (int i = time ; i >=0 ; i++) {
      queue.add(i) ;
      
    }
    
    while (!queue.isEmpty()){
      System.out.println(queue.remove());
      Thread.sleep(1000);
      
    }
    
    } catch(Exception e) {
      e.printStackTrace() ;
    }
  
  }
  
  public static <E> List<E> heapSort(Collection<E> c) {
    /*
     * can be also done b simple Collections.sort() method
     */
    
    
    List<E> sortedList = new ArrayList<E>() ;
    Queue<E> queue = new PriorityQueue<E>(c) ;
    
    while (!queue.isEmpty()) {
      sortedList.add(queue.remove());
      
    }
    
    return sortedList ;
    
    
    
  }
    
    public static void main(String[] args) {
      
      if (args.length == 0 ) {
        System.out.println("Usage : time");
        System.exit(1);
      }
      
      Integer time = Integer.parseInt(args[0]) ;
      countDownTimer(time);
      
      
      
      
    }
    
    
  
  
  
}