import java.util.ArrayList;
import java.util.Collections;

/*6.1求1~1000以内质数列表
        PS：质数是只能被1和自身整除的整数*/
public class Test6_1_TestPrime {
    protected static void prime(){
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int k = 0; k < 1000; k++) {
            arr.add(Integer.valueOf(k+1));
        }
        System.out.println(arr);
        for (Integer i = 1; i <= 1000; i++) {

            for (Integer j = 1; j <= 1000; j++) {
                /*
                * 排除公倍数：
                * 1、排除除数为1（公共特点，非特性）
                * 2、排除除数为自身（公共特点，非特性）
                * 3、排除不能整除
                * 4、排除比自身大的数
                * */
                //i%j
                /*if(i%j != 0 || i <= j || j==1 || i ==j){
                    continue;
                }
                if(!arr1.contains(Integer.valueOf(i))) {
                    arr1.add(Integer.valueOf(i));
                }
                if (arr.contains(Integer.valueOf(i))) {
                    arr.remove(Integer.valueOf(i));
                }*/
                //j%i
                /*if( i == 1 || i == j || j%i != 0 || i>=j ){
                    continue;
                }*/
                if(i == 1 || i == j || j%i != 0){
                    continue;
                }

                arr.remove(Integer.valueOf(j));
            }
        }
        System.out.println("arr"+arr);
    }
}
