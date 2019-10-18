package test.clone;

public class ClassB implements Cloneable{

	private int a = 1;
	public int b = 2;

	public ClassB cloneB(){
		try {
			return (ClassB) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
