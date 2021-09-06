import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//1.1手动输入一个学生的成绩，对这个成绩进行一次加分，加当前成绩的20%，输出加分后成绩
public class Test1_1_TestScore {
    protected double plusScore(){
        System.out.println("请输入要加分的成绩: ");
        String score = new Scanner(System.in).next();
        Pattern pa = Pattern.compile("^(100|((0|[1-9]\\d?))(\\.\\d*)?)$");
        Matcher ma = pa.matcher(score);
        double num;
        double d = 0.0;
        if(ma.find()){
            num = Double.valueOf(score);
            System.out.println("加分前的成绩是:" + num);
            d = ((int) (num * (1 + 0.2) * 100)) / 100.00;
            System.out.println("加分后的成绩是: " + d);
            System.out.println(ma.start());
            System.out.println(ma.group());
        }else{
            System.out.println("您输入的成绩格式有误，请重新输入！");

        }

        return d;
    }
}
