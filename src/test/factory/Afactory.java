package test.factory;
/**
 * 简单工厂
 * @author guoqb
 *
 */
public class Afactory {
	public static A createA(String name){
		A a = null;
		if ("Aa".equals(name)) {
			a = new Aa();
		} else if ("Ab".equals(name)){
			a = new Ab();
		}
		return a;
	}
}
