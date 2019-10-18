package test.clone;

public class ClassA extends Object implements Cloneable {

	private int a;
	private int b=1;
	public int[]e = {1,2,3};
	public ClassB B = new ClassB();
	private static int c;
	private static int d=0;
	//浅克隆，引用对象类型，近复制引用，不复制对象
	public ClassA shallowCloneA() {
		try {
			//如果字段是值类型的，那么对该字段执行复制；引用类型的话，则复制引用但不复制引用的对象。因此，原始对象及其副本引用同一个对象。
			return (ClassA) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ClassA deepCloneA() {
		ClassA classA = null;
		try {
			classA = (ClassA) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		classA.B = B.cloneB();
		return classA;
	}
	
}
