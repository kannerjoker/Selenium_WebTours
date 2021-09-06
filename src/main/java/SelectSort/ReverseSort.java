package SelectSort;

import java.util.Arrays;

public class ReverseSort {
    public int[] sort(int[] arr,int min,int max){
        if(min>max){
            return arr;
        }
        /*int a = 0;
        if((arr.length % 2) == 0){
            a = arr.length / 2;
        }if(arr.length % 2 == 1 ){
            a = (arr.length + 1);
        }*/
//        int min=0,max=arr.length-1;
        int temp;
        int i=min,j=max;

        int index = arr[min];
        do{
            while(i<j && index>=arr[i]){
                i++;
            }
            while(i<j && index<=arr[j]){
                j--;
            }
            if(arr[i]>arr[j]&&i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }while(i<j);

        arr[min] = arr[i];
        arr[i] = index;

//        if(i){
//
//        }
        sort(arr,min,j-1);
        sort(arr,j+1,max);





        System.out.println(Arrays.toString(arr));
        return arr;
    }

}
