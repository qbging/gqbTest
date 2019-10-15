package test.factory;

public abstract class A {
	public String name;
	public abstract void prepare();
	
	public void bake()
	{
		System.out.println(name+" baking;");
	}
	public void cut()
	{
		System.out.println(name+" cutting;");
	}
	public void box()
	{
		System.out.println(name+" boxing;");
	}
	public void setAname(String name){
		this.name = name;
	}
}
