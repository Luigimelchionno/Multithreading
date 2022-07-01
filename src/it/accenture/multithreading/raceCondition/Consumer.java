package it.accenture.multithreading.raceCondition;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
    private Random r = new Random();
    private List<String> data;

    public Consumer(List data){
        this.data = data;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int n = 0;
        while(n < 10) {
            int seconds = r.nextInt(6);
            try {
                TimeUnit.SECONDS.sleep(seconds);
                synchronized (data) { //proteggiamo l arraylist
                    while(data.isEmpty()) {
                        System.out.println(name + ":Entering wait");
                        data.wait();
                        System.out.println(name + ":Exiting wait");
                    }
                    String s = data.remove(0);
                    System.out.println(s);
                    n++;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
