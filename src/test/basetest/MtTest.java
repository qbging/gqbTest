package test.basetest;

import java.util.Scanner;

/**
 * bai 7 ,wan 5,共深 
 * @author guoqb
 *
 */
public class MtTest {
	static {
		System.out.println("静态代码快。。");
	}
	public static void main(String[] args) {
		neibulei nn = new neibulei();
		nn.ff();
		test t1 = new test();
		t1.ff();
//		MtTest test;
		for (int i = 0; i < 5; i++) {
			Scanner scanner = new Scanner(System.in);
			int total = scanner.nextInt();
			int out = pachu(total,0);
			System.out.println(out);
			scanner.close();
		}
	}
	public static int pachu(int total,int day){
		
		day ++;
		if (total > 7) {
			total = total - 7;
			if (total >=0) {
				total = total + 5;
			}
			if (total > 7 || total < 7) {
				return pachu(total,day);
			} else if (total == 7) {
				day++;
			}
		}
		return day;
	}
}
