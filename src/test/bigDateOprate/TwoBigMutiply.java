package test.bigDateOprate;

/**
 * @author guoqb
 * @date : 2019/10/15 15:13
 * @descript 两个大数字相乘
 */
public class TwoBigMutiply {
    public static void main(String[] args) {
        int m = 99;
        int n = 99;
        mul(String.valueOf(m),String.valueOf(n));
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

    private static String mul(String num1, String num2) {
        //把字符串转换成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();
        //声明存放结果和两个乘积的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];
        //把char转换成int数组，为什么要减去一个'0'呢？因为要减去0的ascii码得到的就是实际的数字
        for(int i = 0; i < chars1.length;i++)
            n1[i] = chars1[i]-'0';
        for(int i = 0; i < chars2.length;i++)
            n2[i] = chars2[i]-'0';
        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for(int i =0 ; i < chars1.length; i++){
            for(int j =0; j < chars2.length; j++){
                result[i+j]+=n1[i]*n2[j];
            }
        } //满10进位，从后往前满十进位
        for(int i =result.length-1; i > 0 ;i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        } //转成string并返回
        String resultStr = "";
        //因为上面双层遍历最后一位原因填不上，最后一位没有输出
        for(int i = 0; i < result.length-1; i++){
            resultStr+=""+result[i];
        }
        return resultStr;

    }
}
