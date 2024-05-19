package App3;

public class ExecutionThread extends Thread
{
    Integer monitor1;
    int sleep, activity_min, activity_max;

    public ExecutionThread(Integer monitor1, int sleep, int activity_min, int activity_max)
    {
        this.sleep = sleep;
        this.activity_max = activity_max;
        this.activity_min = activity_min;
        this.monitor1 = monitor1;
    }
    public void run() {

        while (true)
        {
            System.out.println(this.getName() + " - STATE 0");

            synchronized (monitor1)
            {

                System.out.println(this.getName() + " - STATE 1");

                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

                for (int i = 0; i < k * 100000; i++)
                {
                    i++;
                    i--;
                }

            }

            System.out.println(this.getName() + " - STATE 2");

            try
            {
                Thread.sleep(Math.round(Math.random() * (sleep * 500)));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " - STATE 3");

        }
    }
}