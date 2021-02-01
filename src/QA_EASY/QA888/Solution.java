package QA_EASY.QA888;

import java.util.Arrays;

/**
 * @programName: leetcode
 * @fileName: Solution
 * @author: SCH
 * @create:2021/2/1 21:08
 * @description: TODO
 */
public class Solution {
    /**
     * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
     * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
     * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
     * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
     * 示例 1：
     * 输入：A = [1,1], B = [2,2]
     * 输出：[1,2]
     * 示例 2：
     * 输入：A = [1,2], B = [2,3]
     * 输出：[1,2]
     * 示例 3：
     * 输入：A = [2], B = [1,3]
     * 输出：[2,3]
     * 示例 4：
     * 输入：A = [1,2,5], B = [2,4]
     * 输出：[5,4]
     */
    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int aSum = 0, bSum = 0;
        for (int i = 0; i < A.length; i++) {
            aSum += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            bSum += B[i];
        }
        int difference = aSum - bSum;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if ((A[i] - B[j]) * 2 == difference) {
                    res[0] = A[i];
                    res[1] = B[j];
                    break;
                }
            }
        }
        return res;
    }

    public static int[] fairCandySwap1(int[] A, int[] B) {
        int[] res = new int[2];
        int sumA = sum(A);
        int sumB = sum(B);
        int delta = (sumA - sumB) / 2;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0, lenA = A.length, lenB = B.length, temp;
        while (i < lenA && j < lenB) {
            temp = A[i] - B[j];
            if (temp == delta) {
                res[0] = A[i];
                res[1] = B[j];
                break;
            } else if (temp > delta) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1}, B = new int[]{2, 2};
        System.out.println("[1,2]\tanswer: " + (Arrays.toString(fairCandySwap1(A, B))));
        A = new int[]{1, 2};
        B = new int[]{2, 3};
        System.out.println("[1,2]\tanswer: " + (Arrays.toString(fairCandySwap1(A, B))));
        A = new int[]{2};
        B = new int[]{1, 3};
        System.out.println("[2,3]\tanswer: " + (Arrays.toString(fairCandySwap1(A, B))));
        A = new int[]{1, 2, 5};
        B = new int[]{2, 4};
        System.out.println("[5,4]\tanswer: " + (Arrays.toString(fairCandySwap1(A, B))));
    }
}
