package it.accenture.multithreading.Deadlock;

public class DeadlockExample {
    public static void main(String[] args) {
        ResourceOne r = new ResourceOne();
        Thread t1 = new Thread(() -> r.m1());
        Thread t2 = new Thread(() -> r.m2());
        t1.start();
        t2.start();
    }
}
