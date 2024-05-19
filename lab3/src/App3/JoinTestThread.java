package App3;

import App3.Main;
class JoinTestThread extends Thread
{
    Thread t;
    String n;

    double k;
    JoinTestThread(String n, Thread t, double k)
    {
        this.setName(n);
        this.t = t;
        this.n = n;
        this.k = k;
    }
    public void run() {
        System.out.println("Thread "+ n +" has entered the run() method");
        try {
            if (t != null) t.join();

            this.k = this.divisors(this.k);
            System.out.println(this.k);

            if(Main.sum == 0) Main.sum = this.k;

            else
                Main.sum = Main.sum + this.k;

            System.out.println("Thread "+ n +" has terminated operation.");

            System.out.println(Main.sum);
        }
        catch(Exception e){e.printStackTrace();}
    }

    public int divisors(double n)
    {
        int sum = 0;

        for (int i = 1; i <= n; ++i)
            sum += (n / i) * i;
        return sum;
    }
}
