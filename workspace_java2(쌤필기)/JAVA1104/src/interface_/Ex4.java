package interface_;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 인터페이스의 default 메서드
		 * 충돌 발생 시 예외처리
		 * 1. (super)class vs interface (class Win!)
		 * 2. interface vs interface (반드시 override)
		 * */
		C c = new C();
		c.method();
		
		 SubClass sub = new SubClass();
		 sub.method();
		
	}
}

// 1. (super)class vs interface (class Win!)
class A {
	void method() {
		System.out.println("class A");
	}
}

interface B {
	default void method() {
		System.out.println("interface B");
	}
}

class C extends A implements B {

	@Override
	public void method() {
		System.out.println("class C 에서 재정의한 메서드 호출됨!");
		super.method();
	}
}

// 2. interface vs interface (반드시 override)
interface I1 {
	default void method() {
		System.out.println("I1의 메서드");
	}
}

interface I2 {
	default void method() {
		System.out.println("I2의 메서드");
	}
}

class SubClass implements I1 ,I2 {

	@Override
	public void method() {
//		I1.super.method();
//		I2.super.method();
		System.out.println("SubClass의 메서드");
	}
	
}
















