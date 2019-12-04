package test;

/**
 * @author guoqb
 * @date : 2019/9/30 15:41
 */
public class test {
    public static void main(String[] args) {
        //merge后提交
        String a = "123";
        String b = "123";
        String c = b;
        String d = new String("123");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
    }
}
