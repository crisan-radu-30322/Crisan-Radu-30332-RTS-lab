package App4;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        Integer monitor1 = new Integer(1);

        ExecutionMonitorThread t1 = new ExecutionMonitorThread(monitor1,7, 2, 3 );
        ExecutionThread t2 = new ExecutionThread(monitor1,  3, 5);
        ExecutionThread t3 = new ExecutionThread(monitor1,  4, 6);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final STATE");

    }

}
