public interface Practice_Interface {
    public void showA();
    public default void showB(){
        System.out.println("method: showB");
    }
}

abstract class A{
    public abstract void specialB();
    public void read(){
        System.out.println("reading!");
    }
}


class B extends A implements Practice_Interface{
    @Override
    public void showA(){
        System.out.println("B override interface!");
    }
    public void specialB(){
        System.out.println("special!");
    }
}

class Test extends A{
    public static void main(String[] args) {
        Test t1 = new Test();
//        多态时,往往不知道接口或父类的实例对象是哪个,可以用instanceof 来区分,也可以通过"实例对象.getClass()"=="类.class()"来判断;
//        通过"a instanceof b"查看实例对象a是不是来源于b或其子类(接口的话为实例类的对象)
        A a1 = new Test();
        A a2 = new B();
        System.out.println("Test extends A? " + (t1 instanceof A));
        System.out.println("A extends B? " + (a1 instanceof B));
        System.out.println("A extends Test? " + (a2 instanceof Test));
//        通过getClass()查看实例对象来源于哪一个类
        System.out.println("Test == Test? " + (t1.getClass()==Test.class));
        System.out.println("Test == A? " + (a1.getClass()==A.class));
        System.out.println("B == Test? " + (a2.getClass()==Test.class));
        System.out.println("B == B? " + (a2.getClass()==B.class));

    }

    @Override
    public void specialB() {

    }
}
