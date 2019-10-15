package test.factory;

public class Ab extends A {

	@Override
	public void prepare() {
		super.setAname("Ab");
		System.out.println(name+" preparing");
	}

}
