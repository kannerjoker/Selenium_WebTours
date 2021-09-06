import javaThread.Demo;

public class MyThread extends Thread{
    int num = new Demo().num;
    public void run(){
//        synchronized("def"){
            for (int i = 0; i < 100; i++) {
//            System.out.println("run: " + i);
                if(i%2==0){
                    num--;
                }
                if(num>50&&i%2!=0){
                    System.out.println("MyThread:" + Thread.currentThread().getName()+"<---------->"+"i: " + i);
                    System.out.println("num: " + num);
                }
//            }
        }

    }
}
