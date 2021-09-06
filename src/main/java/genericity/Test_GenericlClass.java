package genericity;

public class Test_GenericlClass<E> {
    private E age;
    private E name;
    public void setAge(E age){
        this.age = age;
    }
    public E getAge(){
        return this.age;
    }
    public void setName(E name){
        this.name = name;
    }
    public E getName(){
        return this.name;
    }
}
