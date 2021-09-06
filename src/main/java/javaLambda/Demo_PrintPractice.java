package javaLambda;

import java.util.function.Consumer;

public class Demo_PrintPractice {
    static String[] arr = {"zhangsan,18", "lisi,20","wangwu,19"};
    public static void main(String[] args) {
        setParam(
                (s) -> System.out.println(s.split(",")[0]),
                (s)-> System.out.println(s.split(",")[1])
        );
    }
    public static void setParam(Consumer<String> con1,Consumer<String> con2){
        for (String s : arr) {
            con1.andThen(con2).accept(s);
        }
    }
}
