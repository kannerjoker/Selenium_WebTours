package filewriter_practice;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriter_Basic {
    String s;
    public static void main(String[] args) {
        FileWriter_Basic file_Basic = new FileWriter_Basic();
        file_Basic.fileWriter();
        file_Basic.fileWriter_More();
        file_Basic.bufferedWriter();
        file_Basic.fileReader();
        System.out.println(">>>>>>>>>>>>>>>>>");
        file_Basic.bufferedReader();
    }

    void fileWriter(){
        String file_1 = "E:\\Users\\kan\\Desktop\\Java_ Practice\\FileWriter.txt";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");     //SimpleDateFormat()方法定义时间格式
        String s  = sdf.format(new Date());
        String s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String s2 = new SimpleDateFormat("今天是yyyy年M月d日，HH时m分s秒").format(new Date());

        try{
            FileWriter fw = new FileWriter(file_1);
            fw.write("FileWriter writer = new FileWriter(file)");
            fw.write("\n");       //换行

            fw.write(s+"\r\n"+s1+"\r\n");
            fw.write(s2);
            fw.close();                //文本写入之后，保存生效

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    void fileWriter_More(){
        String file_1 = "E:\\Users\\kan\\Desktop\\Java_ Practice\\FileWriter.txt";

        String s = "Hello World!1";

        try {
            FileWriter fw = new FileWriter(file_1,true);
            fw.write("\r\n");
            fw.write("=========================="+"\r\n"+s);
            fw.write("\r\n");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void bufferedWriter(){
        String file_2 = "E:\\Users\\kan\\Desktop\\Java_ Practice\\BufferedWriter.txt";

        String s = "hello world1";
        String s1 = "hello world2";
        try {
            BufferedWriter buffered = new BufferedWriter(new FileWriter(file_2));
            buffered.write(s);
            buffered.newLine();
            buffered.close();

            BufferedWriter buffered_1 = new BufferedWriter(new FileWriter(file_2,true));
            buffered_1.write("============="+"\r\n"+ s1);
            buffered_1.newLine();
            buffered_1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void fileReader(){
        String file_1 = "E:\\Users\\kan\\Desktop\\Java_ Practice\\FileWriter.txt";
        try {
            FileReader fr = new FileReader(file_1);
            int i;
            char c;
            do{
                i = fr.read();
                c = (char)i;
                System.out.print(c);
            }while(i > -1);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void bufferedReader(){
        String file_2 = "E:\\Users\\kan\\Desktop\\Java_ Practice\\BufferedWriter.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_2));
            String s = "";
            while(s != null){
                s = br.readLine();
                System.out.println(s);
            };
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
