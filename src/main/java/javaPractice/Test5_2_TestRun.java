/*5.2有一个400米一圈的操场，一个人要跑10000米，
        第一圈50秒，其后每一圈都比前一圈慢1秒，
        按照这个规则计算跑完10000米需要多少秒*/
public class Test5_2_TestRun {
    static int Odometer = 10000;
    static int time = 50;
    static int SumTime = 0;
    protected void run(){
        while(true){
            Odometer = Odometer - 400;
            SumTime += time;
            System.out.println("Odometer:"+Odometer+",SumTime:"+SumTime);
            if(Odometer == 0){
                System.out.println("跑完最后一圈需要"+time+"秒");
                System.out.println("跑完10000米需要"+SumTime+"秒");
                break;
            }
            time++;
        }
    }
}
