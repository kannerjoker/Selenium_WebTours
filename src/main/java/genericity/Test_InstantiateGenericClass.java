package genericity;

public class Test_InstantiateGenericClass {
    public static void main(String[] args) {
        Test_GenericlClass tc = new Test_GenericlClass();
        tc.setAge(12);
        Object obj2 = tc.getAge();
        System.out.println(obj2);
        System.out.println("===============");
        //创建对象时使用泛型<Integer>限制
        Test_GenericlClass<Integer> tc_age = new Test_GenericlClass<>();
        tc_age.setAge(18);
        Integer inte = tc_age.getAge();
        System.out.println(inte);
        System.out.println("===============");
        //创建对象时使用泛型<String>限制
        Test_GenericlClass<String> tc_name = new Test_GenericlClass<String>();
        tc_name.setAge("abc");
        String s = tc_name.getAge();
        System.out.println(s);
        System.out.println("-----------------------");
        Test_GenericMethod tgm = new Test_GenericMethod();
        tgm.method_01(123);
        tgm.method_01("abc");
        tgm.method_01(true);
        System.out.println("===============");
        Test_GenericMethod.method_02(123);
        Test_GenericMethod.method_02("abc");
        Test_GenericMethod.method_02('c');
    }
}
