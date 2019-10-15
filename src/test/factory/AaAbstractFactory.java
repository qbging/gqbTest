package test.factory;

public class AaAbstractFactory implements AAbstractfactory {

	@Override
	public A createA(String name) {
		A a=null;
		if ("AaA".equals(name)) {
			a = new AaA();
		} else if("AaB".equals(name)){
			a = new AaB();
		}
		return a;
	}

}
