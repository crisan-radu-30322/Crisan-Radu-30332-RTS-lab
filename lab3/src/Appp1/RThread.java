package Appp1;

import java.io.*;
import java.util.Date;

public class RThread extends Thread{
    public static String fileName;
    BufferedReader in;

    public RThread(String fileName)
    {
        this.fileName = fileName;
    }

    public void run(){

        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (!Main.isStopThreads()){

            String readMsg = new String();

            try {

                    String iterator, last = "no message to read";

                    while((iterator = in.readLine()) != null)
                    {
                        last = new Date(System.currentTimeMillis()) + " - "
                                + iterator;
                    }

                    System.out.println(last);
                    Thread.sleep(3000);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
