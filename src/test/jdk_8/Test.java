package test.jdk_8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title:Test.java</p>
 * <p>Date : 2020/4/17 14:31</p>
 *
 * @author guoqb
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s = null;//不可为null，可为“”
        List<String> collect = Arrays.asList(s.split(",")).stream().collect(Collectors.toList());
    }
}
