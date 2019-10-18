package test.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchTest {

    public static void main(String[] args) {

        //*****匹配图片格式的文件名******
        boolean matches = Pattern.matches("^.*(jpg|png|bmp|gif)$", "1JPG".toLowerCase());
        System.out.println(matches);

        String str ="中华人民共和国，简称（中国）。";
            Matcher mat = Pattern.compile("(?<=\\（)(\\S+)(?=\\）)").matcher(str);//此处是中文输入的（）
            while(mat.find()){
                     System.out.println(mat.group());
                 }
        String string = "baabrraaab";
        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher = pattern.matcher(string);
        //matches是整串匹配，find是部分匹配
        System.out.println("matches："+matcher.matches());//string是aaab时true，raaab时false
//        System.out.println("find:"+matcher.find());//string是aaab时false，raaab时true
        while (matcher.find()){//此处之前如果调用了find，则打印的是开始第二次匹配的子序列
            System.out.println("匹配的子序列："+matcher.group());
        }

        /*输出：中国
        matches：false
        匹配的子序列：b///如果上面注释部分放开，则这行输出就没有了
        匹配的子序列：aab
        匹配的子序列：aaab*/
    }
}
