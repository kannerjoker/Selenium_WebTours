package javaLambda;

import java.util.function.Consumer;

public class Demo_AndThen {
    public static void main(String[] args) {
        consumeString(
                (s1)->{
                    System.out.println(s1.toLowerCase());
                },
                (s2)->{
                    System.out.println(s2.toUpperCase());
                });
    }
    public static void consumeString(Consumer<String> con1,Consumer<String> con2){
        con1.andThen(con2).accept("hello world!");
    }
}
