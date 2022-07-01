package it.accenture.multithreading.raceCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Program {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        Consumer c = new Consumer(ls);
        Thread consumerThread = new Thread(c);
        Producer p = new Producer(ls);
        Thread producerThread = new Thread(p);
        consumerThread.start();
        producerThread.start();
        //Vector v = new Vector<>();
       // v.
        Thread consumer2 = new Thread(new Consumer(ls));
        consumer2.start();
    }
}
