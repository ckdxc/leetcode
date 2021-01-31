package QA_EASY.QA1512;

import java.util.Arrays;

/**
 * @programName: leetcode
 * @fileName: Solution
 * @author: SCH
 * @create:2021/1/30 23:41
 * @description: TODO
 */
public class Solution {

    /**
     * 给你一个整数数组 nums 。
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     * 返回好数对的数目。
     * 示例 1：
     * 输入：nums = [1,2,3,1,1,3]
     * 输出：4
     * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
     * 示例 2：
     * 输入：nums = [1,1,1,1]
     * 输出：6
     * 解释：数组中的每组数字都是好数对
     * 示例 3：
     * 输入：nums = [1,2,3]
     * 输出：0
     *
     * @param nums
     * @return
     */
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numIdenticalPairs1(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 1, 3};
        System.out.println(4 == numIdenticalPairs1(nums));
        int[] nums1 = new int[]{1, 1, 1, 1};
        System.out.println(6 == numIdenticalPairs1(nums1));
        int[] nums2 = new int[]{1, 2, 3};
        System.out.println(0 == numIdenticalPairs1(nums2));
    }
}
