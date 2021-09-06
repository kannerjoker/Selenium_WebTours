package javaReflect;

public class Persons {
    public String name;
    int age;
    boolean sexM;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setSexM(boolean sexM){
        this.sexM = sexM;
    }
    public boolean getSexM(){
        return sexM;
    }
    public Persons(String name,int age,boolean sexM){
        this.name = name;
        this.age = age;
        this.sexM = sexM;
    }
    Persons(){
        this.name = "";
        this.age = 0;
        this.sexM = true;
    }
    public void speak(String name){
        System.out.println(name + " : 说话!");
    }
    void walk(int age){
        System.out.println(age + " : 走路!");
    }


}
