package calendar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class DemoCalendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String[] s = c.toString().split(",");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Users\\kan\\Desktop\\Java_ Practice\\Java_Calendar.txt"));
            for (int i = 0; i < s.length; i++) {
                bw.write(s[i]+"\r\n");
//                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
