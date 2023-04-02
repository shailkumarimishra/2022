package dsa.stack;

public class A {
	public A() {
		super();
		System.out.println(" A constructor");
	}
public void m1() {
	this.m2();
}
public void m2() {
	System.out.println("Parent A m2()");
}
}
