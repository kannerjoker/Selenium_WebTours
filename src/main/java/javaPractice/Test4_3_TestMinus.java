import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//4.3循环输入5个数，输完后显示这些数中有没有负数
public class Test4_3_TestMinus {
    protected void getMinus(){
        long d1 = new Date().getTime();
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[5];
        Pattern pa = Pattern.compile("^(-)?\\d+(\\.\\d+)?$");
        System.out.println("请输入5个数字：");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.next();
            Matcher ma = pa.matcher(arr[i]);
            if(!ma.find()){
                System.out.println("您的第"+(i+1)+"个输入不是数字，请检查后重新输入！");
                i = i - 1;
            }
        }
        System.out.println("您输入的数组如下：");
        for(String s:arr){
            System.out.println(s);
        }
        for (int i = 0; i < 5; i++) {
            if(arr[i].contains("-")){
                System.out.println("您输入的数字中含有负数！");
                break;
            }
        }
        for (int i = 0; i < 5; i++) {
            if(arr[i].contains("-")){
                System.out.println(arr[i]);
            }
        }
        long d2 = new Date().getTime();
        System.out.println("耗时："+(d2-d1)+"毫秒");
    }
}
