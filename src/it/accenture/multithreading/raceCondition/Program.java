package it.accenture.multithreading.raceCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        List<String> ls = new ArrayList<>();
        Consumer c = new Consumer(ls);
        Thread consumerThread = new Thread(c);
        consumerThread.setName("C1");
        Producer p = new Producer(ls);
        Thread producerThread = new Thread(p);
        producerThread.setName("PR");
        Thread consumer2 = new Thread(new Consumer(ls));
        consumer2.setName("C2");
        //producerThread.setDaemon(true);
        //consumerThread.setDaemon(true);
        //consumer2.setDaemon(true);
        consumerThread.start();
        producerThread.start();
        //Vector v = new Vector<>();
       // v.
        consumer2.start();
        producerThread.join();
        consumerThread.join();
        consumer2.join();
        System.out.println(ls.size());
    }
}
