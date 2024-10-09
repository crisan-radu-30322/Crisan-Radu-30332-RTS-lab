package ColocviuGrupa1;

import java.util.concurrent.CountDownLatch;

public class Fir3 extends Thread {
    int activity_min, activity_max;
    CountDownLatch latch;
    public Fir3(int activity_min, int activity_max, CountDownLatch latch) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.latch = latch;
    }
    public void run() {
        System.out.println("thread 3" + " - STATE 1");

        System.out.println("thread 3" + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k*100000; i++) {
            i++;
            i--;
        }
        System.out.println("thread 3" + " - STATE 3");

        System.out.println("thread 3" + " - STATE 4");

        latch.countDown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("thread 3" + " - STATE 5");

    }
}

