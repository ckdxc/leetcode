package util;


import java.util.Arrays;

public class ArrayUtil {
    public static int[] getArray(int min, int max , int length){
        int[] arr = new int[length];
        for (int i = 0;i<length;i++){
            arr[i] = (int)(Math.random()*(max-min)+min);
        }
        return arr;
    }

    public static void printArray(int[][] arrs){
        for (int[] arr:arrs){
            System.out.println(Arrays.toString(arr));
        }
    }
}
