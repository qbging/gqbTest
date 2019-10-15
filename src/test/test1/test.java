package test.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

public class test {

	public static void main(String[] args) {
		JSONObject json= new JSONObject();
		json.put("jj", (Object)null);
		System.out.println(json);
		System.out.println(String.format("%.2f", 4.011)); 
		System.out.println(String.format("%.2f",4.012)); 
		System.out.println(String.format("%.2f",4.013)); 
		System.out.println(String.format("%.2f",4.014)); 
		System.out.println(String.format("%.2f",4.015)); 
		System.out.println(String.format("%.2f",4.016)); 
		System.out.println(String.format("%.2f",4.017)); 
		System.out.println(String.format("%.2f",4.018)); 
		System.out.println(String.format("%.2f",4.019)); 
		System.out.println(String.format("%.2f",4.020)); 
		System.out.println(String.format("%.2f",4.025)); 
		System.out.println(String.format("%.2f",4.045)); 
//		String urlString = "wss://60.29.201.149:8443/websocket/3a429a19-4b5c-4755-9937-3c663c1b8a8";
//		Pattern pattern = Pattern.compile(".*\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:\\d{1,4}/websocket/.*");
//		Matcher matcher = pattern.matcher(urlString);
//		System.out.println(matcher.find());
//		BufferedReader strin = new BufferedReader(new InputStreamReader(
//				System.in));
//		System.out.println("input pizza type:");
//		String str;
//		try {
//			str = strin.readLine();
//			System.out.println(str);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
