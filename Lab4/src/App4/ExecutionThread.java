package App4;

public class ExecutionThread extends Thread {
    Integer monitor1;
    int activity_min, activity_max;

    public ExecutionThread(Integer monitor1, int activity_min, int activity_max) {

        this.activity_max = activity_max;
        this.activity_min = activity_min;
        this.monitor1 = monitor1;
    }

    public void run() {

        System.out.println(this.getName() + " - STATE 0");

        synchronized (monitor1)
        {

            try {
                monitor1.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(this.getName() + " - STATE 1");

            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

            for (int i = 0; i < k * 100000; i++)
            {
                i++;
                i--;
            }

            System.out.println(this.getName() + " - STATE 2");

        }

    }
}