package QA_EASY.QA724;

/**
 * @programName: leetcode
 * @fileName: Solution
 * @author: SCH
 * @create:2021/1/28 22:10
 * @description: TODO
 */
public class Solution {
    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return -1;
        } else if (len == 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum == 0) {
            return 0;
        }
        int temp = nums[0];
        int leftIndex = 1;
        for (int i = 1; i < len; i++) {
            if (temp > 0) {
                temp -= nums[len - i];
            } else {
                temp += nums[i];
                if (leftIndex == len - 1) {
                    break;
                }
                leftIndex++;
            }
        }
        if (temp + nums[leftIndex] == 0) {
            return leftIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,-1,-1,-1,-1};
        System.out.println(pivotIndex(nums));
    }
}
