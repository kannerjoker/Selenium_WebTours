package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test_Collections {
    public static void main(String[] args) {
//        method_1(1,2,3,4,5);
//        method_2("String","a",1,true);
        method3();

    }

    static void method_1(int... arr){
        int sum = 0;
        for (int i : arr) {
            System.out.println(i);
            sum += i;
        }
        System.out.println(sum);
    }

    static void method_2(Object... obj){

    }

    static void method3(){
        Integer[] arr = {1,34,2,5,2,6,7,8};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }

}
class myCompare implements Comparator<Integer> {
    @Override
    public int compare(Integer a,Integer b){
        return a>b?-1:0;
    }

}
