package javaStream;

public class DemoArray {
    public static void main(String[] args) {
        new DemoArray().demo(10);
    }

    public int[] buildArray(int len,TheArray theArray){
        return theArray.getArray(len);
    }

    public int[] demo(int len){
        int[] arr =  buildArray(len,int[]::new);
        System.out.println(arr.length);
        return arr;
    }
}
