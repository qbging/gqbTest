package test.test1;
/**
 * 值传递
 * @author guoqb
 *
 */
public class ttest {
	static class A{
		int a = 1;
	}

	public static void main(String[] args) {
//		A ca = new ttest().new A();//成员内部类时的初始化方法
		A ca = new A();//静态内部类时类的声明方法
		ca.a = 2;
		int[] cb = {4,5};
		testexpress(ca);//值传递，ca和cb（地址和内容）都不会被修改
		testexpress(cb);//使用注释的代码会ca和cb（地址不变，内容被修改）会被修改
		testexpress(ca.a);//值传递
	}
	private static void testexpress(int a) {
		a = 10;
	}
	public static void testexpress(A ca){
		A cb = new A();
		cb.a = 3;
		ca = cb;//ca指向了堆中不同地址
//		ca.a = 3;//ca指向堆中数据会被修改
	}
	public static void testexpress(int[] ca){
		int [] b= new int[]{1,2};
		ca = b;//cb指向了堆中不同地址
//		ca[0] = 1;//cb指向的堆中数据会被修改
	}
	
}