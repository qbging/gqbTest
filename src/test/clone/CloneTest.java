package test.clone;

public class CloneTest {

	public static void main(String[] args) {
		ClassA A = new ClassA();
		//如果字段是值类型的，那么对该字段执行复制；如果该字段是引用类型的话，则复制引用但不复制引用的对象。因此，原始对象及其副本引用同一个对象。
		ClassA AB = A.shallowCloneA();
		ClassA C = AB.deepCloneA();
		System.out.println(A==AB);//false
		System.out.println(A.getClass()==AB.getClass());//true
		System.out.println(A.equals(AB));//false
		A.B.b = 100;
		System.out.println(AB.B.b);
		System.out.println(C.B.b);
		System.out.println(A.B+"="+AB.B);//相等,A的引用对象B在clone时，没有clone出副本,即AB中仍然引用的B
		System.out.println(A.B+"!="+C.B);//不相等,A的引用对象B在clone时，clone出副本,即C中引用副本的B
	}
}
