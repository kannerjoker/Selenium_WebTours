package P_Socket;

import java.io.*;
import java.net.Socket;

public class P_SocketClient3 implements Runnable{
    Socket client;
    OutputStream os;
    //监测client线程执行情况
    P_SocketClose pClose;
    P_SocketClient3(Socket client){
        try {
            this.client = client;
            os = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        synchronized(client){
            try {
                //客户端打开socket
                os.write("\r\n---------------Client3 is ready!-----------------\r\n".getBytes());

                //读取本地文件
                os.write("ADAS分类.txt.txt------------->>>\r\n".getBytes());
                BufferedInputStream br = new BufferedInputStream(new FileInputStream(new File("E:\\Users\\kan\\Desktop\\ADAS分类.txt")));
                byte[] arrBytes = new byte[8*1024];
                int len;
                while((len=br.read(arrBytes))!=-1){
                    os.write(arrBytes,0,len);
                }
                os.write("\r\n".getBytes());
                os.write("\r\n123 - 副本.txt------------->>>\r\n".getBytes());
                br = new BufferedInputStream(new FileInputStream("E:\\Users\\kan\\Desktop\\123 - 副本.txt"));
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