package test.clone;

public class CloneTest {

	public static void main(String[] args) {
		ClassA A = new ClassA();
		ClassA AB = A.cloneA();
		ClassA C = AB.cloneA();
		System.out.println(A==AB);//false
		System.out.println(A.getClass()==AB.getClass());//true
		System.out.println(A.equals(AB));//false
		A.B.b = 100;
		System.out.println(AB.B.b);
		System.out.println(A.B+"="+AB.B);//相等,A的引用对象B在clone时，没有clone出副本,即AB中仍然引用的B
	}
}
