package Appp1;

public class Main {
    private static boolean stopThreads = false;
    public static void main(String[] args){

        RThread reader = new RThread("messages.txt");
        WThread writer = new WThread("Msg");
        reader.start();
        writer.start();
    }
    public static boolean isStopThreads(){
        return stopThreads;
    }
}
