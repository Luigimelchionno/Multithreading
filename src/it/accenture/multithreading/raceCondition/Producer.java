package it.accenture.multithreading.raceCondition;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
    private Random r = new Random();
    private List<String> data;

    public Producer(List data){
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int seconds = r.nextInt(6);
            try {
                TimeUnit.SECONDS.sleep(seconds);
                synchronized (data){
                  data.add("Pippo");
                  System.out.println("producer aggiunto pippo");
                  data.notifyAll();
                  System.out.println("producer notify all");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
