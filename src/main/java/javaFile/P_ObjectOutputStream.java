package javaFile;

import javaFile.P_Object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class P_ObjectOutputStream {
    public static void main(String[] args) {
        P_Object p = new P_Object();
        p.name = "zhangsan";
        p.address = "dazhulin";
        p.age = 16;
        try {
            FileOutputStream fos = new FileOutputStream("E:\\Users\\kan\\Desktop\\Java_ Practice\\ObjectOutputStream.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            System.out.println("Serializable data is saved!");
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
