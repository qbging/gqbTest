package test.factory;

public class Aa extends A {

	@Override
	public void prepare() {
		super.setAname("Aa");
		System.out.println(name+" preparing");
	}

}
