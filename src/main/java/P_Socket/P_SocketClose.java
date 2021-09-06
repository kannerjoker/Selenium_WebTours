package P_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class P_SocketClose implements Runnable{
    static int clientFinished = 0;
    Socket client;
    OutputStream os;

    P_SocketClose(Socket client){
        this.client = client;
        try {
            this.os = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        synchronized(client){
            //client线程未执行完时,等待client线程执行
            if(this.clientFinished<2){
                try {
                    client.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //执行完成后,关闭socket
            try {
                os.write("Ready to close connection!".getBytes());
                /*int len;
                byte[] arrBytes = new byte[1024];
                InputStream is = client.getInputStream();
                len=is.read(arrBytes);
                System.out.println("Server: " + new String(arrBytes,0,len));
                is.close();*/
                os.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
