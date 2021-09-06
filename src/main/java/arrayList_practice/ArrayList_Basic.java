package arrayList_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
    1、ArrayList为长度可变的数组
    2、ArrayList<E>，其中<E>是可变泛型，将数组里面的数据限制为指定的“E”数据类型。注意：E只能为引用数据类型，不能为基本数据类型
    3、ArrayList<E>，若果E要用基本数据类型，需借助基本数据类型的包装类
    byte    Byte
    short   Short
    int     Integer[特殊]
    long    Long
    float   Float
    double  Double
    char    Character[特殊]
    boolean Boolean


*/
public class ArrayList_Basic {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("赵丽颖");
        arr.add("迪丽热巴");
        arr.add("古力娜扎");
        System.out.println(arr);
        System.out.println(arr.get(1));     //get(索引)   获取索引对应的值

        ArrayList<Integer> arr_1 = new ArrayList<Integer>();

        for (int i = 0; i < arr_1.size(); i++) {
            arr_1.add((new Random()).nextInt(100));
        }



    }
}
