package javaThread;

public class Lock_OnSale implements Runnable{
    int baozi = 64;
    boolean ready = true;
    public void run(){
        synchronized(this){
            if(!ready){
                System.out.println("加工中,还剩"+baozi+"个包子!");
                baozi++;
            }
            if(ready){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
