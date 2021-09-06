import org.testng.collections.Lists;

import java.util.*;

public class List_Practice {
    public static void main(String[] args) {
        List a = new ArrayList();
        List b = Lists.newArrayList();
        a.add(1);
        a.add('a');
        a.add("abc");

        b.add(100
        );
        b.add('A');
        b.add("ABC");
        Iterator it1 = a.iterator();
        Iterator it2 = b.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        int count = 0;
        for (int i = 0; i < a.size(); i++,count++) {
            System.out.println(count+"-----------"+a.get(i));
        }

        a.add(100);
//        a.add(5,200);
        a.add(11);
        a.remove(1);
        a.remove("abc");
        a.add(3,20);
        count = 0;
        for (int i = 0; i < a.size(); i++) {
            System.out.println(count+"++++++++++"+a.get(i));
        }
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(count+"-----------"+a.get(i));
        }
    }
}
