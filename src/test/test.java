package test;

import java.io.File;
import java.util.*;

/**
 * @author guoqb
 * @date : 2019/9/30 15:41
 */
public class test {
    public static void main(String[] args) {

        String id = "123&456";
        String substring1 = id.substring(id.indexOf("&")+1);

        Map<String,String> m4 = new HashMap();

        String location = "2019/12/bd9fab057fb04c54a20869ba39c84d2f.png";
        String filePath = location.substring(0,location.lastIndexOf("/"));
        String substring = location.substring(location.lastIndexOf("/"));
        System.out.println(filePath);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        Date time = calendar.getTime();

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
