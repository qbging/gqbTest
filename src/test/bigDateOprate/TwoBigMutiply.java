package test.bigDateOprate;

/**
 * @author guoqb
 * @date : 2019/10/15 15:13
 * @descript 两个大数字相乘
 */
public class TwoBigMutiply {
    public static void main(String[] args) {
        int a = 1234;
        int b = 5678;
        int c = a*b;
        System.out.println(c);

        final int[] intsa = new int[10];
        intsa[intsa.length-1] = 4;
        intsa[intsa.length-2] = 3;
        intsa[intsa.length-3] = 2;
        intsa[intsa.length-4] = 1;
        final int[] intsb = new int[10];
//        intsb[intsb.length-1] = 8;
//        intsb[intsb.length-2] = 7;
//        intsb[intsb.length-3] = 6;
//        intsb[intsb.length-4] = 5;
        intsb[intsb.length-1] = 8;
        intsb[intsb.length-2] = 70;
        intsb[intsb.length-3] = 600;
        intsb[intsb.length-4] = 5000;

        int[] ints = new int[10];
        //引用传递，有问题
        for (int i = intsb.length-1; i >= 1; i--){
            int[] intsc = OneBigMutiply.bigMutiply(intsa, intsb[i]);
//            if (i != intsb.length-1){//结果需要乘10的倍数
//                intsc = OneBigMutiply.bigMutiply(intsc, (int)Math.pow(10,(intsb.length-1 - i)));
//            }
            ints = BigAdd.bigAdd(ints,intsc);
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
    }
}
