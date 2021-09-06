package javaReflect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

public class ReflectPractice {
    public static void main(String[] args){
        //创建配置文件类
        Properties pro = new Properties();
        //通过类加载器获取配置文件输入流
        InputStream is = ReflectPractice.class.getResourceAsStream("pro.properties");
        try {
            //加载配置文件
            pro.load(is);
            //读取配置文件去加载类
            Class cls = Class.forName(pro.getProperty("className"));
            //实例一个对象
            /*
            一、newInstance()和new()区别：
            　　1、两者创建对象的方式不同，前者是实用类的加载机制，后者则是直接创建一个类：
            　　2、newInstance创建类是这个类必须已经加载过且已经连接，new创建类是则不需要这个类加载过(反射一般不直接new,降低耦合度)
            　　3、newInstance: 弱类型(GC是回收对象的限制条件很低，容易被回收)、低效率、只能调用无参构造，
                   new 强类型（GC不会自动回收，只有所有的指向对象的引用被移除是才会被回收，若对象生命周期已经结束，但引用没有被移除，经常会出现内存溢出）
            */
//            Object obj = cls.newInstance();           java9后不建议这么用
            Object obj = cls.getDeclaredConstructor().newInstance();
            Method m1 = cls.getDeclaredMethod(pro.getProperty("methodName_1"),String.class);
            Method m2 = cls.getDeclaredMethod(pro.getProperty("methodName_2"),int.class);
            //调用方法
            m1.invoke(obj,"zhangsan");
            m2.invoke(obj,18);


            //修改配置文件属性(临时修改),调用其他方法
            pro.setProperty("className_1","DemoReflect");
            pro.setProperty("methodName_3","testReflect");
            Class cls_1 = Class.forName(pro.getProperty("className_1"));
            Object obj_1 = cls_1.getDeclaredConstructor().newInstance();
            Method m3 = cls_1.getDeclaredMethod(pro.getProperty("methodName_3"));
            m3.invoke(obj_1);

            String resource = ReflectPractice.class.getClassLoader().getResource("pro.properties").toString().substring(6);
            PrintStream out = new PrintStream(resource);
            pro.list(out);
//            FileWriter fw = new FileWriter("E:\\Users\\kan\\Desktop\\截取123\\1.properties");
//            pro.store(fw,"The Properties are changed!");
//            fw.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
