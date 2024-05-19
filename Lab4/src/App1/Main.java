package App1;

public class Main
{
    public static void main(String[] args)
    {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(2);

        new ExecutionThread(monitor1, 4, 2, 4).start();
        new ExecutionThread(monitor1, monitor2, 3, 3, 6).start();
        new ExecutionThread(monitor2, 5, 2, 5).start();
    }

}
