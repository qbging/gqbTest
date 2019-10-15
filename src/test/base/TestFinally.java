package test.base;

public class TestFinally {

	public static boolean f(){
		boolean a = false;
		try {
			a=true;
			return a;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(f());
		String s1 = "【时政】3月份时政模拟100题及答案";
		String s2 = "【时政】3月份时政模拟100题及答案";
	}
}
