package com.selenium.actions.implementations;

import com.base.HandleException;

class A{
	static public int b = 30;
	int a = 10;
	public void m1(){
		System.out.println("perent method");
	}
}
class B extends A{
	int a = 20;
	public void m1(){
		System.out.println("child method");
	}
}
public class Demo {

	public static void main(String[] args) throws HandleException {
		A a = new A();
		System.out.println(a.a);
		a.m1();
		//a.m1();
		//a.m2();//compile time error
		
		B b = new B();
		System.out.println(b.a);
		b.m1();
		//b.m2();
		
		A ab = new B();
		System.out.println(ab.a);
		ab.m1();
	//	ab.m2(); //compile time error
		
		//B ba = new A();//invalid not allowed
	}
}