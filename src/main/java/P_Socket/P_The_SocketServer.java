package P_Socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P_The_SocketServer {
    public static void main(String[] args) throws Exception{
        System.out.println("Server is strating ...");
        ServerSocket ss = new ServerSocket(60060);
        Socket server = ss.accept();
        System.out.println("Server is strated ...");
        //接收请求并显示
        InputStream is = server.getInputStream();


        byte[] msg = new byte[1024];
        int len = is.read(msg);
        System.out.println(new String(msg,0,len));

        //返回数据
        OutputStream os = server.getOutputStream();
        os.write("200".getBytes());

    }
}
