package QA_EASY.QA1021;

/*
 *项目名: leetcode
 *文件名: Solution
 *创建者: SCH
 *创建时间:2019/8/13 22:47
 *描述: TODO
 */

import sun.security.util.Cache;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 */
public class Solution {
    public static void main(String[] args) {
        String str = removeOuterParentheses("(()(()))()");
        System.out.println(str);
        System.out.println("()()()()(())");
        System.out.println("(()())(())(()(()))");
        System.out.println("()()()()(())".equals(str));
    }
//        ()()()()(());
//        ()()()()(())

    public static String removeOuterParentheses(String S) {
        StringBuilder str = new StringBuilder(S);
        StringBuilder fix = new StringBuilder();
        StringBuilder res = new StringBuilder();
        while (!"".equals(str.toString())) {
            StringBuilder temp = new StringBuilder(str);
            while ('(' == temp.charAt(0)) {
                temp.deleteCharAt(0);
                fix.append(")");
            }
            int index = str.indexOf(fix.toString());
            res.append(str.substring(1, index + fix.length() - 1));
            str.delete(0, index + fix.length());
            if (!"".equals(str.toString()) && ')' == (str.charAt(0))) {
                for (int i = 0; i < str.length(); i++) {
                    res.append(")");
                    str.delete(0, 1);
                }
            }
            fix = new StringBuilder();
        }
        return res.toString();
    }
}
