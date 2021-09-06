//4.2打印出1-100之间所有不是7的倍数和不包含7的数字，并求和
public class Test4_2_TestSum {
    protected int getSum(){
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            String s = ""+i;
            if(i%7 != 0 &&(!s.contains("7"))){
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println(sum);
        return sum;
    }
}
