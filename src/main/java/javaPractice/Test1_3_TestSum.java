import java.util.Scanner;

//1.3手动输入一个4位数，求各位数字之和
public class Test1_3_TestSum {
    protected int getSum(){
        System.out.println("请输入一个四位整数：");
        int num = new Scanner(System.in).nextInt();
        if(num <= 999 || num >= 9999){
            System.out.println("你输入的数字不在范围之内，请重新输入！");
            return 0;
        }
        int a = num % 10;
        int b = (num % 100 - a)/10;
        int c = (num % 1000 - b - a)/100;
        int d = (num % 10000 - b - a)/1000;
        int sum = a + b + c + d;
        System.out.println("个位数是："+a);
        System.out.println("十位数是："+b);
        System.out.println("百位数是："+c);
        System.out.println("千位数是："+d);
        System.out.println("求和："+sum);
        return sum;
    }
}
