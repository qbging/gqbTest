package test.factory;

public class AaA extends A{

	@Override
	public void prepare() {
		super.setAname("AaA");
		System.out.println(name+" preparing");
	}
	
}
