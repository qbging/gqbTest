package test.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author guoqb
 * @date : 2020/2/23 14:11
 * @descript
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char[] a = br.readLine().toCharArray();
//        char[] b = br.readLine().toCharArray();
//
//        int n = b.length - a.length;
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i <= n; i++) {
//            int count = 0;
//            for (int j = 0; j < a.length; j++) {
//                if (a[j] != b[j + i]) count++;
//            }
//            res = Math.min(res, count);
//        }
//        System.out.println(res);

        String str = "sojgoa";
        char[] chars = str.toCharArray();
        char[] strCopy = new char[5];
        System.arraycopy(chars,0,strCopy,0,1);
        String[] strs = new String[]{"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
//        Map<String, String> getenv = System.getenv();
//        System.out.println(getenv);
    }

    /**
     * 找出最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        char[][] data = new char[strs.length][minLen];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            System.arraycopy(chars, 0, data[i], 0, minLen);
        }

        StringBuilder res = new StringBuilder();
        //i位列 j为行
//        for (int i = 0; i < minLen; i++) {
//            for (int j = 1; j < data.length; j++) {
//                if (data[j - 1][i] != data[j][i]) {
//                    return res.toString();
//                }
//            }
//            res.append(data[0][i]);
//        }
        //i为行，j为列
        for (int j = 0; j < minLen; j++) {
            for (int i = 0; i < strs.length-1; i++) {
                if (data[i + 1][j] != data[i][j]) {
                    return res.toString();
                }
            }
            res.append(data[0][j]);
        }
        return res.toString();
    }
}
