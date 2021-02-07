package QA_EASY.QA665;

/**
 * @programName: leetcode
 * @fileName: Solution
 * @author: SCH
 * @create:2021/2/7 23:19
 * @description: TODO
 */
public class Solution {

    /**
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * 我们是这样定义一个非递减数列的：对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     * 示例 1:
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * 示例 2:
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     */

    public static boolean checkPossibility(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i > 1 && i < nums.length - 1) {
                    if (nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    }
                }
                nums[i - 1] = nums[i];
            }
            if (count == 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 3};
        System.out.println("answer: true\tresult: " + checkPossibility(nums));
        nums = new int[]{4, 2, 1};
        System.out.println("answer: false\tresult: " + checkPossibility(nums));
        nums = new int[]{-1, 4, 2, 3};
        System.out.println("answer: true\tresult: " + checkPossibility(nums));
        nums = new int[]{3, 4, 2, 3};
        System.out.println("answer: false\tresult: " + checkPossibility(nums));
        nums = new int[]{5, 7, 1, 8};
        System.out.println("answer: true\tresult: " + checkPossibility(nums));
    }
}

