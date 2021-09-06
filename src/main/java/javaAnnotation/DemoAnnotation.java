import javaAnnotation.*;

@SuppressWarnings("all")
public class DemoAnnotation extends Persons {
    public static void main(String[] args) {

    }
    @Override
    public void eat(){}
    @Deprecated
    public void walk(){}
    @MyAnnotation1(name = "123", age = 2,enumPerson = PersonM.p1,anno = @MyAnnotation2,arr3 = {"abc","def"})
    @MyAnnotation3
    public void handleMachines(){

    }


}
