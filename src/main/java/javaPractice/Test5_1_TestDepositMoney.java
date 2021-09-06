/*5.1有一个有钱的神经病，他往银行里存钱，
        第一天存1元,以后每天比前一天多存50%，完成下列计算任务
        1)他存到第几天，当天存的钱会超过10元
        2)一个月（30天）后，他总共存了多少钱*/
public class Test5_1_TestDepositMoney {
    static double money = 1;
    protected void depsositMoney(){
        int count = 1;
        while(true){
            count++;
            money = money * (1+0.5);
            if(money > 10 ){
                System.out.println("第"+count+"天时，存款超过10元,共存了"+String.format("%.2f",money)+"元" );
                break;
            }
        }
        money = 1;
        while(true){
            count++;
            money = money * (1+0.5);
            if(count == 30 ){
                System.out.println(count+"天后，共存了"+String.format("%.2f",money)+"元" );
                break;
            }
        }
    }
}
