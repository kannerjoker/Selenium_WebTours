public class ToString {
    int age;
    String name;
    //Alt+Insert组合按键打开Generate菜单（重写、封装）
    @Override
    public String toString() {
        return "ToString{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ToString ts = new ToString();
        System.out.println(ts.toString());
    }
}
