package QA_EASY.QA802;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args){

    }


    /**
     * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
     *
     * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
     *
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
     *
     * 返回我们可以获得所有词不同单词翻译的数量。
     * @param words
     * @return
     */
    public static int uniqueMorseRepresentations(String[] words){
        Set<String> set = new HashSet<>();
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(int i = 0;i<words.length;i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<words[i].length();j++){
                sb.append(mos[words[i].charAt(j)-97]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
