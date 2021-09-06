package javaLambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Random;
import java.util.function.Supplier;
import java.util.logging.Filter;

public class Demo_Supplier {
    public static void main(String[] args) {
        int num;
        byte[] bytes = new byte[100];
        for (int i = 0; i < 50; i++) {
            for (int len = 0; len < 100; len++) {
                num = new Random().nextInt(26)+65;
                bytes[len] = Integer.valueOf(num).byteValue();
            }
            System.out.println("---------------->"+i);
            String str =  new Demo_Supplier().getStringParam(() -> new String(bytes));
            System.out.println(str);
        }
    }

    public String getStringParam(Supplier<String> supplier){
        return supplier.get();
    }
}
