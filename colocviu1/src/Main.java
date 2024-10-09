import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String args[]) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(2);
        Semaphore semaphore = new Semaphore(3);
        Integer monitor1 = new Integer(1);
        Fir1 f1 = new Fir1(barrier, monitor1, 2, 4);
        Fir2 f2 = new Fir2(barrier, semaphore, monitor1, 3, 6, 8);
        Fir2 f3 = new Fir2(barrier, semaphore, null, 4, 7, 0);

        f1.start();
        f2.start();
        f3.start();
    }
}


class Fir1 extends Thread{
    int activityMin, activityMax;

    CyclicBarrier barrier;
    Integer monitor1;

    public Fir1(CyclicBarrier barrier, Integer monitor1, int activityMin, int activityMax){
        this.barrier =barrier;
        this.activityMin=activityMin;
        this.activityMax=activityMax;

        this.monitor1 = monitor1;
    }

    public void run() {

        while(true) {
            System.out.println(this.getName() + " State 1");

            System.out.println(this.getName() + " State 2");
            int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }

            System.out.println(this.getName() + " State 3");

            synchronized (monitor1) {
                monitor1.notify();
            }

                System.out.println(this.getName() + " State 4");

                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

class Fir2 extends Thread {
    Semaphore semaphore;

    int activityMin, activityMax, sleepVal;

    CyclicBarrier barrier;
    Integer monitor1;

    public Fir2(CyclicBarrier barrier,Semaphore semaphore, Integer monitor1, int activityMin, int activityMax, int sleepVal){
        this.barrier =barrier;
        this.semaphore=semaphore;
        this.activityMin=activityMin;
        this.activityMax=activityMax;
        this.sleepVal=sleepVal;
        this.monitor1 = monitor1;
    }

    public void run() {

        while (true) {
            System.out.println(this.getName() + " - STATE 1");

            try {
                this.semaphore.acquire(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (monitor1) {

                try {
                    monitor1.wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
                try {
                    Thread.sleep(500 * sleepVal);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            System.out.println(this.getName() + " - STATE 2");

            int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);

            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }

            this.semaphore.release(2);

            System.out.println(this.getName() + " - STATE 3");

            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

        }
    }

}


