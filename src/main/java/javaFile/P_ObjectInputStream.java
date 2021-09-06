package javaFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class P_ObjectInputStream {
    public static void main(String[] args) {
        P_Object p = null;
        try {
            FileInputStream fis = new FileInputStream("E:\\Users\\kan\\Desktop\\Java_ Practice\\ObjectOutputStream.txt");
            ObjectInputStream ois  = new ObjectInputStream(fis);
            //读出来的对象强制转换后给到现有变量
            p = (P_Object)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + p.name);
        System.out.println("address: " + p.address);
        //由于序列化的类age属性有transient修饰,表示该属性为瞬态的,不进行序列化
        System.out.println("age: " + p.age);
    }
}
