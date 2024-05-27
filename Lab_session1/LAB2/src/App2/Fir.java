package App2;

import java.util.Observable;

public class Fir extends Observable implements Runnable {
    int id;
    Window win;
    int processorLoad;

    ThreadInfo info = new ThreadInfo();

    Fir(int id,Window win, int procLoad){
        this.id=id;
        this.win=win;
        this.processorLoad=procLoad;
        addObserver(win);
        info.setC(0);
        info.setId(id);
    }

    public void run(){
        int c=0;
        while(c<1000){
            for(int j=0;j<this.processorLoad;j++){
                j++;j--;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            c++;
            info.setC(c);
            setChanged();
            notifyObservers(info);
        }
    }
}