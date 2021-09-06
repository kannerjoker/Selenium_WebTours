package javaFile;

import java.io.Serializable;

public class P_Object implements Serializable/*Serializable接口,标记接口,表示该类可以被序列化*/{
    String name;
    String address;
    transient int age;
    public void checkStream(){
        System.out.println("name:"+name+";address:"+address+";age:"+age);
    }
}


