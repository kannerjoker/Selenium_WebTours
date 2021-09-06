package fightAgainstLandlorder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Rules {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        Rules r = new Rules();
        r.getCards(arr1,arr2,arr3);

    }
    public void getCards(ArrayList<Integer> arr1,ArrayList<Integer> arr2,ArrayList<Integer> arr3){
        Rules ir = new Rules();
        ArrayList<Integer> arr = ir.refresh();
        System.out.println(arr);
        int zuoZhuang = new Random().nextInt(35)+10;
        System.out.println(zuoZhuang);
//        for (int i = 0; i< 48; i=i+3)
//
// {
//            arr1.add(arr.get(i));
//            arr2.add(arr.get(i+1));
//            arr3.add(arr.get(i+2));
//            arr.remove(i);
//            arr.remove(i+1);
//            arr.remove(i+2);
//        }
//        if(zuoZhuang%3 == 1){
//            arr1.addAll(arr);
//        }
//        if(zuoZhuang%3 == 2){
//            arr2.addAll(arr);
//        }
//        if(zuoZhuang%3 == 0){
//            arr3.addAll(arr);
//        }
//        System.out.println("arr1"+arr1);
//        System.out.println("arr2"+arr2);
//        System.out.println("arr3"+arr3);
    };
    public ArrayList<Integer> refresh(){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int k = 0; k < 54; k++) {
            arr.add(new Random().nextInt(54));
        }
        for (int i = 0; i < 53; i++) {
            for (int j = i+1; j < 54; j++) {
                if(arr.get(i) == arr.get(j)){
                    arr.remove(j);
                    arr.add(new Random().nextInt(53));
                    i = 0;
                }
                if((j<52)&&(arr.get(53)==arr.get(j)||arr.get(53)==arr.get(0))){
                    arr.remove(53);
                    arr.add(new Random().nextInt(53));
                    i = 0;
                }
            }
        }
        return arr;
    }
}
