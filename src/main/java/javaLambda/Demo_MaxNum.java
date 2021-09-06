package javaLambda;

import java.util.function.Supplier;

public class Demo_MaxNum {
    public static void main(String[] args) {
        Integer[] arr = {1,5,7,6,9,55,7,4};
//        1、创建接口实现类对象并重写虚拟方法
        Supplier<Integer> supplier = ()-> {
            Integer max = 0;
            for(Integer i:arr){
                if(max<i){
                    max = i;
                }
            }
            return max;
        };
//        2、调用方法
        System.out.println(supplier.get());
    }
}
