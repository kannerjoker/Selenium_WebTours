package SelectSort;

import java.util.Arrays;
import java.util.Random;

public class CreateArray {
    public int[] createInt(int bound,int length){
        Random r = new Random();
        int[] arr = new int[length];
        for (int j = 0; j < length; j++) {
            arr[j] = r.nextInt(bound);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
