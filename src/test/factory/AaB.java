package test.factory;

public class AaB extends A{

	@Override
	public void prepare() {
		setAname("AaB");
		System.out.println(name+" preparing");
	}

}
