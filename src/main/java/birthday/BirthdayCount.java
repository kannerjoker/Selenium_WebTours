package birthday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BirthdayCount {
    public static void main(String[] args) {
        System.out.println("你出生了 " + count(getCurrentTime(), getBirthTime()) + " 天");
    }

    private static long count(long getCurrentTime,long getBirthTime) {
        long day = 0;
        day = getCurrentTime - getBirthTime;
        return day/1000/3600/24;
    }

    private static long getCurrentTime() {
        long currentTime = new Date().getTime();
        return currentTime;
    }

    private static long getBirthTime() {
        System.out.println("请输入出生日期 yyyy-MM-dd");
        String birth = new Scanner(System.in).next();
        long birthTime = 0L;
        try {
            birthTime = new SimpleDateFormat("yyyy-MM-dd").parse(birth).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return birthTime;
    }
}
