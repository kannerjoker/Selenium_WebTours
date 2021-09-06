package P_Socket.fileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class T_SocketServer {
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(60066);
            byte[] arrBytes = new byte[1024];
            System.out.println("服务器开始工作......");

            /*//获取客户端序列化后的文件,保存到本地
            Socket server_Object = serverSocket.accept();
            InputStream is_Object = server_Object.getInputStream();
            FileOutputStream fos_Object = new FileOutputStream("E:\\Users\\kan\\Desktop\\Java_ Practice\\SocketObject.txt");
            int len_Object;
            byte[] arrBytes_Object = new byte[1024];
            while((len_Object=is_Object.read(arrBytes_Object))!=-1){
                fos_Object.write(arrBytes_Object, 0, len_Object);
            }
            fos_Object.close();
            is_Object.close();
            //反序列化
            TheUploadFile tuf = null;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\Users\\kan\\Desktop\\Java_ Practice\\SocketObject.txt"));
            tuf = (TheUploadFile)ois.readObject();
            System.out.println(tuf.fileNames);
            ois.close();
            server_Object.close();*/

            while (true) {
                Socket server = serverSocket.accept();
                Thread.sleep(10);
                Date da = new Date();
                new Thread(()->{
                    try(BufferedInputStream bis = new BufferedInputStream(server.getInputStream());
                        FileOutputStream fos = new FileOutputStream("E:\\Users\\kan\\Desktop\\Java_ Practice\\" + da.getTime() + ".png");
                        BufferedOutputStream bw = new BufferedOutputStream(fos);
                    ) {
                        int len;
                        while((len = bis.read(arrBytes))!=-1){
                            bw.write(arrBytes,0,len);
//                          bw.write(arrBytes);         //复制文件时容易造成排版错乱,图片花色等问题
                        }
                        System.out.println("文件已保存!");
                        //返回状态
                        OutputStream os = server.getOutputStream();
                        os.write("200".getBytes());
                        os.close();

                        bw.close();
                        fos.close();
                        bis.close();
                        server.close();
//                    serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }


        }catch(IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
