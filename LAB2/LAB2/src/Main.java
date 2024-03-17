public class Main {

    private static final int noOfThreads = 6;

    private static final int processorLoad = 1000000;

    public static void main(String args[]) {

        Window win = new Window(noOfThreads);

        for(int i = 0; i < noOfThreads; i++){
            Thread t = new Thread(new Fir(i, win, processorLoad));
            t.setPriority(i%10 + 1);
            t.start();
        }
    }
}