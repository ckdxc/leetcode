package QA_EASY.QA961;

public class Solution {
    public static void main(String[] args){

    }

    /**
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素。
     */
    public static int repeatedNTimes(int[] A){
        int N=A.length/2;
        for(int i = 0;i<A.length;i++){
            int Ftimes = 1;
            int Ttimes = 1;
            boolean flg =false;
            for (int j = i + 1;j<A.length;j++){
                if(A[i]!=A[j])
                    Ftimes++;
                else
                    Ttimes++;
                if(Ftimes==N)
                    flg=true;
                if(Ttimes==N)
                    return A[i];
            }
            if (flg==true)
                continue;
        }
        return 0;
    }
}
