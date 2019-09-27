package test;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class OuterClass {
    private class InnerClass{
        public InnerClass(){
            System.out.println("inner created");
        }
        public int a = 1;
    }
    public OuterClass(){
        i = new InnerClass();
        System.out.println("outer created");
    }
    private InnerClass i = null;
    private int b = 2;

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        OuterClass outer = new OuterClass();
        //获取外部类内的第一个内部类
        Class<?> aClass = outer.getClass().getDeclaredClasses()[0];
        //根据内部类的特性，需要由外部类来反射获取内部类的构造方法（这里获取的是内部类的默认构造方法）
        Constructor<?> inCon = aClass.getDeclaredConstructors()[0];
        //由外部类对象来反射获取内部类的对象
        Object inner = inCon.newInstance(outer);
        //获取内部类的私有成员属性inner
        Field a = aClass.getDeclaredField("a");
        a.setAccessible(true);
        //获取内部类对象obj中的私有成员属性inner的值
        Object value = a.get(inner);
        System.out.println(value);
    }
}
