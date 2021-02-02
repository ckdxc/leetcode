package QA_EASY.QA424;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @programName: leetcode
 * @fileName: Solution
 * @author: SCH
 * @create:2021/2/2 22:36
 * @description: TODO
 */
public class Solution {
    /**
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
     * 注意：字符串长度 和 k 不会超过104。
     * 示例 1：
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     */
    public static int characterReplacement(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] revertChars = new char[len];
        for (int i = 0; i < len; i++) {
            revertChars[i] = chars[len - i - 1];
        }
        return Math.max(getMaxCount(chars, k), getMaxCount(revertChars, k));
    }

    private static int getMaxCount(char[] chars, int k) {
        int left = 0, right = 0, temp = 0, maxCount = 0;
        for (int i = 0; i < chars.length; i++) {
            temp = k;
            left = i;
            right = i + 1;
            while (temp >= 0 && right < chars.length) {
                if (chars[right] != chars[left]) {
                    --temp;
                }
                if (temp >= 0) {
                    ++right;
                }
                if (temp > 0 && right == chars.length) {
                    left -= temp;
                    if (left < 0) {
                        left = 0;
                    }
                }
                if (maxCount < (right - left)) {
                    maxCount = right - left;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println("answer: 4\tresult: " + characterReplacement(s, k));
        s = "AABABBA";
        k = 1;
        System.out.println("answer: 4\tresult: " + characterReplacement(s, k));
        s = "ABBB";
        k = 2;
        System.out.println("answer: 4\tresult: " + characterReplacement(s, k));
        s = "BAAAB";
        k = 2;
        System.out.println("answer: 5\tresult: " + characterReplacement(s, k));
        s = "AAAA";
        k = 2;
        System.out.println("answer: 4\tresult: " + characterReplacement(s, k));
    }
}
