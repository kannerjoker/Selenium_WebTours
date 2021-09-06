package javaThread;

public class Lock_Customer implements Runnable{
    int baozi = 64;
    boolean ready = true;
    public void run(){
        synchronized(this){
            if(ready){
                System.out.println("开吃中,还剩"+baozi+"个包子!");
                baozi--;
            }
            if(baozi<8){
                ready=false;
                this.notify();
            }
        }

    }

}
