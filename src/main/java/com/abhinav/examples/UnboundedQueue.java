package com.abhinav.examples;

import java.util.LinkedList;
import java.util.List;

class WorkerQueue {

  private LinkedList<Object> Queue = new LinkedList<Object>();

  public synchronized void addWork(Object o) {

    Queue.addLast(o);
    notify();

  }

  public synchronized Object getWork() {
    if (Queue.isEmpty()) {
      try {
        wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return Queue.removeFirst();
  }

}

class Producer extends Thread {

  private String threadName;
  WorkerQueue queue;

  public Producer(String name, WorkerQueue queue) {
    this.threadName = name;
    this.queue = queue;
  }

  public void run() {

    for (int i = 0; i <= 10; i++) {
      System.out.format("Thread %s, added object : %s%n ", threadName, i);
      queue.addWork(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}

class Consumer extends Thread {

  private String threadName;
  WorkerQueue queue;

  public Consumer(String name, WorkerQueue queue) {
    this.threadName = name;
    this.queue = queue;
  }

  public void run() {
    while (true) {
      System.out.format("Thread %s got work %s%n", threadName, queue.getWork());
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}

public class UnboundedQueue {

  public static void main(String[] args) {

    WorkerQueue queue = new WorkerQueue();
    int numProducers = 10, numConsumers = 5;
    Producer[] producers = new Producer[numProducers];
    Consumer[] consumers = new Consumer[numConsumers];

    for (int i = 0; i < numProducers; i++) {
      producers[i] = new Producer("Producer: " + i, queue);
      producers[i].start();
    }

    for (int j = 0; j < numConsumers; j++) {
      consumers[j] = new Consumer("Consumer:" + j, queue);
      consumers[j].start();
    }

  }

}
