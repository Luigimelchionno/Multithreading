package it.accenture.multithreading;

public class Program {
    public static void main(String[] args) {
        GoodNightThread t = new GoodNightThread();
        t.setPriority(Thread.MAX_PRIORITY);// dare priorità ad un thread.
        t.start();
        Thread t2 = new Thread(new GoodAfternoonRunnable());
        t2.start();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i <= 10000; i++) {
                System.out.println("hello lambda" + i);
            }
        });
        t3.start();

        try {
            Thread.sleep(500);
            //t.stop();//deprecato
            t.terminate();
            for (int i = 0; i <= 10000; i++) {
                System.out.println("hello world" + i);
                //Thread.yield();

                //Thread.sleep(1000);
            }

        }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


