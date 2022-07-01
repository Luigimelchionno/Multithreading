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
        int seconds = r.nextInt(6);
        try {
            TimeUnit.SECONDS.sleep(seconds);
            if(!data.isEmpty()){
               String s = data.remove(0);
                System.out.println(s);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
