package QA_EASY.QA628;

import java.util.Arrays;

/**
 * @programName: leetcode
 * @fileName: Solution
 * @author: SCH
 * @create:2021/1/30 22:05
 * @description: TODO
 */
public class Solution {
    public static int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int[] nums1;
        if (nums.length < 6) {
            nums1 = nums;
        } else {
            nums1 = new int[]{nums[0], nums[1], nums[2], nums[nums.length - 1], nums[nums.length - 2], nums[nums.length - 3]};
        }
        int max = Integer.MAX_VALUE * -1;
        for (int i = 0; i < nums1.length - 2; i++) {
            for (int j = i + 1; j < nums1.length - 1; j++) {
                for (int k = j + 1; k < nums1.length; k++) {
                    int temp = nums1[i] * nums1[j] * nums1[k];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    public static int maximumProduct1(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 1] * nums[nums.length - 3], nums[0] * nums[1] * nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-100, -98, -1, 2, 3, 4};
//        System.out.println(maximumProduct(nums) + "\tanswer: 39200");
        int[] nums1 = new int[]{-8, -7, -2, 10, 20};
//        System.out.println(maximumProduct(nums1) + "\tanswer: 1120");
        int[] nums2 = new int[]{-100, -98, -1, 2, 3, 4};
//        System.out.println(maximumProduct(nums2) + "\tanswer: 39200");
        int[] nums3 = new int[]{-1, -2, -3, -4};
        System.out.println(maximumProduct(nums3) + "\tanswer: -6");
    }
}
