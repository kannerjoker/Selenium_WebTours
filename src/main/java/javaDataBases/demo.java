package javaDataBases;

import java.util.ArrayList;
import java.util.Properties;

public class demo {
    public static void main(String[] args) {
        Properties info = new Properties();
        info.setProperty("url","jdbc:mysql://10.130.212.160:3306/mysqlPractice");
        info.setProperty("Integer","123");
        System.out.println(info);
        System.out.println(info.getProperty("Integer"));

    }

}
