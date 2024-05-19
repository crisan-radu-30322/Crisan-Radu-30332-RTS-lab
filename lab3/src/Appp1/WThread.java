package Appp1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class WThread extends Thread{
    PrintWriter out;
    String msg;

    public WThread(String msg)
    {
        this.msg = msg;
    }
    public void run(){

        try {
            out = new PrintWriter(new FileWriter(RThread.fileName, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(!Main.isStopThreads()){

            Date date = new Date(System.currentTimeMillis());
            out.println("Date: " + date);
            out.println("Message: " + msg);
            out.flush();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
