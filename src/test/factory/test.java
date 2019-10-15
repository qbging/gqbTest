package test.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class test {

	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		String ss = map.get("1");
		A a = null;
		do {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza type:");
			String name;
			try {
				name = reader.readLine();
				//简单工厂生产
//				a = Afactory.createA(name);
				//抽象工厂
				a = new AaAbstractFactory().createA(name);
				//或者
//				a = new AbAbstractFactory().createA(name);
				if (null != a) {
					a.prepare();
					a.bake();
					a.box();
					a.cut();
				} else {
					System.out.println("没有该产品");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (true);
	}
}
