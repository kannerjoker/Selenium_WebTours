import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//5.3用户输入任意一个整数，求各位数字之和
public class Test5_3_TestNumSum {
    protected void getNumSum(){
        System.out.println("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        String numS = sc.next();
        Pattern pa = Pattern.compile("^\\d+$");
        Matcher ma = pa.matcher(numS);
        if(!ma.find()){
            System.out.println("你输入的不是整数，请检查后重新输入！");
            return;
        }
        //通过toCharArray()将字符串转换为char[]数组    也可以通过new String(char[] c)将字符数组转换为字符串
        /*int length = numS.length();
        char[] getChar = numS.toCharArray();
        String[] str = new String[length];
        int[] arr = new int[length];
        for(int i=0;i<arr.length;i++){
            str[i] = getChar[i]+"";
            arr[i] = Integer.valueOf(str[i]);
            System.out.println(arr[i]);
        }*/
        //通过字符串的split()方法，将字符串拆分成String[] 数组
        /*String[] spl = numS.split("");
        for (String s:spl){
            System.out.println(s);
        }*/
        //通过循环取余数，求出各个数字    通过 “第i个数字的余数” - “第i+1个数字的余数” 求出i所对应的数字所代表的数值 k * 10^n
        //再对10^n取模求出i所对应的数字k
        /*long num = Long.valueOf(numS);
        int order;
        int orderNext;
        int mode = 0;
        int theNum = 0;
        int modeNext;
        int sum = 0;
        int[] arr = new int[numS.length()];
        for (int i = 1; i <= numS.length(); i++) {
            order = (int)Math.pow(10,i);
            orderNext = (int)Math.pow(10,i-1);
            mode = (int)num % (order);
            modeNext = mode % ((int)Math.pow(10,i-1));
            theNum = (mode - modeNext)/orderNext;
            arr[numS.length()-i] = theNum;
            System.out.println("");
            sum += theNum;
            System.out.println(sum);
        }*/
        int[] num= new int[numS.length()];
        int sum = 0;

        for (int i = 0; i < numS.length(); i++) {
            num[i] = Integer.valueOf(numS.substring(i,i+1));
            sum += num[i];
        }
        System.out.println(sum);
        //通过字符串截取，求出各个字符
    }
}
