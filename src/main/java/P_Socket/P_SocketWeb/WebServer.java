package P_Socket.P_SocketWeb;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class WebServer {
    public static void main(String[] args) {
        int count = 0;
        try
        {
            ServerSocket server = new ServerSocket(60066);
            while(true) {
                //一个页面包括多个元素,需要多次通信
                Socket socket = server.accept();
                //多线程处理每个元素
                new Thread(()->{
                    try {
                        InputStream is = socket.getInputStream();
                        BufferedInputStream bis = new BufferedInputStream(is);
                        byte[] arrBytes = new byte[1024];
                        int len = bis.read(arrBytes);
                        String[] strs = new String(arrBytes, 0, len).split(" ");
                        System.out.println(Arrays.toString(strs));
                        String url = strs[1].substring("/Selenium_WebTours/".length());
                        System.out.println(url);
                        socket.shutdownInput();
                        FileInputStream fis = new FileInputStream(url);
//            D:\IdeaProjects\Selenium_WebTours\web\index.html
//            Selenium_WebTours\web\index.html (系统找不到指定的路径。)
                        OutputStream os = socket.getOutputStream();
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        //注意换行
                        os.write("\r\n".getBytes());
                        while((len=fis.read(arrBytes))!=-1){
                            os.write(arrBytes,0,len);
                        }
                        os.close();
                        is.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

            }
//            server.close();

        }catch(Exception e){
            count++;
            e.printStackTrace();
            System.out.println("----------------------------------->>> " +  count);
        }
    }

}
