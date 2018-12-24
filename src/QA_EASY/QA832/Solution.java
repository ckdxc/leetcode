package QA_EASY.QA832;

import util.ArrayUtil;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        int[][] arr=flipAndInvertImage(new int[][] {{1,1,0},{1,0,1},{0,0,0}});
        ArrayUtil.printArray(arr);
    }

    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0;i<A.length;i++){
            for (int j = 0;j<A[i].length/2;j++){
                int t = A[i][j];
                A[i][j] = A[i][A[i].length-j-1];
                A[i][A[i].length-j-1] = t;
            }
            for (int j = 0;j<A[i].length;j++){
                if (A[i][j]==0)
                    A[i][j]=1;
                else
                    A[i][j]=0;
            }
        }
        return A;
    }
}
