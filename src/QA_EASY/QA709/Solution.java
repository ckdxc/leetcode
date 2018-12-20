package QA_EASY.QA709;

public class Solution {
    public static void main(String[] args) {
        System.out.println(toLowerCase("SADFsdf"));
        int[] arr = {2,3,4,5,8,9,1,74,6};
        bobbleSort(arr);
    }

    /**
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     * @param str
     * @return
     */
    public static String toLowerCase(String str){
        char[] chars = str.toCharArray();
        for (int i = 0;i<chars.length;i++){
            if(chars[i]>=65&&chars[i]<=90){
                chars[i]=(char) (chars[i]+32);
            }
        }
        return String.valueOf(chars);
    }

    public static void bobbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int t = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
        for(int a:arr){
            System.out.print(a+" - ");
        }
    }
}
