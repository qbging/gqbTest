package test.clone;

public class ClassA extends Object implements Cloneable {

	private int a;
	private int b=1;
	public int[]e = {1,2,3};
	public ClassB B = new ClassB();
	private static int c;
	private static int d=0;
	public ClassA cloneA() {
		try {
			return (ClassA) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
