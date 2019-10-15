package test.proxytest;

import java.lang.reflect.Proxy;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calculator = new CalculatorImpl();
		CalculatorHandler handler = new CalculatorHandler(calculator);
		Calculator calProxy = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(), new Class[]{Calculator.class},handler);
		System.out.println(calculator.add(1, 1));
		System.out.println(calProxy.add(1, 1));
		System.out.println(calProxy.minus(1, 1));
	}
}
