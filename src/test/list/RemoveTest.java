package test.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author guoqb
 * @date : 2020/2/7 17:46
 * @descript Arrays.asList返回的是内部类arraylist
 */
public class RemoveTest {
    public static void main(String[] args) {
        String []arr = {"1"};
        List list = Arrays.asList(arr);//不可add remove
        ArrayList arrayList = new ArrayList();
        boolean b = Collections.addAll(arrayList, arr);
        String[] objects = (String[]) arrayList.toArray();
        arrayList.remove("1");
    }

    public int[] find(){
        return null;
    }
}
