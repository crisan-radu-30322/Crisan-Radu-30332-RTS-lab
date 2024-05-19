package App2;

public class ExecutionThread extends Thread
{
    Integer monitor1, monitor2;
    int sleep, activity_min_1, activity_max_1, activity_min_2, activity_max_2;

    public ExecutionThread(Integer monitor1, Integer monitor2, int sleep, int activity_min_1, int activity_max_1,
                           int activity_min_2, int activity_max_2)
    {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep = sleep;
        this.activity_min_1 = activity_min_1;
        this.activity_max_1 = activity_max_1;
        this.activity_min_2 = activity_min_2;
        this.activity_max_2 = activity_max_2;
    }
    public void run()
    {
        System.out.println(this.getName() + " - STATE 1");

        int k = (int) Math.round(Math.random()*(activity_max_1 - activity_min_1) + activity_min_1);

        for (int i = 0; i < k * 100000; i++)
        {
            i++; i--;
        }

            synchronized (monitor1)
            {

                System.out.println(this.getName() + " - STATE 2");

                k = (int) Math.round(Math.random()*(activity_max_2 - activity_min_2) + activity_min_2);

                for (int i = 0; i < k * 100000; i++)
                {
                    i++;
                }

            }

            synchronized (monitor2)
            {
                System.out.println(this.getName() + " - STATE 3");

                try
                {
                    Thread.sleep(Math.round(Math.random() * (sleep * 500)));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }


        System.out.println(this.getName() + " - STATE 4");
    }
}
