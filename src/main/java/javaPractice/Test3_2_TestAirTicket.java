import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
3.2机票价格按照淡季旺季、头等舱和经济舱收费、
        输入机票原价、月份和头等舱或经济舱，
        其中旺季（5-10月）头等舱9折，经济舱85折，
        淡季（11月到来年4月）头等舱7折，经济舱65折，
        最终输出机票价格
*/
public class Test3_2_TestAirTicket {
    protected double airTicket(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您预定的机票价格：");
        String s1 = sc.next();
        System.out.println("请输入您的出行月份：");
        String s2 = sc.next();
        System.out.println("请输入您的舱位：");
        String s3 = sc.next();
        Pattern pa1 = Pattern.compile("^\\d+(\\.\\d+)?$");
        Matcher ma1 = pa1.matcher(s1);
        if(!ma1.find()){
            System.out.println("您输入的机票价格有误，请检查后重新输入!");
            return 0.0d;
        }
        Pattern pa2 = Pattern.compile("^(1(?:0|1|2))$|^(0?[1-9])$");
        Matcher ma2 = pa2.matcher(s2);
//        System.out.println(ma2.group(0));
        if(!ma2.find()){
            System.out.println("您输入的出行月份格式不正确，请检查后重新输入!");
            return 0.0d;
        }
        Pattern pa3 = Pattern.compile(".+");
        Matcher ma3 = pa3.matcher(s3);
//        || (s3 !="头等舱" || s3 !="经济舱")
        if(!ma3.find() || (!"头等舱".equals(s3)&&!"经济舱".equals(s3))){
            System.out.println("您输入的舱位不正确，请检查后重新输入!");
            return 0.0d;
        }
        double money = Double.valueOf(ma1.group(0));
        int month = Integer.valueOf(ma2.group(0));
        double disCount = 10;

        String ship = ma3.group(0);

        if("头等舱".equals(ship)){
            if(month >=5 && month <=10){
                disCount = 9;
            }else{
                disCount = 7;
            }
        }else{
            if(month >=5 && month <=10){
                disCount = 8.5;
            }else{
                disCount = 7.5;
            }
        }
        double disMoney = money *0.1* disCount;
        System.out.println("您的机票原价是："+money+"元，您的出行月份是："+ma2.group(0)+"月，您乘坐的是："+ship+"\n"
                            +"您的折扣优惠是："+disCount+"折\n"
                            +"折后价格是："+disMoney+"元");
        return  disMoney;
    }
}
