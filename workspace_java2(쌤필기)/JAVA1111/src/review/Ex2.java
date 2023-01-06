package review;

public class Ex2 {

	public static void main(String[] args) {
		B b = new E();
		A a = (A)b;
		E e = (E)a;
//		H h = (H)e;
	}
}

class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends B {}
class F extends C {}
class G extends C {}
class H extends E {}






//class P {
//	String name = "P";
//}
//class C extends P {
//	String name = "C";
//}
//class S extends C {
//	String name = "S";
//	public void method() {
//		String name = "로컬";
//		name
//		this.name
//		super.name
//	}
//}



