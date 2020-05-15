package test.algorithm;

/**
 * @author guoqb
 * @date : 2020/2/23 17:07
 * @descript 求一个整数二进制表示中1的个数，其中负数用补码表示
 *             1： 1
 *             3： 2
 *             -1：32
 */
public class NumberOf1 {
    public static void main(String[] args) {
        int method = method(-1);
        System.out.println(method);
    }
    public static int method(int n){
        int mask = 1;
        int res = 0;
        int t = n;
        while (t!=0){
            int i = t & mask;
            if (i == 1){
                res ++;
            }
            t = t >>> 1;
        }
        return res;
    }
}
