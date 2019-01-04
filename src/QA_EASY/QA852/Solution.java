package QA_EASY.QA852;

/**
 * ClassName: Solution
 * Package: QA_EASY.QA852
 * Description:
 * CreateTime: 19/1/4 22:04
 * @author ckdxc
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     *我们把符合下列属性的数组 A 称作山脉：
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0;i < A.length - 1;i++) {
            if (A[i] >= A[i+1]) {
                return i;
            }
        }
        return 0;
    }
}
