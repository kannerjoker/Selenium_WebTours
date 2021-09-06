package SelectSort;

import java.util.Arrays;
import java.util.Random;

public class Select implements Sort{
    public int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int index = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[index]<arr[j]){
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new CreateArray().createInt(100,11);
        System.out.println("=========================");
        /*Select s = new Select();
        s.sort(arr);*/
        ReverseSort rs = new ReverseSort();
        rs.sort(arr,0,arr.length-1);
    }
}
