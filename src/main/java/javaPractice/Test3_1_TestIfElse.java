import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*3.1商场根据会员积分打折，
        2000分以内打9折，
        4000分以内打8折
        8000分以内打7.5折，
        8000分以上打7折，
        使用if-else-if结构，实现手动输入购物金额和积分，计算出应缴金额*/
public class Test3_1_TestIfElse {
    protected double MonDiscount() {
        System.out.println("你的商品价格是：");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        System.out.println("你的会员积分是：");
        String s2 = sc.next();

        Pattern pa1 = Pattern.compile("^\\d+(\\.\\d+)?$");
        Matcher ma1 = pa1.matcher(s1);

        Pattern pa2 = Pattern.compile("^\\d+$");
        Matcher ma2 = pa2.matcher(s2);

        if(!ma1.find()){
            System.out.println("您输入的商品价格有误，请检查后重新输入！");
            return 0;
        }
        if(!ma2.find()){
            System.out.println("您输入的会员积分有误，请检查后重新输入！");
            return 0;
        }
        System.out.println("匹配项是："+"\n"+
                            "价格: "+ma1.group()+" ,积分: "+ma2.group());
        double money = Double.valueOf(s1);
        int count = Integer.valueOf(s2);
        double discount = 0;
        if(count <=2000){
            discount = 9;
        }else if(count <=4000){
            discount = 8;
        }else if(count <= 8000){
            discount = 7.5;
        }else{
            discount = 7;
        }

        double dismoney = money *0.1* discount;
        System.out.println("您的商品原价是：" + String.format("%.2f", money) + "元，您的会员积分是：" + count +
                            "分,\n享受"+discount+"折优惠，\n打折后的价格是：" + String.format("%.2f", dismoney) + "元");
        return dismoney;
    }
}
