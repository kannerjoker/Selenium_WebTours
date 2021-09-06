package javaAnnotation.testAnnotation;
public class Calculator {
    //加法
    @Check
    public void plus(){
        System.out.println("1 + 0 = " + (1 + 0));
    }
    //减法
    @Check
    public void sub(){
        System.out.println("1 - 0 = " + (1 - 0));
    }
    //乘法
    @Check
    public void mul(){
        System.out.println("1 * 0 = " + (1 * 0));
    }
    //除法
    @Check
    public void div(){
        System.out.println("1 / 0 = " + (1 / 0));
    }
    public void result(){
        System.out.println("No bugs!");
    }

}
