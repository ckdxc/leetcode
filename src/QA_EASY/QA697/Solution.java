package QA_EASY.QA697;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
     * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     * 示例 1：
     * 输入：[1, 2, 2, 3, 1]
     * 输出：2
     * 解释：
     * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     * 连续子数组里面拥有相同度的有如下所示:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组[2, 2]的长度为2，所以返回2.
     * 示例 2：
     * 输入：[1,2,2,3,1,4,2]
     * 输出：6
     * 提示：
     * nums.length 在1到 50,000 区间范围内。
     * nums[i] 是一个在 0 到 49,999 范围内的整数。
     */
    public static int findShortestSubArray1(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] temp;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = map.get(nums[i]);
            if (null == temp) {
                temp = new int[]{1, i, i};
                map.put(nums[i], temp);
            } else {
                temp[0]++;
                temp[2] = i;
            }
            if (temp[0] > max) {
                max = temp[0];
            }
        }
        int subLen = nums.length;
        for (Map.Entry<Integer, int[]> integerEntry : map.entrySet()) {
            int[] value = integerEntry.getValue();
            if (value[0] == max) {
                int tempLen = value[2] - value[1];
                if (subLen > tempLen) {
                    subLen = tempLen;
                }
            }
        }
        return subLen + 1;
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Integer temp;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = count.get(nums[i]);
            if (null == temp) {
                temp = 1;
                count.put(nums[i], temp);
                left.put(nums[i], i);
                right.put(nums[i], i);
            } else {
                count.put(nums[i], ++temp);
                right.put(nums[i], i);
            }
            if (temp > max) {
                max = temp;
            }
        }
        int subLen = nums.length;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int value = entry.getValue();
            if (value == max) {
                int tempLen = right.get(entry.getKey()) - left.get(entry.getKey());
                if (subLen > tempLen) {
                    subLen = tempLen;
                }
            }
        }
        return subLen + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println("result: 2\tanswer: " + findShortestSubArray(nums));
        nums = new int[]{1, 2, 2, 3, 1, 4, 2};
        System.out.println("result: 6\tanswer: " + findShortestSubArray(nums));
    }
}
