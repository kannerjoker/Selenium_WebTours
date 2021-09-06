public class DemoMap {
    Integer integer;
    public DemoMap(String str){
        this.integer = Integer.valueOf(str);
    }
    @Override
    public String toString(){
        return "Integer:" + this.integer;
    }
}
