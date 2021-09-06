import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*2.3手动输入一个整型会员号，
        如果用户输入的是4位数字，
        输出登录成功，
        如果用户输入的不是4位数字,
        输出“您输入的会员号有误”*/
public class Test2_3_TestId {
    protected String memberId(){
        System.out.println("请输入您的会员ID：");
        String id = new Scanner(System.in).next();
        Pattern pa = Pattern.compile("^[0-9]{4}$");
        Matcher ma = pa.matcher(id);

        if(ma.find()){
            System.out.println("登录成功！");
        }else{
            System.out.println("您输入的会员号有误...");
        }
        return id;
    }
}
