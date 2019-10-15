package test.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorHandler implements InvocationHandler {
	private Object obj;
	
	public CalculatorHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getName().equals("add")) {
			System.out.println("before calculatorimpl.add...");
			Object re = method.invoke(obj, args);
			System.out.println("after calculatorimpl.add...");
			return re;
		}else {
			System.out.println("before calculatorimpl.minus...");
			Object re = method.invoke(obj, args);
			System.out.println("after calculatorimpl.minus...");
			return re;
		}
	}

}
