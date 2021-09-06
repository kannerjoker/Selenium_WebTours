import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_Practice {
    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(1);
        s.add('a');
        s.add("abc");
        Iterator it = s.iterator();
        int count = 0;
        while(it.hasNext()){
            System.out.println(count+"-------"+it.next());
            count++;
        }
        System.out.println("移除字符a"+s.remove('a'));
        Iterator it_1 = s.iterator();
        count = 0;
        while(it_1.hasNext()){
            System.out.println(count+"++++++++"+it_1.next());
            count++;
        }
        System.out.println("集合大小："+s.size());

    }
}
