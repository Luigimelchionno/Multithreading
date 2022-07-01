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
        int seconds = r.nextInt(6);
        try {
            TimeUnit.SECONDS.sleep(seconds);
            data.add("Pippo");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
