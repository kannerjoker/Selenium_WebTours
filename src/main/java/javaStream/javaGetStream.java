import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Stream;

public class javaGetStream {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList();
        Set<String> arrSet = new HashSet();
        Collection<String> arrCollection = new Vector();
        String[] arrString = new String[4];

        String s1 = "古力娜扎,18";
        String s2 = "欧阳娜娜,15";
        String s3 = "张三丰,85";
        String s4 = "古天乐,27";

        String[] arr = {s1,s2,s3,s4};

        arrList.add(s1);
        arrList.add(s2);
        arrList.add(s3);
        arrList.add(s4);
        arrSet.add(s1);
        arrSet.add(s2);
        arrSet.add(s3);
        arrSet.add(s4);
        arrCollection.add(s1);
        arrCollection.add(s2);
        arrCollection.add(s3);
        arrCollection.add(s4);
        arrString[0] = s1;
        arrString[1] = s2;
        arrString[2] = s3;
        arrString[3] = s4;

        System.out.println(arrList);
        System.out.println(arrSet);
        System.out.println(arrCollection);
        System.out.println(Arrays.toString(arrString));
        //创建流
        Stream<String> stream1 = arrList.stream();
        Stream<String> stream2 = arrSet.stream();
        Stream<String> stream3 = arrCollection.stream();
        Stream<String> stream4 = Stream.of(arrString);
        //forEach(Consumer consumer) 对每个流对象进行操作
        System.out.println("------------->");
        stream1.forEach((String str)->{
            System.out.println(str);
        });
        //System.out::println 打印流
        System.out.println("------------->");
        stream2.forEach(System.out::println);
        //filter(Predicate predicate) 筛选流
        System.out.println("------------->");
        stream3.filter((s)->s.startsWith("古")).forEach(System.out::println);
        //concat(Function function) 合并流
        System.out.println("------------->");
        Stream demo1 = Stream.of("1","2","3");
        Stream demo2 = Stream.of("a","b","c");
        Stream stream5 = Stream.concat(demo1,demo2);
        stream5.forEach(System.out::println);
        //map(Function function) 转换流数据类型
        System.out.println("------------->");
        Stream<String> stream6 = Stream.of("123","789","567");
//        stream6.map((String s)->Integer.valueOf(s)).forEach(System.out::println);
        stream6.map(DemoMap::new).forEach(System.out::println);
        //count();
        System.out.println("------------->");
        Stream stream7 = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream7.count());
        //limit(long num)
        System.out.println("------------->");
        Stream stream8 = Stream.of(1,2,3,4,5,6);
        stream8.limit(5).forEach(System.out::println);
        //skip(long num)
        System.out.println("------------->");
        Stream stream9 = Stream.of(1, 2, 3, 4, 5, 6);
        stream9.skip(3).forEach(System.out::println);

        System.out.println("------------->");
        Stream<String> stream10 = Stream.of(s1,s2,s3,s4);
        stream10.forEach((s)->{
            String str = s.split(",")[1];
            System.out.println(str);
        });

        System.out.println("=======================>");
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");

        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

        Stream<String> t1 = one.stream().filter((s)->s.length()==3).limit(3);
        Stream<String> t2 = two.stream().filter((s)->s.contains("张")).skip(2);
        Stream<String> concat = Stream.concat(t1, t2);
        concat.forEach(System.out::println);

        System.out.println("=======================>");
        Stream<String> streamNew = Stream.of(s1, s2, s3, s4);
//        streamNew.forEach(System.out::println);
        ArrayList<String> arrNew = new ArrayList();
        streamNew.forEach((s)->{
            String str = s.split(",")[1];
            Integer in= Integer.valueOf(str);
            arrNew.add(in+"");
            System.out.println(in);
        });
        System.out.println("arrNew: " + arrNew);

        arrNew.stream().map(Integer::valueOf).forEach((s)->System.out.println(s
        ));
    }
}
