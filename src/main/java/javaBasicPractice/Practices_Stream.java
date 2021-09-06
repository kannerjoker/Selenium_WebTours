import com.google.common.collect.Table;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practices_Stream {
    public static void main(String[] args) {
        /*
        	练习一：Pedicate接口使用
            1.	请在测试类main方法中完成以下需求
            已知有Integer[] arr = {-12345, 9999, 520, 0,-38,-7758520,941213}
            a)	使用lambda表达式创建Predicate对象p1,p1能判断整数是否是自然数(大于等于0)
            b)	使用lambda表达式创建Predicate对象p2,p2能判断整数的绝对值是否大于100
            c)	使用lambda表达式创建Predicate对象p3,p3能判断整数是否是偶数

            2.	遍历arr，仅利用已创建的Predicate对象(不使用任何逻辑运算符)，完成以下需求
            i.	    打印自然数的个数
            ii.	    打印负整数的个数
            iii.	打印绝对值大于100的偶数的个数
            iv.	    打印是负整数或偶数的数的个数
        */
        System.out.println("----------------> P1");
        Integer[] arr = {-12345, 9999, 520, 0,-38,-7758520,941213};
        Predicate<Integer> p1 = (num) -> {
            return num >= 0;
        };
        Predicate<Integer> p2 = (Integer num) -> {
            return Math.abs(num) > 100;
        };
        Predicate<Integer> p3 = num -> num % 2 == 0;
        Stream<Integer> arrStream1 = Stream.of(arr);
        Stream<Integer> arrStream2_1 = Stream.of(arr);
        Stream<Integer> arrStream2_2 = Stream.of(arr);
        Stream<Integer> arrStream3 = Stream.of(arr);
        Stream<Integer> arrStream4 = Stream.of(arr);

        System.out.println(arrStream1.filter(p1).count());
        System.out.println(arrStream2_2.count() - arrStream2_1.filter(p1).count());
        System.out.println(arrStream3.filter(p3).count());
        arrStream4.filter(p1.negate().or(p3)).forEach(System.out::println);

        /*
        	练习二：Function接口使用
            1.	使用lambda表达式分别将以下功能封装到Function对象中
            a)	求Integer类型ArrayList中所有元素的平均数
            b)	将Map<String,Integer>中value存到ArrayList<Integer>中
            2.	已知学生成绩如下
            姓名	成绩
            岑小村	59
            谷天洛	82
            渣渣辉	98
            蓝小月	65
            皮几万	70
            3.	以学生姓名为key成绩为value创建集合并存储数据，使用刚刚创建的Function对象求学生的平均成绩
        */
        System.out.println("----------------> P2");
        ArrayList<String> arrStrs = new ArrayList<>();
        ArrayList<String> key = new ArrayList<>();
        ArrayList<Integer> value = new ArrayList<>();
        arrStrs.add("岑小村\t59");
        arrStrs.add("谷天洛\t82");
        arrStrs.add("渣渣辉\t98");
        arrStrs.add("蓝小月\t65");
        arrStrs.add("皮几万\t70");
        Function<String,String> function1 = str -> str.split("\t")[0];
        Function<String,Integer> function2 = str -> Integer.valueOf(str.split("\t")[1]);
        Stream<String> streamInt = arrStrs.stream();
        Stream<String> streamStr = arrStrs.stream();
        streamInt.map(function1).forEach((s)->{key.add(s);});
        streamStr.map(function2).forEach((s)->{value.add(s);});
        System.out.println(key);
        System.out.println(value);
        double sum = 0;
        for (Integer integer : value) {
            sum += integer;
        }

        System.out.println("average: " + sum/value.size());

        /*
        	练习三：如何获取流
                问题：
                简述单列集合、双列集合、数组分别如何获取Stream流对象，并进行演示

        */
        System.out.println("----------------> P3");
        List<String> arr1 = new ArrayList();
        arr1.add("a");
        arr1.add("b");
        arr1.add("c");
        Stream stream1 = arr1.stream();
        System.out.println("stream1: ");
        stream1.forEach((s)-> System.out.println(s));

        Map<String,Integer> arr2 = new HashMap();
        arr2.put("a", 1);
        arr2.put("b", 2);
        arr2.put("c", 3);
        Stream<String> stream2_Key = arr2.keySet().stream();
        Stream<Integer> stream2_Value = arr2.values().stream();
        Stream<Map.Entry<String,Integer>> stream2_Entry = arr2.entrySet().stream();
        System.out.println("stream2: ");
        stream2_Entry.forEach(System.out::println);

        String[] arr3 = {"1","2","3"};
        Stream<String> stream3 = Stream.of(arr3);
        System.out.println("stream3: ");
        stream3.forEach(System.out::println);

        /*
        	练习四：过滤：filter、结果收集(数组)
                问题：
                有如下7个元素黄药师，冯蘅，郭靖，黄蓉，郭芙，郭襄，郭破虏，使用Stream将以郭字开头的元素存入新数组
        */
        System.out.println("----------------> P4");
        String[] arr_P4 = {"黄药师","冯蘅","郭靖","黄蓉","郭芙","郭襄","郭破虏"};
        ArrayList<String> arr_P4New = new ArrayList<>();
        /*Stream.of(arr_P4).filter(s -> s.startsWith("郭")).forEach(arr_P4New::add);
        System.out.println(arr_P4New);*/
        String[] nameGuos =  Stream.of(arr_P4).filter(s -> s.startsWith("郭")).toArray(String[]::new);
        System.out.println(Arrays.toString(nameGuos));

         /*
        	练习五：取用前几个：limit、跳过前几个：skip
            问题：
            已知ArrayList集合中有如下元素{陈玄风、梅超风、陆乘风、曲灵风、武眠风、冯默风、罗玉风}，使用Stream
            1、取出前2个元素并在控制台打印输出。
            2、取出后2个元素并在控制台打印输出。

        */
        System.out.println("----------------> P5");
        String[] arr_P5 = {"陈玄风","梅超风","陆乘风","曲灵风","武眠风","冯默风","罗玉风"};
        Stream<String> stream_p5_1 = Stream.of(arr_P5);
        Stream<String> stream_p5_2 = Stream.of(arr_P5);
        System.out.println("limit: ");
        stream_p5_1.limit(2).forEach(System.out::println);
        System.out.println("skip: ");
        stream_p5_2.skip(arr_P5.length-2).forEach(System.out::println);

        /*
        	练习六：映射：map、逐一消费：forEach
            问题：
            有如下整数1，-2，-3，4，-5
            使用Stream取元素绝对值并打印

        */
        System.out.println("----------------> P6");
        Integer[] arr_P6 = {1,-2,-3,4,-5};
        Stream.of(arr_P6).map(Math::abs).forEach(System.out::println);

        /*
        	练习七：组合：concat、结果收集(list)
            问题：
            已知数组arr1中有如下元素{郭靖，杨康}，arr2中有如下元素{黄蓉，穆念慈}，使用Stream将二者合并到List集合
        */
        System.out.println("----------------> P7");
        String[] arr_P7_1 = {"郭靖", "杨康"};
        String[] arr_P7_2 = {"黄蓉","穆念慈"};
        List<String> list_p7 = Stream.concat(Stream.of(arr_P7_1), Stream.of(arr_P7_2)).collect(Collectors.toList());
        System.out.println(list_p7);

        /*
        	练习八：获取并发流
            问题：
            请分别写出获取并发流的两种方式。
        */
        System.out.println("----------------> P8");
        String[] arr_P8 = {"a","b","c","d"};
        List list_P8 = Arrays.asList(arr_P8);
        //由普通流升级为并发流:parallel()
        Stream<String> parallel_1 = Stream.of(arr_P8).parallel();
        //直接生成并发流:parallelStream()
        Stream<String> parallel_2 = list_P8.parallelStream();
    }
}
