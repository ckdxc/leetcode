package QA_EASY.QA929;

import util.ArrayUtil;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args){
        System.out.println(Arrays.toString(getArray(10)));

        String[] arr = getArray(10);
        System.out.println(numUniqueEmails(arr));
        System.out.println(numUniqueEmails(arr,1));
    }
    /**
     * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
     * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
     * 除了小写字母，这些电子邮件还可能包含 ',' 或 '+'。
     * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。
     * 例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
     * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。
     * 这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
     * 可以同时使用这两个规则。
     * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
     */
    public static int numUniqueEmails(String[] emails) {
        String[] localnames = new String[emails.length];
        String[] scopenames = new String[emails.length];
        int index,count = 0,scopesame=0;
        String stra="",strb="";
        // 本地名称 和 域名 分组;
        for (int i = 0;i<emails.length;i++){
            index = emails[i].indexOf("@");
            localnames[i] = emails[i].substring(0,index);
            scopenames[i] = emails[i].substring(index);
        }
        //遍历 域名
        for (int i = 0;i<scopenames.length-1;i++){
            for (int j = i+1;j<scopenames.length;j++){
                //域名相同 就 本地名称 比较
                if(scopenames[i]==scopenames[j]){
                    scopesame++;
                    int pointindex = localnames[i].indexOf(".");
                    int plusindex = localnames[i].indexOf("+");
                    if (plusindex>0)
                        stra = localnames[i];
                    if (plusindex>0)
                        stra = stra.substring(0,plusindex);
                    pointindex = localnames[j].indexOf(".");
                    plusindex = localnames[j].indexOf("+");
                    if (plusindex>0)
                        stra = localnames[i];
                    if (plusindex>0)
                        stra = stra.substring(0,plusindex);
                    if(!stra.equals(strb))
                        count++;
                }
            }
        }
        return emails.length-scopesame+count;
    }

    public static String[] getArray(int length){
        String[] strs = new String[length];
        String[] scopenames = {"qq.com","sina.com","163.com","ckdxc.com"};
        String[] localnames = {"ckdxc","13246568","qqqqqqq","dsjhfakj"};
        for (int i = 0;i<length;i++){
            int[] scopename = ArrayUtil.getArray(0,4,1);
            int[] localname = ArrayUtil.getArray(0,4,1);
            int[] pointindex = ArrayUtil.getArray(0,localnames[localname[0]].length(),1);
            int[] plusindex = ArrayUtil.getArray(0,localnames[localname[0]].length()+1,1);
            StringBuilder sb = new StringBuilder(localnames[localname[0]]).insert(pointindex[0],".");
            sb.insert(plusindex[0],"+").append("@").append(scopenames[scopename[0]]);
            strs[i]=sb.toString();
        }
        return strs;
    }


    public static int numUniqueEmails(String[] emails, int a) {
        if (emails == null) return 0;
        HashSet<String> unique = new HashSet<String>();
        for (String email : emails) {
            unique.add(realEmail(email));
        }
        return unique.size();
    }

    public static String realEmail(String email) {
        char[] impl = email.toCharArray();
        boolean metAt = false;
        boolean metPlus = false;
        int cur = 0, dst = 0;
        while (cur < impl.length) {
            if (metAt) {
                impl[dst++] = impl[cur++];
            } else {
                switch (impl[cur]) {
                    case '.':
                        cur++;
                        break;
                    case '+':
                        metPlus = true;
                        cur++;
                        break;
                    case '@':
                        metAt = true;
                        impl[dst++] = impl[cur++];
                        break;
                    default:
                        if (metPlus) {
                            cur++;
                        } else {
                            impl[dst++] = impl[cur++];
                        }
                }
            }
        }
        return new String(impl, 0, dst);
    }
}
