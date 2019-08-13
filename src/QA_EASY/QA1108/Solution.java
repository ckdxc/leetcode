package QA_EASY.QA1108;

/*
 *项目名: leetcode
 *文件名: Solution
 *创建者: SCH
 *创建时间:2019/8/13 22:27
 *描述: TODO
 */
public class Solution {
    public static void main(String[] args) {
        String ip = "192.168.0.1";
        System.out.println(defangIPaddr(ip));
    }

    public static String defangIPaddr(String address) {
        String[] strings = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i] + "[.]");
        }
        int index = sb.lastIndexOf("[.]");
        return sb.delete(index, sb.length()).toString();
    }

    public String defangIPaddr1(String address) {
        StringBuilder s = new StringBuilder(address);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                s.insert(i + 1, ']');// 先插入后面,此时i下标仍是'.';
                s.insert(i, '[');// 插入前'.'前面,此时i下标是'[' ,i+2为']';
                i = i + 3;// 故i直接+3,为下一个字符
            }
        }
        return s.toString();
    }
    public String defangIPaddr3(String address) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                s.append('[');
                s.append('.');
                s.append(']');
            } else {
                s.append(address.charAt(i));
            }
        }
        return s.toString();
    }
}
