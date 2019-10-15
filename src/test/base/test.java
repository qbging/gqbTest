package test.base;

import java.util.Calendar;

import test.proxytest.CalculatorImpl;

public class test extends neibulei{
	private void zilei(){
		int i = super.aa;
		super.ff();
	}
	public static void main(String[] args) {
		neibulei nnNeibulei = new neibulei();
		nnNeibulei.aa = 1;
		nnNeibulei.ff();
		System.out.println(nnNeibulei.aa);
		System.out.println(CalculatorImpl.class.getName());
		String website = "指令编号：42479"
+"\n"
+"请重点推送网站在PC端首页和客户端显著位置及其评论频道积极转发《【新时代有话说】争当改革路上的青年先锋》《扶志扶智强技“三箭齐发”激活脱贫内生动力》。"
+"\n"
+"\n"
+"\n"
+"http://opinion.jxntv.cn/2018/0103/8787566.shtml";
    	website = website.replaceAll("\\n+", " ");
    	System.out.println(website);
		Calendar calendar = Calendar.getInstance();
		System.out.println(String.format("%02d", calendar.get(Calendar.MILLISECOND)));
	}
//	public static void main(String[] args) throws IOException {
//		
//		BigDecimal aBigDecimal = new BigDecimal(5);
//		System.out.println(aBigDecimal.divide(new BigDecimal(10)));
//		String seqString = String.format("%03d", 10);
//		System.out.println(seqString);
//		StringBuilder sBuilder = new StringBuilder("112");
//		List<StringBuilder> list1 = new ArrayList<StringBuilder>();
//		list1.add(sBuilder);
//		list1.contains(new StringBuilder("112"));//false
//		sBuilder.append("2324");
//		
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		System.out.println(format.format(calendar.getTime()));
//		
//		String angle = "北风转南风";
//		angle = angle.substring(angle.indexOf("转")+1);
//		
//		String ss= "12\n\n34";
//		ss = ss.replace("\n", " ");
//		System.out.println(ss);
//		
//		Integer data = 4;
//		System.out.println(String.format("%06d", data));
//		System.out.printf("%06d", data).println();
//		
//		
//		
//		String st = "a1b2c3";
//		String regex = "(?=.*\\d)(?=.*[a-z,A-Z]).{6,}";
//		System.out.println(Pattern.matches(regex, st));
//		
//		String string = "12345";
//		string.substring(0, string.length()-1);
//		ArrayList<Integer> list =new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(1);
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = i+1; j < list.size(); j++) {
//				if (list.get(i).equals(list.get(j))) {
//					list.remove(j);
//				}
//			}
//		}
//		
//		long x=42;
//		float y = 42.0f;
//		System.out.println(x==y);
//		
//		URL url = new URL("http://www.weibo.com");
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		connection.setConnectTimeout(20000);
//		connection.setReadTimeout(20000);
//		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
//		connection.connect();
//		System.out.println(connection.getResponseCode());
//		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//		String line;
//		while ((line = reader.readLine())!=null) {
//			System.out.print(line+"\n");
//			
//		}
////		Date ss = new Date();
////		Date dd = new Date();
////		System.out.println();
////		String param[] =new String[3] ;
////		param[0] = "11";
////		System.out.println(param.length);
//	}
}
