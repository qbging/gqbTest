package test.parent;

public class Child extends Parent {
	
	public Child() {
		System.out.println("C 构造");
	}

	static {
		System.out.println("C 静态");
	}
	
	{
		System.out.println("C 代码块");
	}
	
	public void C() {
		System.out.println("CCCCCCCC");
	}

	public static void main(String[] args) {
		Child c = new Child();
		/*上下两个输出相同：P 静态
			C 静态
			P 代码块
			P 构造
			C 代码块
			C 构造
			*/
		Parent p = new Child();
		
	}
}
