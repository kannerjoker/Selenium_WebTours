package iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test_Iterator {
    public static void main(String[] args) {
        String[] arr = {"1","Alpha",null,"Marin","Jen"};
        Collection<String> coll = new ArrayList<String>(10);
        coll.add("Kang");
        coll.add("Mayken");
        coll.add("Sufei");

//        Iterator<String> it1 = arr.iterator();    错误写法，数组没有iterator()方法
        Iterator<String> it2 = coll.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        System.out.println("=========");
        for(String s:arr){
            System.out.println(s);
        }
        System.out.println("=========");
        for(String s:coll){
            System.out.println(s);
        }


    }
}
