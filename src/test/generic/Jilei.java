package test.generic;

import test.factory.A;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * <p>Title:Jilei.java</p>
 * <p>Copyright: 公共服务与应急管理战略业务本部 Copyright(c)2018</p >
 * <p>Date : 2020/5/14 16:42</p>
 *
 * @author guoqb
 * @version 1.0
 */
public class Jilei<T> {

    public void shuchu(){
        Type genericSuperclass = getClass().getGenericSuperclass();
        TypeVariable<? extends Class<? extends Jilei>>[] typeParameters = getClass().getTypeParameters();
        System.out.println("父类---"+genericSuperclass);//class java.lang.Object
        System.out.println("参数---"+typeParameters[0]);//T
    }

    public static void main(String[] args) {
        new Jilei<Alei>().shuchu(); //class java.lang.Object
    }
}
