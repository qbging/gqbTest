package test.basetest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class StringTest {

	public static void main(String[] args) {
		BigDecimal dd = new BigDecimal("11");
		System.err.println(dd.toString());
		String bbString = "123";
		System.out.println(bbString.substring(0, bbString.length()));
		Object a = 1.1;
		System.out.println(a.toString());
		BigDecimal decimal = new BigDecimal(a.toString());
		List<String> list = new ArrayList<String>();
		list.add("1");
		List<String> reList = list.subList(1, list.size());
		
		BigDecimal b1 = new BigDecimal(5);
		BigDecimal b2 = new BigDecimal(2);
		System.out.println(new BigDecimal(b1.doubleValue(), new MathContext(2)));
		System.out.println(b1.divide(b2, 2, RoundingMode.HALF_UP));
		String st = "/a/b/c/d/e/";
		st = st.substring(0, st.lastIndexOf("/"));
		System.out.println(st);
		st = st.substring(0, st.lastIndexOf("/")+1);
		System.out.println(st);
	}
}
