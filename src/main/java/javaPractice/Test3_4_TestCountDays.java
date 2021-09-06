import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//3.4输入年份和月份，输出这个月应该有多少天（使用switch结构）
public class Test3_4_TestCountDays {
    protected int countDays(){
        int year;
        int month;
        int days = 0;
        boolean leapYear;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        String sYear = sc.next();
        System.out.println("请输入月份：");
        String sMonth = sc.next();
        Pattern paY = Pattern.compile("^\\d{1,4}$");
        Matcher maY = paY.matcher(sYear);
        if(maY.find()){
            year = Integer.valueOf(sYear);
        }else{
            year = -1;
            System.out.println("您输入的年份格式有误！");
            return -1;
        }
        Pattern paM = Pattern.compile("^\\d{1,2}$");
        Matcher maM = paM.matcher(sMonth);
        if(maM.find()&&Integer.valueOf(sMonth)>=1&&Integer.valueOf(sMonth)<=12){
            month = Integer.valueOf(sMonth);
        }else{
            month = -1;
            System.out.println("您输入的月份格式有误！");
            return -1;
        }
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            leapYear = true;
        }else{
            leapYear = false;
        }
        switch(month){
            case 1:
                days = 31;
                break;
            case 2:
                if(leapYear){
                    days = 29;
                }else{
                    days = 28;
                }
                break;
            case 3:
                days = 31;
                break;
            case 4:
                days = 30;
                break;
            case 5:
                days = 31;
                break;
            case 6:
                days = 30;
                break;
            case 7:
                days = 31;
                break;
            case 8:
                days = 31;
                break;
            case 9:
                days = 30;
                break;
            case 10:
                days = 31;
                break;
            case 11:
                days = 30;
                break;
            case 12:
                days = 31;
                break;
        }
        System.out.println(month+"月，有"+days+"天");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String str = year + "-" + month;
        Date d = null;
        try {
            d = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(sdf.format(d));
        System.out.println(d);
        return days;
    }
}
