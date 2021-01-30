package QA_EASY.QA058;

/**
 * @programName: leetcode
 * @fileName: Solution
 * @author: SCH
 * @create:2021/1/30 23:17
 * @description: TODO
 */
public class Solution {
    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] res = new char[len];
        for (int i = 0; i < n; i++) {
            res[len - n + i] = chars[i];
        }
        for (int i = 0; i < len - n; i++) {
            res[i] = chars[n + i];
        }
        return new String(res);
    }

    public static String reverseLeftWords1(String s, int n) {
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(n));
        sb.append(s, 0, n);
        return sb.toString();
    }

    public static String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseLeftWords1(s, k) + "\tanswer: cdefgab");
    }
}
