import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;

class Philosophers{
    public static void main(String[] args){

        
        final Semaphore [] forks = new Semaphore [] { new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)};
        ExecutorService dinnerTime = Executors.newFixedThreadPool(4);

        Philosopher[]  greats = new Philosopher[4];
        
        for(int i = 0; i < 4; i++) {
            greats[i]= new Philosopher(forks, i);
            dinnerTime.execute(greats[i]);
        }
    }
}