/**
 * Copyright (C) 2012-2013 InMobi Pvt. Ltd. http://www.inmobi.com
 * http://www.inmobi.com/about-us/contact-us/ All rights reserved
 */

package com.abhinav.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 
 */
public class ConcurrencyTest {

  // final Set<String> pool = Collections.synchronizedSet(new HashSet<String>());
  final static HashSet<String> pool = new HashSet<String>();
  private final static Object lockObj = new Object();


  private synchronized void lock(String key) throws InterruptedException {
    System.out.println("Locking for thread :" + Thread.currentThread().getName() + "key:" + key);

    System.out.println("inside sync for key:" + key + " and thread:"
        + Thread.currentThread().getName() + "  Pool :" + pool);
    while (pool.contains(key)) {
      // already being locked
      System.out.println("Waiting for thread :" + Thread.currentThread().getName() + "key:" + key);
      wait(); // wait for release
    }

    pool.add(key); // I lock it
    System.out.println("Aquired Locking for thread :" + Thread.currentThread().getName() + "key:"
        + key + "  Pool :" + pool);
  }

  private synchronized void unlock(String key) {
    System.out.println("UnLocking for thread :" + Thread.currentThread().getName() + "key:" + key
        + "  Pool :" + pool);
    pool.remove(key);
    notifyAll();
    System.out.println("Notifying for thread :" + Thread.currentThread().getName() + "key:" + key
        + "  Pool :" + pool);
  }

  void doSomething(String key) throws InterruptedException {
    lock(key);
    System.out.println("Doing something in critical section for thread :"
        + Thread.currentThread().getName() + "key:" + key);
    Thread.sleep(20000);
    unlock(key);
    System.out.println("Doing something in Non critical section for thread :"
        + Thread.currentThread().getName() + "key:" + key);


  }

  /**
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {

    ExecutorService executors = Executors.newFixedThreadPool(10);
    final ConcurrencyTest cTest = new ConcurrencyTest();

    final List<String> threadNames = new ArrayList<String>();
    for (int i = 0; i < 5; i++) {
      threadNames.add("Thread-" + RandomUtils.nextInt());
    }

    System.out.println("Started thread :" + Thread.currentThread().getName());
    executors.execute(new Runnable() {

      public void run() {
        try {
          cTest.doSomething(String.valueOf(100));
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    executors.execute(new Runnable() {

      public void run() {
        try {
          cTest.doSomething(String.valueOf(200));
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    Thread.sleep(2000);
    System.out.println("Invoked first Iteration...");

    for (int i = 1; i <= 2; i++) {
      final int j = i;
      executors.execute(new Runnable() {

        public void run() {
          // Thread.currentThread().setName(threadNames.get(j));
          System.out.println("Started thread :" + Thread.currentThread().getName());
          // for (int i = 0; i < 10; i++) {
          try {
            cTest.doSomething(String.valueOf(100));
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          // }
        }

      });

      executors.execute(new Runnable() {

        public void run() {
          // Thread.currentThread().setName(threadNames.get(j));
          System.out.println("Started thread :" + Thread.currentThread().getName());
          // for (int i = 0; i < 10; i++) {
          try {
            cTest.doSomething(String.valueOf(200));
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          // }
        }

      });
    }
    Thread.sleep(1000);
    System.out.println("Invoked Second Iteration...");

    for (int i = 3; i <= 10; i++) {
      final int j = i;
      executors.execute(new Runnable() {

        public void run() {
          // Thread.currentThread().setName(threadNames.get(j));
          System.out.println("Started thread :" + Thread.currentThread().getName());
          // for (int i = 0; i < 10; i++) {
          try {
            cTest.doSomething(String.valueOf(j + 100));
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          // }
        }

      });

      executors.execute(new Runnable() {

        public void run() {
          // Thread.currentThread().setName(threadNames.get(j));
          System.out.println("Started thread :" + Thread.currentThread().getName());
          // for (int i = 0; i < 10; i++) {
          try {
            cTest.doSomething(String.valueOf(j + 200));
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          // }
        }

      });
    }

    System.out.println("Started executor service..");

  }

}
