package javaLambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo_SupplierAndConsumer {
    public static void main(String[] args) {
        Integer num = 0;
        new Demo_SupplierAndConsumer().getConsumer((s)-> {
            s = s + 66;
            System.out.println(s);
        });

    }
    public Integer setSupplier(Supplier<Integer> supplier){
        return supplier.get();
    }
    public void getConsumer(Consumer<Integer> consumer){
        consumer.accept(new Demo_SupplierAndConsumer().setSupplier(()->5));
    }
}
