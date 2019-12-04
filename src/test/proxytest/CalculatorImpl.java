package test.proxytest;

public class CalculatorImpl implements Calculator {

	@Override
	public Integer add(Integer num1, Integer num2) {
		Integer re = num1 + num2;
		System.out.println("impl add....");
		return re;
	}

	@Override
	public Integer minus(Integer num1, Integer num2) {
		Integer re = num1 - num2;
		System.out.println("impl minus....");
		return re;
	}

}
