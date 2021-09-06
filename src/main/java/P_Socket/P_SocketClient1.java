package P_Socket;

import java.io.*;
import java.net.Socket;

public class P_SocketClient1 {
    public static void main(String[] args){
        System.out.println("客户端启动,准备发送数据.....");
        try {
            Socket socket = new Socket("10.130.212.111",60066);
            OutputStream os = socket.getOutputStream();
            os.write("Socket传输数据!\r\n".getBytes());

            os.write("字节流传输:\r\n".getBytes());
            FileInputStream fis = new FileInputStream("E:\\Users\\kan\\Desktop\\Java_ Practice\\方法修饰符.txt");
            int len;
            byte[] arrBytes = new byte[1024];
            while((len=fis.read(arrBytes))!=-1){
                os.write(arrBytes,0,len);
            }


            os.write("----------------------->>>>>>>>>>>>\r\n".getBytes());
            //来回转换,有乱码缺失等问题,不推荐
            os.write("字符流传输:\r\n".getBytes());
            FileReader fr = new FileReader("E:\\Users\\kan\\Desktop\\Java_ Practice\\方法修饰符.txt");
            int lenReader;
            char[] arrChars = new char[8*1024];
            while((lenReader=fr.read(arrChars))!=-1){
                os.write(new String(arrChars,0,lenReader).getBytes());
            }
            fis.close();
            fr.close();

            InputStream is = socket.getInputStream();
            int len1;
            byte[] arrBytes1 = new byte[100];
            while((len1=is.read(arrBytes1))!=-1){
                System.out.println("client3: " + new String(arrBytes1,0,len1));

            }
            is.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
