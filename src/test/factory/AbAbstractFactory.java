package test.factory;

public class AbAbstractFactory implements AAbstractfactory {

	@Override
	public A createA(String name) {
		A a = new Ab();
		return a;
	}

}
