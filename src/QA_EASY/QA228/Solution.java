package QA_EASY.QA228;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * 给定一个无重复元素的有序整数数组 nums 。
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     * "a->b" ，如果 a != b
     * "a" ，如果 a == b
     * 示例 1：
     * 输入：nums = [0,1,2,4,5,7]
     * 输出：["0->2","4->5","7"]
     * 解释：区间范围是：
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     * 示例 2：
     * 输入：nums = [0,2,3,4,6,8,9]
     * 输出：["0","2->4","6","8->9"]
     * 解释：区间范围是：
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     * 示例 3：
     * 输入：nums = []
     * 输出：[]
     * 示例 4：
     * 输入：nums = [-1]
     * 输出：["-1"]
     * 示例 5：
     * 输入：nums = [0]
     * 输出：["0"]
     * 提示：
     * 0 <= nums.length <= 20
     * -231 <= nums[i] <= 231 - 1
     * nums 中的所有值都 互不相同
     * nums 按升序排列
     */
    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        if (nums.length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }
        int start = 0, end = 1;
        List<String> res = new ArrayList<>();
        while (start < nums.length) {
            if ((long) nums[end] - (long) nums[start] > end - start) {
                if (end - start > 1) {
                    res.add(new StringBuilder().append(nums[start]).append("->").append(nums[end - 1]).toString());
                } else {
                    res.add(String.valueOf(nums[start]));
                }
                start = end;
            }
            end++;
            if (end == nums.length) {
                end--;
                if (start == end) {
                    res.add(String.valueOf(nums[start]));
                } else {
                    res.add(new StringBuilder().append(nums[start]).append("->").append(nums[end]).toString());
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
//        System.out.println("result: [0->2,4->5,7]\tanswer: " + summaryRanges(nums).toString());
//        nums = new int[]{0, 2, 3, 4, 6, 8, 9};
//        System.out.println("result: [0,2->4,6,8->9]\tanswer: " + summaryRanges(nums).toString());
//        nums = new int[]{};
//        System.out.println("result: []\tanswer: " + summaryRanges(nums).toString());
//        nums = new int[]{-1};
//        System.out.println("result: [-1]\tanswer: " + summaryRanges(nums).toString());
//        nums = new int[]{0};
//        System.out.println("result: [0]\tanswer: " + summaryRanges(nums).toString());
        nums = new int[]{-2147483648, -2147483647, 2147483647};
        System.out.println("result: [-2147483648->-2147483647,2147483647]\tanswer: " + summaryRanges(nums).toString());
    }
}
