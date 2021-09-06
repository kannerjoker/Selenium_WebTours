import java.util.Scanner;
/*2.1商场消费返利活动，手动输入顾客消费金额，
    如果金额打8折后仍然满1000元，用户就获得200元代金券一张（不考虑多张）*/
public class Test2_1_TestRebate {
    protected int rebate(){
        System.out.println("请输入金额：");
        int money = new Scanner(System.in).nextInt();
        int coupon;
        String s;
        if(money * 0.8 >= 1000){
            s = "您符合打折条件，赠送200元代金券一张;";
        }else{
            s = "";
        }
        int dismoney;
        if(money * 0.8 >= 1000 ){
            coupon = 1;
            dismoney = money - 200 * coupon;
        }else{
            dismoney = money;
        }
        System.out.println(s + "应付" + money + "元，实付" + dismoney + "元"  );
        return money;
    }
}
