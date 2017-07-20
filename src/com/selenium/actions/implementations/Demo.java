package com.selenium.actions.implementations;

import com.base.HandleException;

public class Demo {
	static int a = 10;
	int b = 20;

	public void sum(int...a){
		int total = 0;
		for (int x : a){
			total = total + x;
		}
		System.out.println(total);
	
	}
	public static void main(String[] args) throws HandleException {
		Demo d = new Demo();
		d.sum(23,34);
		d.sum(23,34,54);
		
		
		//int a = 0;
//		d.a = 111;
//		d.b = 222;
//		Demo d2 = new Demo();
//		System.out.println(d2.a);	
		//System.out.println(a);
		
	}
}