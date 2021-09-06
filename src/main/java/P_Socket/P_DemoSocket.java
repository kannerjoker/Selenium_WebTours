package P_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
//一个socket总-分-总,服务端要么发要么收
public class P_DemoSocket {
    public static void main(String[] args) {
        try {
            //创建公共socket(作为锁使用)和传输流(client to server)
            Socket client = new Socket("10.130.212.111",60066);
            OutputStream os = client.getOutputStream();
            //多线程,2个client和1个监听线程(client执行完成后关闭socket)
            Runnable client2Impl = new P_SocketClient2(client);
            Thread client2 = new Thread(client2Impl);
            client2.start();

            Runnable client3Impl = new P_SocketClient3(client);
            Thread client3 = new Thread(client3Impl);
            client3.start();

            Runnable pCloseImpl = new P_SocketClose(client);
            Thread pClose = new Thread(pCloseImpl);
            pClose.start();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
