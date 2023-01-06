package review;

public class Ex1 {

	int a = 10;
	String nName = "차동원";
	static int b = 20;
	static String sName = "정지윤"; 
	
	public static void main(String[] args) {
		// static
//		System.out.println(a);
//		System.out.println(nName);
		System.out.println(b);
		System.out.println(sName);
		
//		new 할아버지().run();
		
	}
	
	public static void staticMethod() {
		System.out.println(b);
		System.out.println(sName);
//		normalMehtod(); // 메모리에 아직 없음
	}
	
	public void normalMethod() {
		System.out.println(a);
		System.out.println(nName);
		System.out.println(b);
		System.out.println(sName);
		staticMethod(); // 메모리에 이미 올라가있음
	}
	
	
	

}

class Person {
	// 멤버변수
	String name;
	int age;
	
	// 생성자 (객체를 생성하는 방법)
	// => 생성자 오버로딩: 식별이 가능하면 된다!
	public Person() {
//		this.  // 멤버변수, 멤버메서드에 접근
//		this();// 단, 첫줄에 와야함!
	}
	public Person(String name) {
		this.name = name;
	}
	
	public Person(int age) {}
	public Person(String name, int age) {}
	public Person(int age, String name) {}
	
	// 메서드
	// [접근제한자] 리턴타입 메서드명(매개변수, ...) { 구현! }
	void method() {}
	
	// 메서드 오버로딩 (식별이 가능하면 된다!)
	void method(String s) {}
	void mehtod(int i) {}
	int method(String s, int i) { return 0; }
	void method(int i, String s) {}
	void method(String s1, String s2) {}
//	void method(String s2, String s1) {}
	
	// 접근제한자
	// public	: 제한 X
	// protected: 다른 패키지 X, 단 상속관계면 O
	// default	: 다른 패키지 X
	// private	: 클래스 내부만 O
	
}

// 상속
class 할아버지 {
	String house = "이층집";
	public void run() {
		System.out.println("느림");
	}
}

class 아버지 extends 할아버지 {
	String car = "자동차";

	@Override
	public void run() {
		System.out.println("조깅 정도");
	}
}

class 나 extends 아버지 {
	String computer = "컴퓨터";

	@Override
	public void run() {
		System.out.println("개빠름");
	}
}












