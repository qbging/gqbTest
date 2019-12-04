package test.parent;

public class Parent {
	
	public Parent() {
		System.out.println("P 构造");
	}

	static {
		System.out.println("P 静态");
	}
	
	{
		System.out.println("P 代码块");
	}
	
	public void P() {
		System.out.println("PppPPPP");
	}
}
