

import java.util.concurrent.CountDownLatch;

public class Fir1 extends Thread{
    int activity_min, activity_max, sleep;
    Object monitor1, monitor2;
    CountDownLatch latch;
    public Fir1(Object monitor1, Object monitor2, CountDownLatch latch, int activity_min, int activity_max, int sleep) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.latch = latch;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
    }
    public void run() {
        System.out.println("thread 1" + " - STATE 1");

        System.out.println("thread 1" + " - STATE 2");

        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k*100000; i++) {
            i++;
            i--;
        }

        System.out.println("thread 1" + " - STATE 3");

        try {
            Thread.sleep(500 * sleep);
            synchronized (monitor1) {
                System.out.println("Notify for MONITOR 1");
                monitor1.notify();
            }
            synchronized (monitor2) {
                System.out.println("Notify for MONITOR 2");
                monitor2.notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("thread 1" + " - STATE 4");

        latch.countDown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("thread 1" + " - STATE 5");
    }
}
