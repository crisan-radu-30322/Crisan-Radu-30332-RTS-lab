

import java.util.concurrent.CountDownLatch;

public class FIr2 extends Thread{
    Object monitor1, monitor2;
    int activity_min, activity_max, sleep_min, sleep_max;
    CountDownLatch latch;
    public FIr2(Object monitor1, Object monitor2, int sleep_min, int sleep_max, int activity_min, int activity_max, CountDownLatch latch) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.latch = latch;
    }
    public void run() {
        System.out.println("thread 2" + " - STATE 1");

        synchronized (monitor1) {
            synchronized (monitor2) {
                try {
                    System.out.println("WAIT MONITOR1");
                    monitor1.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    System.out.println("WAIT MONITOR2");
                    monitor2.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            Thread.sleep(500 * Math.round(Math.random() * (sleep_max - sleep_min) + sleep_min));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("thread 2" + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k*100000; i++) {
            i++;
            i--;
        }

        System.out.println("thread 2" + " - STATE 3");

        System.out.println("thread 2" + " - STATE 4");

        latch.countDown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("thread 2" + " - STATE 5");
    }
}
