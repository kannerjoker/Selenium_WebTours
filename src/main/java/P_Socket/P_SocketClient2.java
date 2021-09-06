package P_Socket;

import java.io.*;
import java.net.Socket;

public class P_SocketClient2 implements Runnable{
    Socket client;
    OutputStream os;
    //监测client线程执行情况
    P_SocketClose pClose;
    P_SocketClient2(Socket client){
        try {
            this.client = client;
            os = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        //以公共socket->client为锁
        synchronized(client){
            try {
                //客户端打开socket
                os.write("\r\n---------------Client2 is ready!---------------\r\n".getBytes());

                //读取本地文件
                os.write("selenium自动化.txt------------->>>\r\n".getBytes());
                BufferedInputStream br = new BufferedInputStream(new FileInputStream(new File("E:\\Users\\kan\\Desktop\\selenium自动化.txt")));
                byte[] arrBytes = new byte[8*1024];
                int len;
                while((len=br.read(arrBytes))!=-1){
                    os.write(arrBytes,0,len);
                }
                os.write("\r\n".getBytes());
                os.write("\r\n自动化测试工具调研.txt------------->>>\r\n".getBytes());
                br = new BufferedInputStream(new FileInputStream("E:\\Users\\kan\\Desktop\\自动化测试工具调研.txt"));
                while((len=br.read(arrBytes))!=-1){
                    os.write(arrBytes,0,len);
                }
                os.write("\r\n".getBytes());

                pClose.clientFinished++;
                client.notify();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
