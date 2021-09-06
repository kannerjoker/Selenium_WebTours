package genericity;
public class Test_GenericMethod {
    public <A> A method_01(A var1){
        return var1;
    }
    public static <B> void method_02(B var2){
        System.out.println(var2);
    }

}
