package test.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class GyTest {
	static class aaa extends GyTest{
		public void f() throws CloneNotSupportedException{
			super.clone();
			GyTest test = new GyTest();
			test.clone();
		}
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Object th = new Object();
//		th.clone();
		GyTest test = new GyTest();
		test.clone();
		aaa a = new aaa();
		
		
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		json1.put("a", "1");
		JSONArray array = new JSONArray();
		array.put(json1);
		json.put("b", array);
		System.out.println(json.isNull("b"));
//		System.out.println((JSONArray)json1.get("a"));//String和json不能强转
		System.out.println(json.get("b"));//报错，应该为json
		System.out.println((String)json.get("b"));//报错，应该为json
		String ss = "一、请重点范围网站双首页要闻区、客户端转发：1.乱监管、软监管、瞎治理：环保形式主义须重拳整治！卍2.中方将以同样规模金额强度回击美301调查 外交部表态 卍二、请重点推送范围网站新闻频道、客户端转发，纳入暖新闻专题：拾荒夫妻40年拾养9名弃婴,一墙奖状是孩子们回馈的礼物  卍三、请重点推送范围网站双首页、客户端转发：周会明：扎根雪域高原 守望公正卍四、请重点范围网站双首页要闻区、客户端转发：中国保障宗教信仰自由的政策和实践卍";
		System.out.println(ss.split("卍"));
		HashMap<String, String> map = new HashMap<>();
		System.out.println(map.get("a"));
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		for (int i = list.size()-1; i >= 0; i--) {
			list.remove(list.get(i));
		}
		System.out.println(list.size());
	}

}
