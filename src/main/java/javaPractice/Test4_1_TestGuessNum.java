import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*4.1随机生成一个1-100之间的数字num，循环让用户输入猜这个数，
        如果用户输入的数字大于num提示输入的数字比较大，
        如果用户输入的数字小于num提示输入的数字比较小，
        直到用户输入的数字和num相等为止，然后输出用户猜数的总次数*/
public class Test4_1_TestGuessNum {
    protected int guessNum(){
        int num = new Random().nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int guessNum = 0;
        Pattern pa = Pattern.compile("^\\d{1,3}$");
        while(true){
            System.out.println("请输入您猜的数字：");
            String guessNumS = sc.next();
            Matcher ma = pa.matcher(guessNumS);

            if(ma.find()){
                guessNum = Integer.valueOf(guessNumS);
            }

            if(guessNum > 100 || guessNum <1){
                System.out.println("您输入的数字不在区间范围内，请检查后重新输入！");
                count = -1;
                return count;
            }
            count ++;
            if(guessNum == num){
                break;
            }else if(guessNum > num){
                System.out.println("您猜的数字比神秘数字大！");
            }else if(guessNum < num){
                System.out.println("您猜的数字比神秘数字小！");
            }
        }
        if(count >= 1 ){
            System.out.println("神秘数字是："+ num + "，您猜对了！");
            System.out.println("您一共猜了" + count +"次");
        }
        return count;
    }
}
