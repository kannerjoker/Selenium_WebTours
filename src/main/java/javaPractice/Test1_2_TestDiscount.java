import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1_2_TestDiscount {
    protected double discount(String price){
        double disc = ((int)(new Random().nextDouble()*100))*0.01;
        Pattern pa = Pattern.compile("^(([0-9]|([1-9])\\d*)(\\.\\d*)?)$");
        Matcher ma = pa.matcher(price);
        double disPrice;
        if(ma.find()){
            System.out.println(ma.group());
            disPrice = Double.valueOf(price) * disc;
            System.out.println("您抽中了"+String.format("%.2f",10*disc)+"折"+
                    "，原价"+price+"元的商品，现价"+String.format("%.2f",disPrice)+"元");
        }else{
            System.out.println("您输入的价格格式有误，请重新输入！");
            disPrice = 0.0d;
        }

        return disPrice;
    }
}
