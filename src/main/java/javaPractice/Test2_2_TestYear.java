import java.util.Scanner;

/*2.2用户输入一个年份，如果是闰年输出是闰年
    （年份能被4整除，且不能被100整除，或者能被400整除的年份）*/
public class Test2_2_TestYear {
    protected int judgeYear(){
        String judgement;
        System.out.println("请输入年份：");
        int year = new Scanner(System.in).nextInt();
        if((year % 4 == 0) && (year % 100 !=0) || (year % 400 == 0)){
            judgement = year + "年是闰年";
        }else{
            judgement = year + "年是平年";
        }
        System.out.println(judgement);
        return year;
    }
}
