import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2.4手动输入a，b，c三个变量的数值，
        要求通过数值交换，
        把输入的数值从小到大
        排序放入a,b,c中，并输出*/
public class Test2_4_TestSort {
    protected void testSort(){
        System.out.println("请输入3个数字：");
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[3];

        System.out.println("第一个数：");
        arr[0] = sc.next();
        System.out.println("第二个数：");
        arr[1] = sc.next();
        System.out.println("第三个数：");
        arr[2] = sc.next();

        Pattern pa = Pattern.compile("^\\d+$");
        for (int i = 0; i < arr.length; i++) {
            Matcher ma = pa.matcher(arr[i]);
            if(!ma.find()){
                System.out.println("你输入的有非数字，请检查后重新输入！");
                return;
            }
        }

        int a = Integer.valueOf(arr[0]);
        int b = Integer.valueOf(arr[1]);
        int c = Integer.valueOf(arr[2]);
        boolean boo = true;
        while(boo){
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            if(a > c){
                int temp = a;
                a = c;
                c = temp;
            }
            if(b > c){
                int temp = b;
                b = c;
                c = temp;
            }
            if(a <= b && b <= c){
                boo = false;
            }
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }
}
