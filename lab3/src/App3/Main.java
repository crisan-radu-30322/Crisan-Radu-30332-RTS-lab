package App3;

public class Main {

    public static double sum = 0;
    public static void main(String[] args)
    {

        JoinTestThread w1 = new JoinTestThread("1",null, 60000);
        JoinTestThread w2 = new JoinTestThread("2",w1, 20000);

        w1.start();
        w2.start();
    }
}
