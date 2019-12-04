package test.basetest;

public class Implementstest {
	static class A{
		public void draw(){
			System.out.println("A draw");
		}
		public void swimming(){
			System.out.println("A swimming");
		}
	}
	static class B extends A{
		@Override
		public void draw() {
//			super.draw();
			System.out.println("B draw");
		}
		public void run(){
			System.out.println("B run");
		}
	}
	public static void main(String[] args) {
		A a = new B();//此处如是new A()，则下面强制成B对象会有运行时异常
		a.swimming();//A swimming
		a.draw();//B draw
		//a.run(); 无法调用
		B b = (B) a;//相当于B b = new B()
		b.swimming();//A swimming
		b.draw();//B draw
		b.run();//B run
		
	}
}
