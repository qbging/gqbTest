package test.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import test.basetest.neibulei;

public class HttpTest extends neibulei{
	private  void zilei() {
//		int sa = super.aa;//default，不同包子类内不可访问，这里会报错
		super.ff();//protected,不同包子类可访问，不会报错
	}

	public static void main(String[] args)  {
		neibulei nn = new neibulei();
//		int aa = nn.aa;//default，不同包子类对象不可访问，报错
//		nn.ff();//protected,不同包下，父类对象不可访问，报错
		HttpTest test = new HttpTest();
		test.ff();//protect 不同包下，子类对象可访问
//		test.aa;//default，不同包下，子类对象不可访问，报错
		try {
			String weburl = "http://news.china.com/socialgd/10000169/20180328/32240164.html";
	    	Pattern pattern = Pattern.compile("(ftp|http|https)://((\\w)+\\.)+\\w+");
			Matcher matcher = pattern.matcher(weburl);
			URL urlData = null;
			if (matcher.find()) {// 通过正则表达式获取格式化后的标准数据
				String url = URLEncoder.encode(weburl, "UTF-8");
				urlData = new URL("http://192.168.32.10/ws/html/info?url="+url);
//				String ssString = matcher.group();
//				String protocol = weburl.substring(0, weburl.indexOf(":"));
			} else {
				try {
					String url = URLEncoder.encode(weburl, "UTF-8");
					urlData = new URL("http://192.168.32.10/ws/html/info?url="+url);
					String host = urlData.getHost();//获取域名
					urlData.getDefaultPort();
					urlData.getFile();
					urlData.getRef();
					urlData.getUserInfo();
					urlData.getAuthority();
					urlData.getProtocol();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			URL url = new URL("http://60.29.201.140:8689/api/bigScreen/attendantsList");
			HttpURLConnection urlConnection = (HttpURLConnection)urlData.openConnection();
//			urlConnection.setDoOutput(true); 
			urlConnection.connect();
//			urlConnection.getContent();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
//			String line;
//			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("D:\\1111.doc")),"UTF-8"));
//			while ((line = reader.readLine())!=null) {
//				out.write(line, 0, line.length());
//			}
//			out.flush();
//			out.close();
			InputStream inputStream =  (InputStream) urlConnection.getContent();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	        String line,resultStr="";
	        while(null != (line=bReader.readLine())) {
	        	resultStr +=line;
	        }
	        System.out.println(resultStr);
//			FileOutputStream outputStream = new FileOutputStream(new File("D:\\1111.doc"));
//			byte[] arr = new byte[1024];
//			while(-1!=inputStream.read(arr)){
//				System.out.println(arr);
//				outputStream.write(arr, 0, arr.length);
//			}
			inputStream.close();
//			outputStream.flush();
//			outputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		}

	}

