package util;


public class ArrayUtil {
    public static int[] getArray(int min, int max , int length){
        int[] arr = new int[length];
        for (int i = 0;i<length;i++){
            arr[i] = (int)(Math.random()*(max-min)+min);
        }
        return arr;
    }
}
