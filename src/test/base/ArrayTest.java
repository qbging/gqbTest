package test.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

public class ArrayTest {
	public static void main(String[] args) {
		String t1 = "hello world;";
		t1.indexOf("world");
		List<String> test = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String string = i+"";
			test.add(string);
		}
//		for (String string : test) {//报错
//			test.remove(string);
//		}
		Iterator<String> itr = test.iterator();
		while (itr.hasNext()) {
			itr.next();//不加会报错
			itr.remove();
			
		}
//		for (int i = 0; i < test.size(); i++) {//不会报错
//			String s = test.get(i);  
//	        if (s.equals("1")) {  
//	        	test.remove(s);  
//	        }  
//		}
		System.out.println(test);
		Integer one = new Integer("223");
		List<Integer> list = new ArrayList<Integer>();
		list.add(one);
		Integer two = new Integer("223");
		System.out.println(list.contains(two));//true,contains调用了equals
		System.out.println(one == two);//false
		System.out.println(one.equals(two));//true
		String [] aa = "1,2,3".split(",");
		int [] bb = new int [10];
		System.out.println(Arrays.toString(bb));
		JSONObject jsonObject = new JSONObject();
		System.out.println(jsonObject.isNull("d"));
	}

}
