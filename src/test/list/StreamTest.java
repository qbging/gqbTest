package test.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author guoqb
 * @date : 2020/2/26 10:49
 * @descript 1.8 流操作
 */
public class StreamTest {
    static class Obj{
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        Obj(String n, int a){
            this.name = n;
            this.age = a;
        }
    }

    public static void main(String[] args) {
        Obj oA = new  Obj("guo",20);
        Obj ob = new Obj("lian",30);
        Obj oc = new Obj("asdgd",20);
        List<Obj> list = new ArrayList<>();
        list.add(oA);
        list.add(oc);
        list.add(ob);
        System.out.println(list);
        List<Obj> collect = list.stream().filter(item -> item.age == 20).collect(Collectors.toList());
        Map<Obj, Obj> collect1 = list.stream().filter(item -> item.age == 20).collect(Collectors.toMap(k -> k, v -> v));
//        Obj obj = list.stream().filter(item -> item.age == 20).findAny().get();
        //map映射生成新流
        List<String> obj = list.stream().filter(item -> item.age == 20).map(Obj::toString).collect(Collectors.toList());
        System.out.println(list);
    }
}
