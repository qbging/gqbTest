package design.jikexueyuan.decorator.coffeebar.decorator;


import design.jikexueyuan.decorator.coffeebar.Drink;
//牛奶
public class Milk extends Decorator {

	public Milk(Drink Obj) {
		super(Obj);
		// TODO Auto-generated constructor stub
		super.setDescription("Milk");
		super.setPrice(2.0f);
	}

}

