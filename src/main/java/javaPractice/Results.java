/*
1变量、运算符和类型转换：
        1.1手动输入一个学生的成绩，对这个成绩进行一次加分，加当前成绩的20%，输出加分后成绩
        1.2商场举行店庆，抽几折打几折，
        先手动输入消费金额，再输入，抽到的折扣，计算出折后价格
        1.3手动输入一个4位数，求各位数字之和
2分支结构：
        2.1商场消费返利活动，手动输入顾客消费金额，
        如果金额打8折后仍然满1000元，用户就获得200元代金券一张（不考虑多张）
        2.2用户输入一个年份，如果是闰年输出是闰年
        （年份能被4整除，且不能被100整除，或者能被400整除的年份）
        2.3手动输入一个整型会员号，
        如果用户输入的是4位数字，
        输出登录成功，
        如果用户输入的不是4位数字,
        输出“您输入的会员号有误”
        2.4手动输入a，b，c三个变量的数值，
        要求通过数值交换，
        把输入的数值从小到大
        排序放入a,b,c中，并输出
3多分支结构
        3.1商场根据会员积分打折，
        2000分以内打9折，
        4000分以内打8折
        8000分以内打7.5折，
        8000分以上打7折，
        使用if-else-if结构，实现手动输入购物金额和积分，计算出应缴金额
        3.2机票价格按照淡季旺季、头等舱和经济舱收费、
        输入机票原价、月份和头等舱或经济舱，
        其中旺季（5-10月）头等舱9折，经济舱85折，
        淡季（11月到来年4月）头等舱7折，经济舱65折，
        最终输出机票价格
        3.3选择一个形状（1长方形、2正方形、3三角形、4圆形）
        根据不同的选择让用户输入不同的信息，
        长方形有长和宽、
        正方形有边长、
        三角形有底和高、
        圆形有半径，
        计算输出指定形状的面积
        3.4输入年份和月份，输出这个月应该有多少天（使用switch结构）
4循环结构（上）
        4.1随机生成一个1-100之间的数字num，循环让用户输入猜这个数，
        如果用户输入的数字大于num提示输入的数字比较大，
        如果用户输入的数字小于num提示输入的数字比较小，
        直到用户输入的数字和num相等为止，然后输出用户猜数的总次数
        4.2打印出1-100之间所有不是7的倍数和不包含7的数字，并求和
        4.3循环输入5个数，输完后显示这些数中有没有负数
5循环结构（下）
        5.1有一个有钱的神经病，他往银行里存钱，
        第一天存1元,以后每天比前一天多存50%，完成下列计算任务
        1)他存到第几天，当天存的钱会超过10元
        2)一个月（30天）后，他总共存了多少钱
        5.2有一个400米一圈的操场，一个人要跑10000米，
        第一圈50秒，其后每一圈都比前一圈慢1秒，
        按照这个规则计算跑完10000米需要多少秒
        5.3用户输入任意一个整数，求各位数字之和
6循环嵌套
        6.1求1~1000以内质数列表
        PS：质数是只能被1和自身整除的整数
7数组
        7.1定义一个数组int[] nums={8,7,3,9,5,4,1}
        输出数组中的最大值和最小值所在的下标
        7.2向一个长度为10的整型数组中随机生成10个0~9的随机整数，完成下列任务
        1)升序输出、降序输出
        2)输出总和、平均数
        7.3向一个长度为5的整型数组中随机生成5个1-10的随机整数
        要求生成的数字中没有重复数
        7.4（选做）向一个长度为10的整型数组中随机生成10个0~9的随机整数，完成下列任务
        1)统计每个数字出现了多少次
        2)输出出现次数最多的数字
        3)输出只出现一次的数字中最小的数字
*/

public class Results {
    public static void main(String[] args) {
        /*
        Test1_3_TestSum tSum = new Test1_3_TestSum();
        tSum.getSum();
        Test2_1_TestRebate tr = new Test2_1_TestRebate();
        tr.rebate();
        Test2_2_TestYear ty = new Test2_2_TestYear();
        ty.judgeYear();
        Test2_3_TestId ti = new Test2_3_TestId();
        ti.memberId();
        */
        /*Test1_1_TestScore ts = new Test1_1_TestScore();
        ts.plusScore();*/

       /* Test1_2_TestDiscount td = new Test1_2_TestDiscount();
        td.discount("123.0");*/

       /*Test2_4_TestSort tSort = new Test2_4_TestSort();
       tSort.testSort();*/

       /*Test3_1_TestIfElse tIf = new Test3_1_TestIfElse();
       tIf.MonDiscount();*/

        /*Test3_2_TestAirTicket tat = new Test3_2_TestAirTicket();
        tat.airTicket();*/

        /*TestPolygon tp = new TestPolygon();
        tp.getPolArea();*/

        /*Test3_4_TestCountDays tcd = new Test3_4_TestCountDays();
        tcd.countDays();*/

        /*Test4_1_TestGuessNum tgn = new Test4_1_TestGuessNum();
        tgn.guessNum();*/

       /*Test4_2_TestSum ts = new Test4_2_TestSum();
        ts.getSum();*/

       /*Test4_3_TestMinus tm = new Test4_3_TestMinus();
       tm.getMinus();*/

       /*Test5_1_TestDepositMoney tdm = new Test5_1_TestDepositMoney();
       tdm.depsositMoney();*/

       /*Test5_2_TestRun tr = new Test5_2_TestRun();
       tr.run();*/

       /*Test5_3_TestNumSum tns = new Test5_3_TestNumSum();
       tns.getNumSum();*/

        /*Test5_3_TestNumSum tns = new Test5_3_TestNumSum();
        tns.getNumSum();*/

        /*Test6_1_TestPrime tp = new Test6_1_TestPrime();
        Test6_1_TestPrime.prime();*/

        Test7_4_TestTask tt = new Test7_4_TestTask();
        tt.test();
    }
}
