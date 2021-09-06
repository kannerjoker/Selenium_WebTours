package system;

import java.util.Arrays;
import java.util.Random;

public class Test_System {
    public static void main(String[] args) {
//        demo_currentTimeMillis();
        demo_arraycopy();
    }

    private static void demo_arraycopy() {
        int[] arr1 = new int[10];
        int[] arr2 = new int[20];
        long s = System.currentTimeMillis();
        Random r= new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = r.nextInt(10);
        }
        for (int j = 0; j < arr2.length; j++) {
            arr2[j] = r.nextInt(10)+10;
        }

        System.out.println("B_arr1:"+Arrays.toString(arr1));
        System.out.println("B_arr2:"+Arrays.toString(arr2));
        System.arraycopy(arr1,0,arr2,10,10);
        System.out.println("A_arr1:"+Arrays.toString(arr1));
        System.out.println("A_arr2:"+Arrays.toString(arr2));
        long e = System.currentTimeMillis();
        System.out.println("程序耗时："+(e - s)+" 毫秒");
    }

    private static void demo_currentTimeMillis() {
        long s = System.currentTimeMillis();
        int i = 0;
        while(i<9999){
            i += 1;
            System.out.println(i);
        }
        long e = System.currentTimeMillis();
        System.out.println("执行循环耗时：" + (e-s) + " 毫秒");
    }
}
