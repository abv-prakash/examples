package com.abhinav.examples ;



public class Datatypes {
 
  public static void  get() {
    
    System.out.println("get in Datatypes");
    
  }
  
  public void set() {
    System.out.println("set in Datatypes");
    
  }
  
public static void main(String[] args) {
    
    IntType derived = new IntType() ;
    derived.set() ;
    IntType.get() ;
    Datatypes.get() ;
    
  }
  
}


class IntType extends Datatypes {
  
  public static void get() {
    System.out.println("get in Inttypes");
    
  }
  
  public void set(){
    
    System.out.println("set in Inttypestypes");
  }
  
  
  
  
}