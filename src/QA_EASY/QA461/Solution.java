package QA_EASY.QA461;

public class Solution {
    public static void main(String[] args) {
        hammingDistance(93, 73);
    }

    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * 注意：
     * 0 ≤ x, y < 231.
     * 示例:
     * 输入: x = 1, y = 4
     * 输出: 2
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        char[] xchars = Integer.toBinaryString(x).toCharArray();
        char[] ychars = Integer.toBinaryString(y).toCharArray();
        if (xchars.length > ychars.length)
            return conpare(xchars, ychars);
        else
            return conpare(ychars, xchars);
    }
    public static int conpare(char[] x, char[] y) {
        int count = 0;
        int sub = x.length - y.length;
        if (sub != 0) {
            for (int i = 0; i < sub; i++) {
                if (x[i] != '0')
                    count++;
            }
            for (int j = sub; j < x.length; j++) {
                if (x[j] != y[x.length - sub])
                    count++;
            }
        }
        for (int k = sub; k < x.length; k++) {
            if (x[k] != y[k])
                count++;
        }
        return count;
    }

    /**
     * 解法二
     * 运用 异或运算,然后把运算结果转换成二进制 统计 1 的个数
     */
    public static int hammingDistance2(int x, int y) {
        int bin = x^y;
        char[] chars = Integer.toBinaryString(bin).toCharArray();
        int count = 0;
        for (char c : chars) {
            if ('1' == c)
                count++;
        }
        return count;
    }
}
