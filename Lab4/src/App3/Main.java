package App3;
public class Main
{
    public static void main(String[] args)
    {
        Integer monitor1 = new Integer(1);

        new ExecutionThread(monitor1,3, 4, 7 ).start();
        new ExecutionThread(monitor1, 6, 5, 7).start();
        new ExecutionThread(monitor1, 5, 3, 6).start();
    }

}
