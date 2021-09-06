package javaLambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo_Comparator {
    public static void main(String[] args) {
        Integer[] arr = {1, 8, 2, 7, 3, 5, 55, 11, 42, 9};
        Integer[] arr1 = {1, 8, 2, 7, 3, 5, 55, 11, 42, 9};
        System.out.println(Arrays.toString(arr));
        //Arrays.sort(arr,Comparator内部类),只要提供一个接口对象并重写接口虚拟方法即可,lambda表达式
        Arrays.sort(arr,newComparator());
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr1,(x,y)->{return x-y;});
        System.out.println(Arrays.toString(arr1));
    }

    public static Comparator<Integer> newComparator(){

        /*return new Comparator(){
            @Override
            public int compare(Object x,Object y){
                return (int)x- (int)y;
            }
        };*/
        return (x,y) -> -x + y;
    }
}
