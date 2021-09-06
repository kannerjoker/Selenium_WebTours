import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Practice_TCP {
    public static void main(String[] args) {
        new Thread(() -> {new PracticeServer().startService();}).start();
        new Thread(() -> {new PracticeClient().startClient();}).start();
    }
}
class PracticeServer{
    public void startService(){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while(true){
                Socket server = serverSocket.accept();
                InputStream is  = server.getInputStream();

                int len;
                byte[] arrBytes = new byte[1024];
                System.out.println("server-<<");
                while((len=is.read(arrBytes))!=-1){
                    System.out.println(new String(arrBytes,0,len));
                }
                server.shutdownInput();

                OutputStream os = server.getOutputStream();
                os.write("服务端收到请求!".getBytes());
                is.close();
                os.close();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
class PracticeClient{
    public void startClient(){
        try {
            Socket client = new Socket("127.0.0.1", 8888);
            OutputStream os = client.getOutputStream();
            os.write("客户端请求服务端数据!".getBytes());
            client.shutdownOutput();

            InputStream is = client.getInputStream();
            int len;
            byte[] arrBytes = new byte[1024];
            System.out.println("client-<<");
            while((len=is.read(arrBytes))!=-1){
                System.out.println(new String(arrBytes,0,len));
            }
            os.close();
            is.close();
//            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}