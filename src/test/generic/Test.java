package test.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p>Title:Test.java</p>
 * <p>Copyright: 公共服务与应急管理战略业务本部 Copyright(c)2018</p >
 * <p>Date : 2020/5/14 16:43</p>
 *
 * @author guoqb
 * @version 1.0
 */
public class Test extends Jilei<Alei> {

    public static void main(String[] args) {
        Test test = new Test();
        Class<?> superclass = test.getClass().getSuperclass();
        Type genericSuperclass = test.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) test.getClass().getGenericSuperclass()).getActualTypeArguments();
        System.out.println(superclass+"----"+genericSuperclass);//class test.generic.Jilei----test.generic.Jilei<test.generic.Alei>
        System.out.println(superclass.getName()+"----"+genericSuperclass.getTypeName());//test.generic.Jilei----test.generic.Jilei<test.generic.Alei>
        test.shuchu();//test.generic.Jilei<test.generic.Alei>
        new Test().shuchutest();//test.generic.Jilei<test.generic.Alei>
    }

    public void shuchutest(){
        System.out.println(getClass().getGenericSuperclass());
    }
}
