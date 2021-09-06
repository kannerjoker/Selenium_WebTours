package stringBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Test_StringBuilder {
    public static void main(String[] args) {
        StringBuilder strB_1 = new StringBuilder();
        strB_1.append(Calendar.getInstance().get(Calendar.YEAR));
        strB_1.append(Calendar.getInstance().get(Calendar.MONTH));

        strB_1.append(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+1);
        strB_1.append(" ");
        strB_1.append(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        strB_1.append(":");
        strB_1.append(Calendar.getInstance().get(Calendar.MINUTE));
        strB_1.append(":");
        strB_1.append(Calendar.getInstance().get(Calendar.SECOND));

        strB_1.insert(4,"-");
        strB_1.insert(7,"-");
        System.out.println(strB_1);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1994);
        c.set(Calendar.MONTH, 00);
        c.set(Calendar.DAY_OF_MONTH, 07);
        c.add(Calendar.HOUR_OF_DAY,-2);
        System.out.println(new StringBuilder().append(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)+" "
        +c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
        try {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
