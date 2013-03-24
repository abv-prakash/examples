package com.abhinav.examples ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class ListTest<E> {
  
  
  public static <E> void swap (List<E> list, int i, int j ) {
    
    E tmp = list.get(i);
    list.set(i,list.get(j));
    list.set(j, tmp);
    
  }
   
  
  public static <E> void shuffle(List<E> list, Random rnd) {
    
    for (int i=0; i< list.size(); i++ ) {
            swap(list,i,rnd.nextInt(list.size() -1)) ;
      
    }
    
  }
  
  public static <E> void replace (List<E> list, E e , E val ){
    
    for (ListIterator<E> it = list.listIterator() ; it.hasNext(); ) {
      if ( e == null ? it.next() == null : e.equals(it.next())) {
            // list.set(it.previousIndex(), val) ;
            it.set(val); 
             
      }
      
    }   
    
  }
  
 public static <E> void replace(List<E> list, E e, List<? extends E> vals) {
   
   for(ListIterator<E> it = list.listIterator(list.size()) ; it.hasPrevious() ;) {
     if (e == null ? it.previous() == null : e.equals(it.previous())) {
           it.remove();
           for (E a : vals) {
             it.add(a) ;
             
           }
       
     }
     
     
   }
   
   
   
 }
  
 public static <E> List<E> dealHand(List<E> deck , int n) {
   
   int deckSize = deck.size() ;
   List<E> handView = deck.subList(deckSize-n, deckSize);
   List<E> hand = new ArrayList<E>(handView) ;
   handView.clear();
   return hand ;
   
 }
 
 public static <E> List<E> reverse(List<E> list) {
   
   List<E> newList = new ArrayList<E>() ;
   
   for ( ListIterator<E> it = list.listIterator(list.size()); it.hasPrevious() ;) {
     newList.add(it.previous());     
   }
   
   return newList ;
   
 }
   

 public static <E>  void  copy(List<E> srcList , List<E> destList) {
   
   for (Iterator<E> it = srcList.listIterator() ; it.hasNext() ;) {
         destList.add(it.next()) ;
   }
   
   
 }
 
 
 public static <E> int indexOfSubList(List<E> list, List<E> subList) {
   
   int k = 0, pos = -1 ;
   
    for (int i=0; i<= (list.size() - subList.size()); i++) {
      k = 0 ;
      for (int j=0;j<subList.size(); j++) {
           if (list.get(i).equals(subList.get(j))) {
                 i++ ;
                 k++ ;
           }
        
      }
      
      if ( k == (subList.size()) ) {
        pos = i-k ;
        
      }
      
    }
    
    return pos ;
    
    
  
 }
  
  
  
  
  
  
  public static void main(String args[]) {
    
    
    // tc1
    List<String> advIdList = new ArrayList<String>(Arrays.asList("4028cb8b2c72be06012c730c71bc0007", "4028cb8b2cac6e3d012cadc694f10016", "4028cb8b2bedad5c012bf2b100570068"));
    Integer size = advIdList.size() ;
    System.out.println(size) ;
    String advId ;
    for (int i = 0; i < size; i++) {

      advId = advIdList.get(i);
   //   System.out.println(advId) ;
    }
    
    
    //tc2
    List<String> list = new ArrayList<String>();
    for (String s : args) {
        list.add(s);
      
    }
   // shuffle(list, new Random());
    System.out.println(list) ;
    
    for (ListIterator<String> it = list.listIterator(list.size()) ; it.hasPrevious() ; ) {
    //  System.out.println(it.next()) ;
    //  System.out.println(it.previous());
      break ;
      
      
    }
    
    //tc3
    
    replace(list,"shuffle","replace") ;
    System.out.println(list) ;
    
    List<String> vals = new ArrayList<String>(Arrays.asList("replace1","replace2")) ;
    replace(list,"replace",vals) ;
    System.out.println(list) ;
    
    //tc4
    int fromIndex = 2, toIndex =4 ;
    List<String> sublist = list.subList(fromIndex, toIndex) ;
    
    try {
    
    List<String> copySubList = new ArrayList<String>(sublist);
    System.out.println(copySubList) ;
    //sublist.clear() ;
    System.out.println(sublist) ;
    System.out.println(copySubList) ;
    System.out.println(list) ;
    Thread.sleep(10);
    
    
    } catch(Exception e) {
      e.printStackTrace() ;
    }
    
    //tc5
    
    int numHands = 13 ;
    int cardPerHand = 4 ;
    
    
    String[] suit = new String [] {"spade", "hearts", "clubs", "diamonds"};
    String[]  rank = new String[] {
        "ace", "2", "3", "4",
        "5", "6", "7", "8", "9", "10", 
        "jack", "queen", "king" 
    };
    
    List<String> deck = new ArrayList<String>() ;
    
    for (int i=0;i<suit.length;i++) {
      for (int j=0;j<rank.length;j++){
        deck.add(rank[j] + " of " + suit[i]) ;
      }
    }
    
    shuffle(deck, new Random());
    
    for (int i=0;i<numHands;i++) {
      
      List<String> hand = dealHand(deck, cardPerHand);
     // System.out.println("The hand is :" + hand) ;
      
    }
    
    Collections.reverse(list) ;
    System.out.println("Reverse : "+list);
    System.out.println(reverse(list));
    List<String> destlist = new ArrayList<String>() ; 
    copy(list,destlist) ;
    System.out.println(destlist);
    List<String> subList = new ArrayList<String>() ; //(Arrays.asList("testing", "the")) ;
    Collections.addAll(subList, "testing", "the");
    System.out.println(indexOfSubList(list, subList));
    
    
  }
  
}