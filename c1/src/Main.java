package ColocviuGrupa1;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        Object monitor1 = new Object();
        Object monitor2 = new Object();
        CountDownLatch latch = new CountDownLatch(3);
        Fir1 thread1 = new Fir1(monitor1, monitor2, latch, 3, 5, 2);
        FIr2 thread2 = new FIr2(monitor1, monitor2, 4,6,5,7, latch);
        Fir3 thread3 = new Fir3(7,9,latch);

        thread2.start();
        thread3.start();
        thread1.start();
    }


}
