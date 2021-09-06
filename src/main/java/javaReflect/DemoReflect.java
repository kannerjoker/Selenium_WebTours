package javaReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DemoReflect {
    public static void main(String[] args) {
        new DemoReflect().testReflect();
    }
    public void testReflect(){
        try {
            Class c1 = Class.forName("Persons");
            System.out.println("c1：" + c1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<Persons> c2 = Persons.class;
        System.out.println("c2：" + c2);
        Class c3 = new Persons().getClass();
        System.out.println("c3：" + c3);

        //一、获取变量(Field)
        //获取所有public类型变量
        Field[] f1 =  c3.getFields();
        System.out.println(Arrays.toString(f1));
        //获取所有变量
        Field[] f2 = c3.getDeclaredFields();
        System.out.println(Arrays.toString(f2));
        try {
            //getField(String param)只能获取public类型
            Field f3 = c3.getField("name");
            //getDeclaredField(String param)可以获取所有类型
            Field f4 = c3.getDeclaredField("age");
            System.out.println(f3);
            System.out.println(f4);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        //二、获取构造方法(constructor)
        try {
            Constructor[] f5 = c3.getConstructors();
            System.out.println("f5:　" + Arrays.toString(f5));
            //  getConstructor(class<?> ...parameterTypes) 通过数据类型.class 来获取 对应数据类型的class
            Constructor f6 = c3.getConstructor(String.class,int.class,boolean.class);
            System.out.println("f6: " + f6);

            Constructor[] f7 = c3.getDeclaredConstructors();
            System.out.println("f7: " + Arrays.toString(f7));
            Constructor f8 = c3.getDeclaredConstructor(String.class,int.class,boolean.class);
            System.out.println("f8: " + f8);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //三、获取方法（Method）
        Method[] m1 = c3.getMethods();
        int count = 0;
        for (Method method : m1) {
            count++;
            System.out.println(count + ":" + method);
        }
        try {
            Method m2 = c3.getMethod("speak",String.class);
            System.out.println("m2: " + m2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
