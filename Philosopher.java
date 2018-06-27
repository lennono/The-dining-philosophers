import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Philosopher implements Runnable{
	private Semaphore [] forks;
	private int i;

	public Philosopher(Semaphore [] forks, int place){
		this.forks = forks;
		this.i = place; 
	}
	public void run(){
		while(true)
		{
			try { 	
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000 + 100)); // Thinking
				
				forks[i].acquire();
				forks[(i+1) % 5].acquire();

				System.out.println("Philosopher at seat " + i+" is eating");
				Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000 + 100)); // Eating

				forks[i].release();
				forks[(i+1) % 5].release();
			}catch (InterruptedException e){}

		}
	}
}