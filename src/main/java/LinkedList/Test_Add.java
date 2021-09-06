package LinkedList;

import java.util.LinkedList;

public class Test_Add {
    public static void main(String[] args) {
        LinkedList ll_01 = new LinkedList();
        ll_01.add("a");
        ll_01.add("b");
        ll_01.add("c");
        ll_01.add("d");
        test_addFirst(ll_01,"1");
        test_addLast(ll_01,"9");
        test_pop();
        test_push();
        test_set();
    }

    private static void test_set() {

    }

    private static void test_push() {

    }

    private static void test_pop() {

    }

    private static void test_addLast(LinkedList ll,String s) {
        ll.addLast(s);
    }

    private static void test_addFirst(LinkedList ll,String s) {
        ll.addFirst(s);
    }
}
