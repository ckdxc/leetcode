package QA_EASY.QA905;



import util.ArrayUtil;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] random = ArrayUtil.getArray(5,30,10);
        System.out.println(Arrays.toString(random));
        int[] arr = sortArrayByParity(random);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
     * 你可以返回满足此条件的任何数组作为答案。
     * 时间复杂度:   O(N);
     * @param A
     * @return
     */
    public static int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0,oflg=0,qflg= A.length; i < A.length; i++) {
            if (A[i] % 2 == 0)
                B[oflg++] = A[i];
            else
                B[--qflg] = A[i];
        }
        return B;
    }
}