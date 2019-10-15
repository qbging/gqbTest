package design.jikexueyuan.decorator.coffeebar.decorator;


import design.jikexueyuan.decorator.coffeebar.Drink;
//大豆
public class Soy extends Decorator {

	public Soy(Drink Obj) {
		super(Obj);
		// TODO Auto-generated constructor stub
		super.setDescription("Soy");
		super.setPrice(1.5f);
	}

}

