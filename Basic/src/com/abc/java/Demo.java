package com.abc.java;

class A{
	int x = 2;
	
	void set(int t)
	{
		System.out.println("SA " + x);
		this.x = t;
	}
	A()
	{
		System.out.println("DC " + x);
	}
	public String toString()
	{
		return " No is " + x;
	}
}

class B extends A
{
	int x = 5;
	B(int x)
	{
		System.out.println("CB " + x);
		this.x = x;
	}
	void set(int t)
	{
		System.out.println("SB " + x);
		x = t;
	}
	void set()
	{
		System.out.println("SB " + x);
		set(x);
	}
	public String toString()
	{
		return x + super.toString();
	}
}

public class Demo {

	public static void main(String[] args) {

		A x;
		B y;
		x = new A();
		// y = new B();	// constructor not created explicitly
		y = new B(3);
		// x.set();		// 
		
		x.set(4);
		System.out.println(x);
		
		y.set();
		y.set(5);
		System.out.println(y);
		
		System.out.println("Hola " + x.x);
		System.out.println("Hola " + y.x);
		
		
		x = y;
		// x.set(); 	// 
		x.set(6);
		
		System.out.println(x);
		System.out.println(y);
		
		System.out.println(x.x);	// refers base class
		System.out.println(y.x);	// refers derived class
	}

}
