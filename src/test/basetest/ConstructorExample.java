package test.basetest;

//父类
class Foo {
	 int i = 1;
	
	 Foo() {
	     System.out.println(i);             
	     int x = getValue();
	     System.out.println(x);             
	 }
	
	 {
	     i = 2;
	 }
	
	 protected int getValue() {
	     return i;
	 }
}

//子类
class Bar extends Foo {
	 @Override
	 protected int getValue() {
		return j;
	 }
	 int j ;
	
	 Bar() {
	     j = 2;
	 }
	
	 {
	     j = 3;
	 }
	
}

public class ConstructorExample {
 public static void main(String... args) {
     Bar bar = 
    		 new Bar();
     System.out.println(bar.getValue()); 
 }
}/* Output: 
         2
         0
         2
*/