package test.list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guoqb
 * @date : 2020/3/22 14:27
 * @descript
 */
public class StreamTest2 {
    public static void main(String[] args) {
        // 无尽流
//        Stream<Integer> stream4 = Stream.iterate(0,(x) -> x+2);
//        stream4.forEach(System.out::println);
//        stream4.forEach(o-> System.out.println(o));
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //打印
//        list.forEach(System.out::println);
//        list.forEach(o-> System.out.println(o));
        //先过滤出来大于3的，然后找最大值
        System.out.println(list.stream().filter(o->o>3).max((o1,o2)->o1-o2));
        //map映射生成新流
        list.stream().map(o->o+2).forEach(System.out::println);
        //map映射的新流，然后将流转换成新的形式
        Map<Integer, List<Integer>> collect = list.stream().map(o -> o + 2).collect(Collectors.groupingBy(o -> o ));
        collect.forEach((o1,o2)-> System.out.println(o1+"-"+o2));
    }
}
