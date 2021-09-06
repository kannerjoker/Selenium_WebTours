import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UnixTime {
    public static void main(String[] args) {
        String t1 = "1970-01-01 08:00:01";
        String t2 = "2021/1/22 9:52:02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d H:mm:ss");
        try {
            Date time = sdf.parse(t2);
            System.out.println(time);
            System.out.println(time.getTime()/1000);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
