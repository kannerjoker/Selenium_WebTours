package NiuKe_Network;
/*
题目描述:
    将给出的整数x翻转。
    例1:x=123，返回321
    例2:x=-123，返回-321
    你有思考过下面的这些问题么？
    如果整数的最后一位是0，那么输出应该是什么？比如10,100
    你注意到翻转后的整数可能溢出吗？假设输入是32位整数，则将翻转10000000003就会溢出，
你该怎么处理这样的样例？抛出异常？这样做很好，但是如果不允许抛出异常呢？这样的话你必
须重新设计函数（比如添加一个额外的参数）。

*/

import java.util.*;
public class Solution_01 {
    int x = 0;
    int result;
    String s;

    public static void main(String[] args) {
        Solution_01 s = new Solution_01();
        Scanner sc = new Scanner(System.in);
        s.x = sc.nextInt();
        System.out.println(s.reverse(s.x));

    }

    /**
     * @param x int整型;
     * @return int;
     */
    public int reverse(int x){


        s = Integer.toString(x);

//        String r = changeLocation(c).toString();
        int[] ar;

        if(!"-".equals(s.substring(0,1))){
            ar = changeLocation(s.toCharArray());
            for (int i = 0; i < ar.length; i++) {
                result = i*10 + ar[i];
//                for (int j = 0; j < ar.length; j++) {
//
//                }
            }
        }if("-".equals(s.substring(0,1))){
            ar = changeLocation(s.substring(1,s.length()).toCharArray());
            for (int i = 0; i < ar.length; i++) {
                result = i*10 + ar[i];
            }
        }
        return result;
    }
    public int[] changeLocation(char[] c){
        int l = s.length() % 2;
        int z = (s.length() - l)/2;
        char temp;
        int[] arr = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            if(i<=z){
                temp = c[i];
                arr[i] = c[c.length-1-i];
                arr[c.length-1-i] = temp;
            }

        }
        return arr;
    }
}
