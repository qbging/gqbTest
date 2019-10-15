package test.bigDateOprate;

import java.util.Arrays;

/**
 * @author guoqb
 * @date : 2019/10/15 14:26
 * @descript 单个大数乘一个较小的数
 */
public class OneBigMutiply {
    public static void main(String[] args) {
        int a = 56789;
        int b = 18;
        int c = a * b;
        System.out.println(c);

        int [] ints = new int[10];
        ints[ints.length-1] = 9;
        ints[ints.length-2] = 8;
        ints[ints.length-3] = 7;
        ints[ints.length-4] = 6;
        ints[ints.length-5] = 5;
        int num = 18;
        //单个大数字的相乘
//        bigMutiply(ints,num);
        //10阶乘
        int d = 20;
        ints = new int[100];
        ints[ints.length-1] = 1;
        for (int i =1; i<=d; i++){
            ints = bigMutiply(ints,i);
        }
        //输出结果
        boolean ifZero = true;
        for (int i = 0; i <= ints.length-1; i++){
            if (0 != ints[i]){
                ifZero = false;
            }
            if (!ifZero){
                System.out.print(ints[i]);
            }
        }
//        //计算每一位的结果
//        for (int i = 0; i <= ints.length-1; i++){
//            ints[i] = ints[i] * num;
//        }
//        //进位和留位
//        for (int i = ints.length-1 ; i > 0; i--){
//            ints[i-1] = ints[i-1] + ints[i] / 10;
//            ints[i] = ints[i] % 10;
//        }
//        boolean ifZero = true;
//        for (int i = 0; i <= ints.length-1; i++){
//            if (0 != ints[i]){
//                ifZero = false;
//            }
//            if (!ifZero){
//                System.out.print(ints[i]);
//            }
//        }
    }

    public static int[] bigMutiply(int[] ints,int num){
        int[] copy = Arrays.copyOf(ints, ints.length);
        //计算每一位的结果
        for (int i = 0; i <= copy.length-1; i++){
            copy[i] = copy[i] * num;
        }
        //进位和留位
        for (int i = copy.length-1 ; i > 0; i--){
            copy[i-1] = copy[i-1] + copy[i] / 10;
            copy[i] = copy[i] % 10;
        }
        return copy;
    }
}
