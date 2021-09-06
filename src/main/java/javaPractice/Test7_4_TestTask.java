import java.util.*;

/*7.4（选做）向一个长度为10的整型数组中随机生成10个0~9的随机整数，完成下列任务
        1)统计每个数字出现了多少次
        2)输出出现次数最多的数字
        3)输出只出现一次的数字中最小的数字*/
public class Test7_4_TestTask {
    protected void test(){
        Integer[] arr = new Integer[10];
        Random ra = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ra.nextInt(10);

        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("排序后： "+Arrays.toString(arr));
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        for(Integer i:set){
            System.out.println(i + ":" +count(arr, i));

        }
        System.out.println("\n------------输出出现次数最多的数字------------");
        Integer[] cou = new Integer[set.size()];
        Iterator<Integer> it = set.iterator();

        while(it.hasNext()){
            for(int i=0;i<set.size();i++){
                cou[i] = count(arr,it.next());
            }
        }
        Arrays.sort(cou);
        System.out.println("次数排序： " + Arrays.toString(cou));
        ArrayList<Integer> numMax = new ArrayList<>();
        for(Integer i:set){
            if(count(arr,i) ==  cou[cou.length-1]){
                numMax.add(i);
            }
        }
        System.out.println("出现最多的数字是：" + numMax + "，共出现了" + cou[cou.length-1] + "次");

        System.out.println("\n------------输出只出现一次的数字中最小的数字------------");
        ArrayList<Integer> numMin = new ArrayList<>();
        for(Integer i:set){
            if(count(arr,i) == 1){
                numMin.add(i);
            }
        }
        System.out.println(numMin.get(0));

    }

    static protected int count(Integer[] arr,int num){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                count++;
            }
        }

        return count;
    }
}
