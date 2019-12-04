package test.bigDateOprate;

import java.util.Arrays;

/**
 * @author guoqb
 * @date : 2019/10/15 15:26
 * @descript 两个大数字相加
 */
public class BigAdd {
    public static void main(String[] args) {
        int a = 1234;
        int b = 56789;
        System.out.println(a+b);
        int[] intsa = new int[10];
        intsa[intsa.length-1] = 4;
        intsa[intsa.length-2] = 3;
        intsa[intsa.length-3] = 2;
        intsa[intsa.length-4] = 1;
        int[] intsb = new int[10];
        intsb[intsb.length-1] = 9;
        intsb[intsb.length-2] = 8;
        intsb[intsb.length-3] = 7;
        intsb[intsb.length-4] = 6;
        intsb[intsb.length-5] = 5;
        int [] ints = bigAdd(intsa,intsb);
//        //每一位相加
//        for (int i = 0; i <= intsa.length-1; i++)
//        {
//            intsa[i] = intsa[i] + intsb[i];
//        }
//        //进位和留位
//        for (int i = intsa.length-1; i>1 ;i--){
//            intsa[i-1] = intsa[i-1] + intsa[i] / 10;
//            intsa[i] = intsa[i] % 10;
//        }
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
    }

    public static int[] bigAdd(int[] intsa,int[] intsb){
        int[] copy = Arrays.copyOf(intsa, intsa.length);
        //每一位相加
        for (int i = 0; i <= copy.length-1; i++)
        {
            copy[i] = copy[i] + intsb[i];
        }
        //进位和留位
        for (int i = copy.length-1; i>1 ;i--){
            copy[i-1] = copy[i-1] + copy[i] / 10;
            copy[i] = copy[i] % 10;
        }
        return copy;
    }
}
